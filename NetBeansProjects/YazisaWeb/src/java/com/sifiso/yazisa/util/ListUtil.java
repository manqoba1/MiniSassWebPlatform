/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Attendence;
import com.sifiso.yazisa.data.Clazz;
import com.sifiso.yazisa.data.Clazzstudent;
import com.sifiso.yazisa.data.Clazzteacher;
import com.sifiso.yazisa.data.Issue;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Student;
import com.sifiso.yazisa.data.Subject;
import com.sifiso.yazisa.data.Teachersubject;
import com.sifiso.yazisa.dto.AttendenceDTO;
import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.ClazzstudentDTO;
import com.sifiso.yazisa.dto.IssueDTO;
import com.sifiso.yazisa.dto.StudentDTO;
import com.sifiso.yazisa.dto.SubjectDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
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
    
    public School getSchoolByID(int schoolID) {
        return em.find(School.class, schoolID);
    }
    
    public ResponseDTO getTeacherData(int teacherID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            List<ClazzDTO> clazzList = getClazzList(teacherID);
            List<SubjectDTO> subjectList = getSubjectList(teacherID);
            resp.setClazzList(clazzList);
            resp.setSubjectList(subjectList);
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error, Not Stupid", e);
            resp.setMessage("Sorry Error getting data");
            resp.setStatusCode(101);
        }
        return resp;
    }
    
    private List<ClazzDTO> getClazzList(int teacherID) {
        List<ClazzDTO> clazz = new ArrayList<>();
        
        Query q = em.createNamedQuery("Clazzteacher.findClazzByTeacher", Clazz.class);
        q.setParameter("teacherID", teacherID);
        List<Clazzteacher> list = q.getResultList();
        for (Clazzteacher c : list) {
            ClazzDTO cd = new ClazzDTO(c.getClazz());
            clazz.add(cd);
        }
        return clazz;
    }
    
    private List<SubjectDTO> getSubjectList(int teacherID) {
        List<SubjectDTO> subject = new ArrayList<>();
        
        Query q = em.createNamedQuery("Teachersubject.findSubjectByTeacher", Subject.class);
        q.setParameter("teacherID", teacherID);
        List<Teachersubject> list = q.getResultList();
        for (Teachersubject c : list) {
            SubjectDTO cd = new SubjectDTO(c.getSubject());
            subject.add(cd);
        }
        return subject;
    }
    
    public ResponseDTO getStudentDataByID(Integer studentID) {
        ResponseDTO resp = new ResponseDTO();
        Query q = em.createNamedQuery("Student.findByStudentID", Student.class);
        q.setParameter("studentID", studentID);
        Student student = (Student) q.getSingleResult();        
        StudentDTO studentDTO = new StudentDTO(student);        
        studentDTO.setAttendenceList(getAttendanceStudentByID(studentID));        
        studentDTO.setIssueList(getIssuesByStudent(studentID));        
        studentDTO.setClazzstudentList(getClazzStudentByID(studentID));
        resp.setStudent(studentDTO);
        log.log(Level.INFO, "Late{0}", resp);
        return resp;
    }
    
    private List<AttendenceDTO> getAttendanceStudentByID(Integer studentID) {
        List<AttendenceDTO> clazz = new ArrayList<>();
        Query q = em.createNamedQuery("Attendence.findByStudentID", Attendence.class);
        q.setParameter("studentID", studentID);
        List<Attendence> list = q.getResultList();
        for (Attendence c : list) {
            clazz.add(new AttendenceDTO(c));
        }
        return clazz;
    }
    
    private List<ClazzstudentDTO> getClazzStudentByID(Integer studentID) {
        List<ClazzstudentDTO> clazz = new ArrayList<>();
        Query q = em.createNamedQuery("Clazzstudent.findByStudentID", Clazzstudent.class);
        q.setParameter("studentID", studentID);
        List<Clazzstudent> list = q.getResultList();
        for (Clazzstudent c : list) {
            clazz.add(new ClazzstudentDTO(c));
        }
        return clazz;
    }
    
    private List<IssueDTO> getIssuesByStudent(Integer studentID) {
        List<IssueDTO> issue = new ArrayList<>();
        Query q = em.createNamedQuery("Issue.findByStudent", Issue.class);
        q.setParameter("studentID", studentID);
        List<Issue> issues = q.getResultList();
        for (Issue i : issues) {
            issue.add(new IssueDTO(i));
        }
        return issue;
    }
    
    public ResponseDTO getStudentList(int clazzID) {
        ResponseDTO resp = new ResponseDTO();
        
        Query q = em.createNamedQuery("Clazzstudent.findStudentByClass", Clazzstudent.class);
        q.setParameter("clazzID", clazzID);
        List<Clazzstudent> list = q.getResultList();
        for (Clazzstudent c : list) {
            int ab = 0, pre = 0, la = 0;
            StudentDTO cd = new StudentDTO(c.getStudent());
            ab = attendanceCounts(c.getStudent().getStudentID(), 1);
            pre = attendanceCounts(c.getStudent().getStudentID(), 2);
            la = attendanceCounts(c.getStudent().getStudentID(), 3);
            
            for (Attendence a : c.getStudent().getAttendenceList()) {
                AttendenceDTO attendence = new AttendenceDTO(a);
                // cd.getAttendenceList().add(attendence);
                resp.getAttendenceList().add(attendence);
            }
            cd.setCountAbsent(ab);
            cd.setCountAttendant(pre);
            cd.setCountLate(la);
            for (Issue i : c.getStudent().getIssueList()) {
                IssueDTO issue = new IssueDTO(i);
                //cd.getIssueList().add(issue);
                resp.getIssueList().add(issue);
            }
            
            resp.getStudentList().add(cd);
        }
        log.log(Level.INFO, "Late{0}", resp.toString());
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
    
    public int attendanceCounts(int studentID, int flag) {
        int row = 0;
        Query q = em.createNamedQuery("Attendence.findByStudent", Attendence.class);
        q.setParameter("studentID", studentID);
        q.setParameter("flag", flag);
        
        List<Attendence> list = q.getResultList();
        row = list.size();
        return row;
    }
    static final Logger log = Logger.getLogger(ListUtil.class.getSimpleName());
}
