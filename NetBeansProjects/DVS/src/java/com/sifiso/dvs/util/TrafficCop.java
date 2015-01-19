/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import com.sifiso.dvs.gate.dto.RequestDTO;
import com.sifiso.dvs.gate.dto.ResponseDTO;
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
            DataUtil dataUtil, ListUtil listUtil,CloudMsgUtil cloudMsgUtil, PlatformUtil platformUtil) {
        ResponseDTO resp = new ResponseDTO();
        try {
            switch (req.getRequestType()) {
                case RequestDTO.LOGIN_RECEPTIONIST:
                    resp = dataUtil.loginReception(req.getEmail(), req.getPin(), listUtil, platformUtil);
                    break;
                case RequestDTO.LOGIN_DOCTOR:
                    resp = dataUtil.loginDoctor(req.getEmail(), req.getPin(),req.getGcmdevice(), listUtil, platformUtil);
                    break;

                // register
                case RequestDTO.REGISTER_CLIENT:
                    resp = dataUtil.registerClient(req.getClient(), platformUtil);
                    break;
                case RequestDTO.REGISTER_RECEPTIONIST:
                    resp = dataUtil.registerReception(req.getReceptionist(), platformUtil);
                    break;
                case RequestDTO.REGISTER_SURGERY:
                    resp = dataUtil.registerSurgery(req.getSurgery(), platformUtil);
                    break;
                case RequestDTO.REGISTER_DOCTOR:
                    resp = dataUtil.registerDoctor(req.getDoctor(), platformUtil);
                    break;

                // add Method
                case RequestDTO.ADD_DOCTOR_TYPE:
                    resp = dataUtil.addDoctorType(req.getDoctortype(), platformUtil);
                    break;
                case RequestDTO.ADD_MEDICAL_AID:
                    resp = dataUtil.addMedicalAid(req.getMedicalaid(), platformUtil);
                    break;
                case RequestDTO.ADD_PATIENT_FILE:
                    resp = dataUtil.addPatientFile(req.getPatientfile(), platformUtil);
                    break;
                case RequestDTO.ADD_VISIT:
                    resp = dataUtil.addVisit(req.getVisit(),cloudMsgUtil, platformUtil);
                    break;

                //update
                case RequestDTO.UPDATE_VISIT:
                    dataUtil.updateVisit(req.getVisit());
                    break;

                //gets
                case RequestDTO.GET_CLIENT_FILES:
                    resp = listUtil.getClientDataByStand(req.getStandNumber(), req.getDoctorID(), req.getSurgeryID());
                    break;
                case RequestDTO.GET_DOCTOR_DATA:
                    resp = listUtil.getDoctorData(req.getDoctorID());
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
