/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.transfer.dto;

import com.sifiso.yazisa.dto.AttendenceDTO;

import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.ClazzstudentDTO;

import com.sifiso.yazisa.dto.ClazzteacherDTO;
import com.sifiso.yazisa.dto.CountryDTO;
import com.sifiso.yazisa.dto.DeviceerrorDTO;

import com.sifiso.yazisa.dto.GcmdeviceDTO;
import com.sifiso.yazisa.dto.IssueDTO;

import com.sifiso.yazisa.dto.ParentDTO;
import com.sifiso.yazisa.dto.ProvinceDTO;
import com.sifiso.yazisa.dto.SchoolDTO;

import com.sifiso.yazisa.dto.ServererrorDTO;
import com.sifiso.yazisa.dto.StudentDTO;
import com.sifiso.yazisa.dto.SubjectDTO;
import com.sifiso.yazisa.dto.TeacherDTO;

import com.sifiso.yazisa.dto.TeachersubjectDTO;
import com.sifiso.yazisa.dto.TownshipDTO;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aubreyM
 */
public class RequestDTO implements Serializable {

    private Integer requestType, teacherID, clazzID, subjectID;
    private String username, password, gcmRegistrationID, sessionID;
    private long absenseeDate;

    private AttendenceDTO attendence;
    private ClazzteacherDTO clazzteacher;
    private CountryDTO country;
    private DeviceerrorDTO deviceerror;
    private ClazzstudentDTO clazzstudent;
    private ParentDTO parent;
    private GcmdeviceDTO gcmdevice;
    private ServererrorDTO servererror;
    private TeachersubjectDTO teachersubject;
    private ClazzDTO clazz;
    private TownshipDTO township;
    private ProvinceDTO province;
    private SchoolDTO school;
    private StudentDTO student;
    private SubjectDTO subject;
    private TeacherDTO teacher;
    private IssueDTO issue;

    private ArrayList<AttendenceDTO> attendenceList = new ArrayList<>();
//register actors
    public static final int REGISTER_HEAD_MASTER = 1,
            REGISTER_TEACHER = 2,
            REGISTER_LEARNER = 3,
            REGISTER_ATTENDENCE = 4,
            REGISTER_PARENT = 5,
            REGISTER_STUDENT = 6;

    //add stuff
    //get stuff
    public static final int GET_SUB_CLASS_BY_TEACHER = 101,
            GET_ABSENSEE = 102,
            GET_LEARNERS = 103;

    //login's 
    public static final int LOGIN_TEACHER = 200,
            LOGIN_PARENT = 201,
            SEND_GCM_REGISTRATION = 204;
    //lookups 
    public static final int SEND_PARENT_REPORT = 300,
            ADD_CLASS_TEACHER = 301,
            ADD_CLASS_STUDENT = 302,
            ADD_ISSUE = 303,
            ADD_SUBJECT = 304,
            ADD_TEACHER_SUBJECT = 305,
            ADD_CLASS = 306;
    //updates 
    //invoice * claim
    //reports
    public static final String SCHOOL_DIR = "school";
    public static final String CLASS_DIR = "class";
    public static final String PARENT_DIR = "parent";
    public static final String TEACHER_DIR = "teacher";
    public static final String STUDENT_DIR = "student";

    //
    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
    }

    public ClazzteacherDTO getClazzteacher() {
        return clazzteacher;
    }

    public void setClazzteacher(ClazzteacherDTO clazzteacher) {
        this.clazzteacher = clazzteacher;
    }

    public ArrayList<AttendenceDTO> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(ArrayList<AttendenceDTO> attendenceList) {
        this.attendenceList = attendenceList;
    }

    public AttendenceDTO getAttendence() {
        return attendence;
    }

    public void setAttendence(AttendenceDTO attendence) {
        this.attendence = attendence;
    }

    public DeviceerrorDTO getDeviceerror() {
        return deviceerror;
    }

    public void setDeviceerror(DeviceerrorDTO deviceerror) {
        this.deviceerror = deviceerror;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public Integer getClazzID() {
        return clazzID;
    }

    public void setClazzID(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGcmRegistrationID() {
        return gcmRegistrationID;
    }

    public void setGcmRegistrationID(String gcmRegistrationID) {
        this.gcmRegistrationID = gcmRegistrationID;
    }

    public long getAbsenseeDate() {
        return absenseeDate;
    }

    public void setAbsenseeDate(long absenseeDate) {
        this.absenseeDate = absenseeDate;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public ClazzstudentDTO getClazzstudent() {
        return clazzstudent;
    }

    public void setClazzstudent(ClazzstudentDTO clazzstudent) {
        this.clazzstudent = clazzstudent;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public GcmdeviceDTO getGcmdevice() {
        return gcmdevice;
    }

    public void setGcmdevice(GcmdeviceDTO gcmdevice) {
        this.gcmdevice = gcmdevice;
    }

    public ServererrorDTO getServererror() {
        return servererror;
    }

    public void setServererror(ServererrorDTO servererror) {
        this.servererror = servererror;
    }

    public TeachersubjectDTO getTeachersubject() {
        return teachersubject;
    }

    public void setTeachersubject(TeachersubjectDTO teachersubject) {
        this.teachersubject = teachersubject;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

}
