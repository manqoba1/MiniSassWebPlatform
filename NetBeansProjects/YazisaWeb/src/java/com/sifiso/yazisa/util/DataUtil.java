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
import com.sifiso.yazisa.data.Deviceerror;
import com.sifiso.yazisa.data.Issue;
import com.sifiso.yazisa.data.Parent;
import com.sifiso.yazisa.data.Province;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Student;
import com.sifiso.yazisa.data.Subject;
import com.sifiso.yazisa.data.Teacher;
import com.sifiso.yazisa.data.Teachersubject;
import com.sifiso.yazisa.data.Township;
import com.sifiso.yazisa.dto.AttendenceDTO;
import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.ClazzstudentDTO;
import com.sifiso.yazisa.dto.ClazzteacherDTO;
import com.sifiso.yazisa.dto.IssueDTO;
import com.sifiso.yazisa.dto.ParentDTO;
import com.sifiso.yazisa.dto.SchoolDTO;
import com.sifiso.yazisa.dto.StudentDTO;
import com.sifiso.yazisa.dto.SubjectDTO;
import com.sifiso.yazisa.dto.TeacherDTO;
import com.sifiso.yazisa.dto.TeachersubjectDTO;
import com.sifiso.yazisa.dto.TownshipDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.mail.MessagingException;
import javax.naming.NamingException;
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
    
    public ResponseDTO loginTeacher(String email,
            String password, ListUtil listUtil, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Query q = null;
        try {
            q = em.createNamedQuery("Teacher.login", Teacher.class);
            q.setParameter("email", email);
            q.setParameter("password", password);
            q.setMaxResults(1);
            Teacher ts = (Teacher) q.getSingleResult();
            
            resp.setTeacher(new TeacherDTO(ts));
            resp.setClazzList(listUtil.getTeacherData(ts.getTeacherID()).getClazzList());
            resp.setSubjectList(listUtil.getTeacherData(ts.getTeacherID()).getSubjectList());

            //load appropriate data for each type
        } catch (NoResultException e) {
            log.log(Level.WARNING, "Invalid login attempt: " + email + " pin: " + password, e);
            resp.setStatusCode(301);
            resp.setMessage("Email address or Password are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }
    
    public ResponseDTO loginParent(String email,
            String password, ListUtil listUtil, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        Query q = null;
        try {
            q = em.createNamedQuery("Parent.login", Teacher.class);
            q.setParameter("email", email);
            q.setParameter("password", password);
            q.setMaxResults(1);
            Parent ts = (Parent) q.getSingleResult();
            ParentDTO parentDTO = new ParentDTO(ts);
            for (Student s : ts.getStudentList()) {
                StudentDTO studentDTO = new StudentDTO(s);
                for (Attendence a : s.getAttendenceList()) {
                    AttendenceDTO attendenceDTO = new AttendenceDTO(a);
                    studentDTO.getAttendenceList().add(attendenceDTO);
                }
                for (Issue i : s.getIssueList()) {
                    IssueDTO issueDTO = new IssueDTO(i);
                    studentDTO.getIssueList().add(issueDTO);
                }
                resp.getStudentList().add(studentDTO);
            }
            resp.setParent(parentDTO);
            //load appropriate data for each type
        } catch (NoResultException e) {
            log.log(Level.WARNING, "Invalid login attempt: " + email + " pin: " + password, e);
            resp.setStatusCode(301);
            resp.setMessage("Email address or Password are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }

    public void addDeviceError(Deviceerror d) {
        try {
            em.persist(d);
        } catch (Exception e) {
            
        }
    }

    //register main entity
    public ResponseDTO registerPresent(ArrayList<AttendenceDTO> dto, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            for (AttendenceDTO s : dto) {
                Attendence a = new Attendence();
                a.setDateAttended(new Date(s.getDateAttended()));
                a.setStudent(em.find(Student.class, s.getStudentID()));
                a.setSubject(em.find(Subject.class, s.getSubjectID()));
                a.setAttendenceFlag(a.getAttendenceFlag());
                a.setMessage(s.getMessage());
                a.setTeacher(em.find(Teacher.class, s.getTeacherID()));
                
                em.persist(a);
                em.flush();
                resp.getAttendenceList().add(new AttendenceDTO(a));
            }
            log.log(Level.INFO, "Learner is Present");
            
        } catch (NoResultException ex) {
            log.log(Level.SEVERE, null, ex);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Learner Present");
            platformUtil.addServerError(101, getErrorString(ex), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(ex));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Learner Present");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
            
        }
        return resp;
    }
    
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
    
    public ResponseDTO registerTeacher(TeacherDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Teacher t = new Teacher();
            t.setName(dto.getName());
            t.setSurname(dto.getSurname());
            t.setEmail(dto.getEmail());
            t.setCell(dto.getCell());
            t.setIdnumber(dto.getIdnumber());
            t.setPassword(dto.getPassword());
            
            em.persist(t);
            em.flush();
            
            log.log(Level.INFO, "Teacher Added Successful");
            resp.getTeacherList().add(new TeacherDTO(t));
            resp.setMessage("Teacher Added Successful");
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering teacher");
        }
        return resp;
    }
    
    public ResponseDTO registerStudent(StudentDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Student t = new Student();
            t.setName(dto.getName());
            t.setSurname(dto.getSurname());
            t.setCell(dto.getCell());
            t.setEmail(dto.getEmail());
            t.setIdNumber(dto.getIdNumber());
            t.setPassword(dto.getPassword());
            t.setDateOfBirth(new Date(dto.getDateOfBirth()));
            t.setParent(em.find(Parent.class, dto.getParentID()));
            
            em.persist(t);
            em.flush();
            log.log(Level.INFO, "Learner Added Successful");
            resp.getStudentList().add(new StudentDTO(t));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Learner");
        }
        return resp;
    }
    private EmailUtil emailUtil = new EmailUtil();
    private PasswordGenerator pg = new PasswordGenerator();
    
    public ResponseDTO registerParent(ParentDTO dto, PlatformUtil platformUtil) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Parent t = new Parent();
            t.setParentName(dto.getParentName());
            t.setParentSurname(dto.getParentSurname());
            t.setCell(dto.getCell());
            t.setEmail(dto.getEmail());
            t.setParentIdNo(dto.getParentIdNo());
            t.setPassword(pg.getPassword(dto.getParentSurname()));
            
            em.persist(t);
            em.flush();
            log.log(Level.INFO, "Parent Added Successful");
            resp.getParentList().add(new ParentDTO(t));
            
            if (t.getEmail() != null) {
                String body = "Hi " + t.getParentName() + ",\n "
                        + "Your Sign IN details are:\n\n"
                        + "Password : " + t.getPassword() + "\n\n"
                        + "Please download the app here: ????"
                        + "You may change the after signing in...\n\n"
                        + "Thank you for Trusting Yazisa to take care of your child's future";
                emailUtil.sendEmail(t.getEmail(), "Yazisa Registration Confirmation", body, new CASessionBean());
            }
        } catch (NamingException n) {
            log.log(Level.SEVERE, null, n);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Parent");
        } catch (MessagingException m) {
            log.log(Level.SEVERE, null, m);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Parent");
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Parent");
        }
        return resp;
    }
    
    public ResponseDTO addTownship(TownshipDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Township c = new Township();
            c.setTownshipName(dto.getTownshipName());
            c.setProvince(em.find(Province.class, dto.getProvinceID()));
            
            em.persist(c);
            em.flush();
            log.log(Level.INFO, "Class Added Successful");
            resp.getTownshipList().add(new TownshipDTO(c));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Class");
        }
        return resp;
    }

    //add independent entities
    public ResponseDTO addClass(ClazzDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Clazz c = new Clazz();
            c.setClassName(dto.getClassName());
            c.setTotalStudentsPerClazz(dto.getTotalStudentsPerClazz());
            c.setActiveFlag(1);
            c.setSchool(em.find(School.class, dto.getSchoolID()));
            
            em.persist(c);
            em.flush();
            log.log(Level.INFO, "Class Added Successful");
            resp.getClazzList().add(new ClazzDTO(c));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Class");
        }
        return resp;
    }

    // add relationship entitiees
    public ResponseDTO addClazzStudent(ClazzstudentDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Clazzstudent s = new Clazzstudent();
            s.setClazz(em.find(Clazz.class, dto.getClazzID()));
            s.setStudent(em.find(Student.class, dto.getStudentID()));
            s.setClazzYear(new Date());
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "Clazzstudent Added Successful");
            resp.getClazzstudentList().add(new ClazzstudentDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Clazzstudent");
        }
        return resp;
    }
    
    public ResponseDTO addIssues(IssueDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Issue s = new Issue();
            s.setStudent(em.find(Student.class, dto.getStudentID()));
            s.setTeacher(em.find(Teacher.class, dto.getTeacherID()));
            s.setIssueDate(new Date());
            s.setMessage(dto.getMessage());
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "Issue Added Successful");
            resp.getIssueList().add(new IssueDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Issue");
        }
        return resp;
    }
    
    public ResponseDTO addClazzTeacher(ClazzteacherDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Clazzteacher s = new Clazzteacher();
            s.setClazz(em.find(Clazz.class, dto.getClazzID()));
            s.setTeacher(em.find(Teacher.class, dto.getTeacherID()));
            
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "Clazzteacher Added Successful");
            resp.getClazzteacherList().add(new ClazzteacherDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Clazzteacher");
        }
        return resp;
    }
    
    public ResponseDTO addTeacherSubject(TeachersubjectDTO dto) {
        ResponseDTO resp = new ResponseDTO();
        try {
            Teachersubject s = new Teachersubject();
            s.setSubject(em.find(Subject.class, dto.getSubjectID()));
            s.setTeacher(em.find(Teacher.class, dto.getTeacherID()));
            
            em.persist(s);
            em.flush();
            log.log(Level.INFO, "Teachersubject Added Successful");
            resp.getTeachersubjectList().add(new TeachersubjectDTO(s));
        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(102);
            resp.setMessage("Failed registering Teachersubject");
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
    static final Logger log = Logger.getLogger(DataUtil.class.getSimpleName());
}
