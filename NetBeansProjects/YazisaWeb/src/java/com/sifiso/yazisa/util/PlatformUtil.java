/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Deviceerror;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Servererror;
import com.sifiso.yazisa.dto.DeviceerrorDTO;
import com.sifiso.yazisa.dto.ServererrorDTO;
import com.sifiso.yazisa.transfer.dto.RequestDTO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.joda.time.DateTime;

/**
 *
 * @author CodeTribe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PlatformUtil {

    @PersistenceContext
    EntityManager em;
    static Logger log = Logger.getLogger(PlatformUtil.class.getSimpleName());

    public void addTimeElapsedWarning(long start, long end, RequestDTO dto, String origin) {
        if (dto == null) {
            dto = new RequestDTO();
        }
        if (end - start > (1000 * THRESHOLD_SECONDS)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Servlet took more than ").append(THRESHOLD_SECONDS)
                    .append(" seconds to process request\nRequest type is ")
                    .append(dto.getRequestType()).append("\n");
            sb.append("Elapsed time in seconds: ").append(Elapsed.getElapsed(start, end));
            addServerError(111, sb.toString(), origin);
        }
    }

    public void addServerError(int statusCode, String message, String origin) {
        try {
            Servererror s = new Servererror();
            s.setDateOccured(new Date());
            s.setMessage(message);
            s.setOrigin(origin);
            s.setStatusCode(statusCode);
            em.persist(s);
            log.log(Level.INFO, "####### ErrorStore row added, origin {0} \nmessage: {1}",
                    new Object[]{origin, message});
        } catch (Exception e) {
            //addServerError(dto);
            log.log(Level.SEVERE, "*** Not Stupid ***", e);

        }
    }

    public void addDeviceError(DeviceerrorDTO dto) {
        try {
            Deviceerror s = new Deviceerror();
            s.setAndroidVersion(dto.getAndroidVersion());
            s.setAppVersionCode(dto.getAppVersionCode());
            s.setAppVersionName(dto.getAppVersionName());
            s.setBrand(dto.getBrand());
            s.setErrorDate(new Date());
            s.setLogCat(dto.getLogCat());
            s.setStackTrace(dto.getBrand());
            s.setPackageName(dto.getPackageName());
            s.setPhoneModel(dto.getPhoneModel());
            s.setSchool(em.find(School.class, dto.getSchoolID()));

            em.persist(s);
            log.log(Level.INFO, "####### ErrorStore row added, origin {0} \nmessage: {1}",
                    s);
        } catch (Exception e) {
            //addServerError(dto);
            log.log(Level.SEVERE, "*** Not Stupid ***", e);

        }
    }
    static final int THRESHOLD_SECONDS = 6;
    public static final int ERROR_DATABASE = 111, ERROR_SERVER = 112,
            SIGNIFICANT_EVENT = 0, ERROR_WEBSOCKET = 113, ERROR_UNKNOWN_REQUEST = 114;
}
