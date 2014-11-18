/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.transfer.dto.RequestDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aubreyM
 */
@Stateless
public class TrafficCop {

    public ResponseDTO processRequest(RequestDTO req,
            DataUtil dataUtil, ListUtil listUtil, PlatformUtil platformUtil) {
        ResponseDTO resp = new ResponseDTO();
        try {
            switch (req.getRequestType()) {

                case RequestDTO.LOGIN:
                    resp = dataUtil.login(
                            req.getUsername(), req.getPassword(),
                            listUtil, platformUtil);
                    break;
                case RequestDTO.REGISTER_ABSENSEE:
                   // resp = dataUtil.registerAbsence(req.getAbsentee(),platformUtil);
                    break;
                case RequestDTO.GET_ABSENSEE:
                    resp = listUtil.getAbsence(req.getAbsenseeDate());
                    break;
                case RequestDTO.GET_LEARNERS:
                    resp = listUtil.getStudentClassListByID(req.getClazzID(), req.getSubjectID());
                    break;
                case RequestDTO.GET_SUB_CLASS_BY_TEACHER:
                    resp = listUtil.getSubclassListByID();
                    break;
            }
        } catch (DataException e) {
            resp.setStatusCode(101);
            resp.setMessage("Data service failed to process your request");
            logger.log(Level.SEVERE, "Database related failure", e);

        } catch (Exception e) {
            resp.setStatusCode(102);
            resp.setMessage("Server process failed to process your request");
            logger.log(Level.SEVERE, "Generic server related failure", e);

        }
        if (resp.getStatusCode() == null) {
            resp.setStatusCode(0);
        }
        return resp;
    }

    @PersistenceContext
    EntityManager em;
    static final Logger logger = Logger.getLogger(TrafficCop.class.getSimpleName());
}
