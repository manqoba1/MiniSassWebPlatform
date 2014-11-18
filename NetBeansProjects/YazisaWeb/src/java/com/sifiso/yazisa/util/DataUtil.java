/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Absentee;
import com.sifiso.yazisa.data.Clazzlearner;
import com.sifiso.yazisa.data.Learners;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Subclazz;
import com.sifiso.yazisa.data.Teachers;
import com.sifiso.yazisa.data.Teachersub;
import com.sifiso.yazisa.data.Township;
import com.sifiso.yazisa.dto.AbsenteeDTO;
import com.sifiso.yazisa.dto.LearnersDTO;
import com.sifiso.yazisa.dto.SchoolDTO;
import com.sifiso.yazisa.dto.SubclazzDTO;
import com.sifiso.yazisa.dto.TeachersDTO;
import com.sifiso.yazisa.dto.TeachersubDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
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
            resp.setMessage("Email address or Password are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }

    public ResponseDTO registerAbsence(int learnerID, int clazzID, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Clazzlearner.findLeanerAndClass", Clazzlearner.class);
            q.setParameter("learnerID", learnerID);
            q.setParameter("clazzID", clazzID);

            Clazzlearner ps = (Clazzlearner) q.getSingleResult();

            Absentee a = new Absentee();
            a.setAbsentDate(new Date());
            a.setLateForClass(0);

            if (ps != null) {
                a.setClazzLearner(ps);
            }
            em.merge(ps);
            em.flush();
            log.log(Level.INFO, "Learner is Absent");
            resp.getAbsenteeList().add(new AbsenteeDTO(a));
        } catch (NoResultException ex) {
            log.log(Level.SEVERE, null, ex);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Learner Absent");
            platformUtil.addServerError(101, getErrorString(ex), "DataUtil");
            throw new DataException("Failed to register Absent:\n" + getErrorString(ex));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Learner Absent");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Absent:\n" + getErrorString(e));

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

    public ResponseDTO registerSchool(SchoolDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Township t = em.find(Township.class, dto.getTownshipID());
            School s = new School();
            s.setSchoolName(dto.getSchoolName());
            s.setAddress(dto.getAddress());
            s.setEmail(dto.getEmail());
            s.setTell(dto.getTell());
            s.setPostalCode(dto.getPostalCode());

            if (t != null) {
                s.setTownship(t);
            }
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "School Added");
            resp.getSchoolList().add(new SchoolDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed Adding School;");
            throw new DataException("Failed to Register School:\n" + getErrorString(e));

        }
        return resp;
    }

    public ResponseDTO RegisterTeacher(TeachersDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Teachers t = new Teachers();
            t.setName(dto.getName());
            t.setSurname(dto.getSurname());
            t.setEmail(dto.getEmail());
            t.setCell(dto.getCell());            
            t.setIdnumber(dto.getIdnumber());
            t.setUsername(dto.getUsername());
            t.setPassword(dto.getPassword());
            t.setSchool(em.find(School.class, dto.getSchoolID()));
            
            em.persist(t);
            em.flush();
            log.log(Level.INFO, "Teacher Added Successful");
            resp.getTeachersList().add(new TeachersDTO(t));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering teacher");
        }
        return resp;
    }

    public ResponseDTO RegisterLearner(LearnersDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Learners t = new Learners();
            t.setName(dto.getName());
            t.setSurname(dto.getSurname());
            t.setCell(dto.getCell());            
            t.setEmail(dto.getEmail());
            t.setIdnumber(dto.getIdnumber());
            t.setUsername(dto.getUsername());
            t.setPassword(dto.getPassword());
            //t.setsetSchool(em.find(School.class, dto.getSchoolID()));
            
            em.persist(t);
            em.flush();
            log.log(Level.INFO, "Teacher Added Successful");
         //   resp.getTeachersList().add(new TeachersDTO(t));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering teacher");
        }
        return resp;
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
