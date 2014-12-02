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

                case RequestDTO.LOGIN_TEACHER:
                    resp = dataUtil.loginTeacher(
                            req.getUsername(), req.getPassword(),
                            listUtil, platformUtil);
                    break;
                case RequestDTO.LOGIN_PARENT:
                    resp = dataUtil.loginParent(req.getUsername(), req.getPassword(),
                            listUtil, platformUtil);
                    break;
                case RequestDTO.GET_LEARNERS:
                    resp = listUtil.getStudentList(req.getClazzID());
                    break;
                case RequestDTO.ADD_CLASS_STUDENT:
                    resp = dataUtil.addClazzStudent(req.getClazzstudent());
                    break;
                case RequestDTO.ADD_CLASS_TEACHER:
                    resp = dataUtil.addClazzTeacher(req.getClazzteacher());
                    break;
                case RequestDTO.ADD_ISSUE:
                    resp = dataUtil.addIssues(req.getIssue());
                    break;
                case RequestDTO.ADD_TEACHER_SUBJECT:
                    resp = dataUtil.addTeacherSubject(req.getTeachersubject());
                    break;
                case RequestDTO.ADD_CLASS:
                    resp = dataUtil.addClass(req.getClazz());
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
