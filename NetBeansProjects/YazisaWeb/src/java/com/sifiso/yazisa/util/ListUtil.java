/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Absentee;
import com.sifiso.yazisa.data.Clazz;
import com.sifiso.yazisa.data.Learners;
import com.sifiso.yazisa.data.Subclazz;
import com.sifiso.yazisa.data.Subject;
import com.sifiso.yazisa.data.Teachersub;
import com.sifiso.yazisa.dto.AbsenteeDTO;
import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.LearnersDTO;
import com.sifiso.yazisa.dto.SubclazzDTO;
import com.sifiso.yazisa.dto.SubjectDTO;
import com.sifiso.yazisa.dto.TeachersubDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author aubreyM
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ListUtil {
    
    @PersistenceContext
    EntityManager em;
    
    public ResponseDTO getStudentClassListByID(int clazzID, int subjectID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Subclazz.findBySubjectAndClass", Subclazz.class);
        q.setParameter("clazzID", clazzID);
        q.setParameter("subjectID", subjectID);
        
        List<Subclazz> list = q.getResultList();
        
        for (Subclazz cp : list) {
            resp.getLearnersList().add(new LearnersDTO(cp.getLearners()));
        }
        return resp;
    }
    
    public ResponseDTO getAbsence(long dateAbsence) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Absentee.findByAbsentDate", Absentee.class);
        q.setParameter("absentDate", new Date(dateAbsence));        
        
        List<Absentee> list = q.getResultList();
        
        for (Absentee cp : list) {
            resp.getAbsenteeList().add(new AbsenteeDTO(cp));
        }
        return resp;
    }
    
    public static long getSimpleDate(Date date, int day) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(GregorianCalendar.HOUR_OF_DAY, 0);
        cal.set(GregorianCalendar.MINUTE, 0);
        cal.set(GregorianCalendar.SECOND, 0);
        cal.set(GregorianCalendar.MILLISECOND, 0);
        if (day > 0) {
            cal.set(GregorianCalendar.DAY_OF_MONTH, cal.get(GregorianCalendar.DAY_OF_MONTH) - day);
        }
        return cal.getTimeInMillis();
    }
    
    public ResponseDTO getSubclassListByID(int teacherID) {
        ResponseDTO resp = new ResponseDTO();
        
        Query q = em.createNamedQuery("Teachersub.findByTeacher", Teachersub.class);
        q.setParameter("teacherID", teacherID);
        List<Teachersub> list = q.getResultList();
        List<ClazzDTO> clazzDTOs = getClazzList();
        List<SubjectDTO> subclazzDTOs = getSubjectList();
        List<LearnersDTO> learnerses = getLearnerList();
        for (Teachersub cp : list) {
            TeachersubDTO cn = new TeachersubDTO(cp);
            for (ClazzDTO c : clazzDTOs) {
                if (cn.getSubclazz().getClazz().getClazzID() == c.getClazzID()) {
                    resp.getClazzList().add(c);
                }
            }
            for (SubjectDTO s : subclazzDTOs) {
                if (cn.getSubclazz().getSubject().getSubjectID() == s.getSubjectID()) {
                    resp.getSubjectList().add(s);
                }
            }
            for (LearnersDTO l : learnerses) {
                if (cn.getSubclazz().getLearners().getLearnersID() == l.getLearnersID()) {
                    resp.getLearnersList().add(l);
                }
            }
        }
        return resp;
    }
    
    private List<ClazzDTO> getClazzList() {
        List<ClazzDTO> clazz = new ArrayList<>();
        
        Query q = em.createNamedQuery("Clazz.findAll", Clazz.class);
        List<Clazz> list = q.getResultList();
        for (Clazz c : list) {
            ClazzDTO cd = new ClazzDTO(c);
            clazz.add(cd);
        }
        return clazz;
    }
    
    private List<SubjectDTO> getSubjectList() {
        List<SubjectDTO> subject = new ArrayList<>();
        
        Query q = em.createNamedQuery("Subject.findAll", Subject.class);
        List<Subject> list = q.getResultList();
        for (Subject c : list) {
            SubjectDTO cd = new SubjectDTO(c);
            subject.add(cd);
        }
        return subject;
    }
    
    private List<LearnersDTO> getLearnerList() {
        List<LearnersDTO> learners = new ArrayList<>();
        
        Query q = em.createNamedQuery("Learners.findAll", Learners.class);
        List<Learners> list = q.getResultList();
        for (Learners c : list) {
            LearnersDTO cd = new LearnersDTO(c);
            learners.add(cd);
        }
        return learners;
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
    static final Logger log = Logger.getLogger(ListUtil.class.getSimpleName());
}
