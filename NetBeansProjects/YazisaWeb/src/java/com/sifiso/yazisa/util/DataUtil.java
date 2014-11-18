/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Absentee;
import com.sifiso.yazisa.data.Clazz;
import com.sifiso.yazisa.data.Clazzlearner;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Subclazz;
import com.sifiso.yazisa.data.Teachers;
import com.sifiso.yazisa.data.Teachersub;
import com.sifiso.yazisa.data.Township;
import com.sifiso.yazisa.dto.AbsenteeDTO;
import com.sifiso.yazisa.dto.ClazzlearnerDTO;
import com.sifiso.yazisa.dto.SchoolDTO;
import com.sifiso.yazisa.dto.SubclazzDTO;
import com.sifiso.yazisa.dto.TeachersDTO;
import com.sifiso.yazisa.dto.TeachersubDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {

    @PersistenceContext
    EntityManager em;

    static final int OPERATIONS_MANAGER = 1,
            SITE_SUPERVISOR = 2,
            EXECUTIVE_STAFF = 3,
            PROJECT_MANAGER = 4;

    public ResponseDTO login(String username,
            String password, ListUtil listUtil, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Query q = null;
        try {
            q = em.createNamedQuery("Teachersub.login", Teachersub.class);
            q.setParameter("username", username);
            q.setParameter("password", password);
            q.setMaxResults(1);
            Teachersub ts = (Teachersub) q.getSingleResult();
            Subclazz subclazz = ts.getSubclazz();
            resp.setSubclazz(new SubclazzDTO(subclazz));
            resp.setTeachersub(new TeachersubDTO(ts));
            resp.setTeachers(new TeachersDTO(ts.getTeacher()));

            //resp.setLearnersList(listUtil.getSubclassListByID(ts.getTeacher().getTeacherID()).getLearnersList());
            resp.setClazzList(listUtil.getSubclassListByID().getClazzList());
            resp.setSubjectList(listUtil.getSubclassListByID().getSubjectList());

            //load appropriate data for each type
        } catch (NoResultException e) {
            log.log(Level.WARNING, "Invalid login attempt: " + username + " pin: " + password, e);
            resp.setStatusCode(301);
            resp.setMessage("Email address or PIN are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }

    public ResponseDTO registerAbsence(AbsenteeDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Clazzlearner ps = em.find(Clazzlearner.class, dto.getClazzLearner().getClazzLearnerID());

            Absentee a = new Absentee();
            a.setAbsentDate(new Date());
            a.setLateForClass(dto.getLateForClass());

            if (ps != null) {
                a.setClazzLearner(ps);
            }
            em.merge(ps);
            em.flush();
            resp.getAbsenteeList().add(new AbsenteeDTO(a));
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update projectSite\n" + getErrorString(e));
        }
        return resp;
    }
    /*  public void updateProjectSite(ProjectSiteDTO dto) throws DataException {
     try {
     ProjectSite ps = em.find(ProjectSite.class, dto.getProjectSiteID());
     if (ps != null) {
     if (dto.getProjectSiteName() != null) {
     ps.setProjectSiteName(dto.getProjectSiteName());
     }
     if (dto.getStandErfNumber() != null) {
     ps.setStandErfNumber(dto.getStandErfNumber());
     }
     if (dto.getLatitude() != null) {
     ps.setLatitude(dto.getLatitude());
     }
     if (dto.getLongitude() != null) {
     ps.setLongitude(dto.getLongitude());
     }
     em.merge(ps);
     log.log(Level.INFO, "Project Site updated");
     }
     } catch (Exception e) {
     log.log(Level.OFF, null, e);
     throw new DataException("Failed to update projectSite\n" + getErrorString(e));
     }
     }*/

    public void registerSchool(SchoolDTO dto, int townshipID) throws DataException {
        School s = new School();
        try {
            Township t = em.find(Township.class, townshipID);

            s.setSchoolName(dto.getSchoolName());
            
            if (t != null) {
                s.setTownship(t);
            }
            em.persist(s);

        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to Register School:\n" + getErrorString(e));
        }
    }

    public void RegisterTeacher(TeachersDTO dto) {
        Teachers t = new Teachers();
    }

    public String getErrorString(Exception e) {
        StringBuilder sb = new StringBuilder();
        if (e.getMessage() != null) {
            sb.append(e.getMessage()).append("\n\n");
        }
        if (e.toString() != null) {
            sb.append(e.toString()).append("\n\n");
        }
        StackTraceElement[] s = e.getStackTrace();
        if (s.length > 0) {
            StackTraceElement ss = s[0];
            String method = ss.getMethodName();
            String cls = ss.getClassName();
            int line = ss.getLineNumber();
            sb.append("Class: ").append(cls).append("\n");
            sb.append("Method: ").append(method).append("\n");
            sb.append("Line Number: ").append(line).append("\n");
        }

        return sb.toString();
    }

    static final Logger log = Logger.getLogger(DataUtil.class.getSimpleName());
}
