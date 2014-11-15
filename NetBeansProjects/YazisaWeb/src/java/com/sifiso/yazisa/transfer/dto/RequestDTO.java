/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.transfer.dto;

import com.sifiso.yazisa.dto.AbsenteeDTO;
import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.ClazzlearnerDTO;
import com.sifiso.yazisa.dto.ClazzteacherDTO;
import com.sifiso.yazisa.dto.ExamDTO;
import com.sifiso.yazisa.dto.ExammarkDTO;
import com.sifiso.yazisa.dto.HeadmasterDTO;
import com.sifiso.yazisa.dto.LearnersDTO;
import com.sifiso.yazisa.dto.ParentDTO;
import com.sifiso.yazisa.dto.ProvinceDTO;
import com.sifiso.yazisa.dto.SchoolDTO;
import com.sifiso.yazisa.dto.SubclazzDTO;
import com.sifiso.yazisa.dto.SubjectDTO;
import com.sifiso.yazisa.dto.TeachersDTO;
import com.sifiso.yazisa.dto.TeachersubDTO;
import com.sifiso.yazisa.dto.TownshipDTO;
import java.io.Serializable;

/**
 *
 * @author aubreyM
 */
public class RequestDTO implements Serializable {

    private Integer requestType, teacherID, clazzID, subjectID;
    private String username, password, gcmRegistrationID;
    private long absenseeDate;
    private AbsenteeDTO absentee;
    private ClazzDTO clazz;
    private ClazzlearnerDTO clazzlearner;
    private ClazzteacherDTO clazzteacher;
    private TownshipDTO township;
    private ExamDTO exam;
    private ExammarkDTO exammark;
    private HeadmasterDTO headmaster;
    private LearnersDTO learners;
    private ParentDTO parent;
    private ProvinceDTO province;
    private SchoolDTO school;
    private SubclazzDTO subclazz;
    private SubjectDTO subject;
    private TeachersDTO teachers;
    private TeachersubDTO teachersub;

//register actors
    public static final int REGISTER_HEAD_MASTER = 1,
            REGISTER_TEACHER = 2,
            REGISTER_LEARNER = 3,
            REGISTER_ABSENSEE = 4;

    //add stuff
    //get stuff
    public static final int GET_SUB_CLASS_BY_TEACHER = 101,
            GET_ABSENSEE = 102,
            GET_LEARNERS = 103;

    //login's 
    public static final int LOGIN = 200,
            SEND_GCM_REGISTRATION = 204;
    //lookups 

    //updates 
    //invoice * claim
    //reports
    public static final String COMPANY_DIR = "company";
    public static final String COMPANY_STAFF_DIR = "companyStaff";
    public static final String PROJECT_DIR = "project";
    public static final String PROJECT_SITE_DIR = "projectsite";
    public static final String TASK_DIR = "task";

    //
    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public long getAbsenseeDate() {
        return absenseeDate;
    }

    public void setAbsenseeDate(long absenseeDate) {
        this.absenseeDate = absenseeDate;
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

    public AbsenteeDTO getAbsentee() {
        return absentee;
    }

    public void setAbsentee(AbsenteeDTO absentee) {
        this.absentee = absentee;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public ClazzlearnerDTO getClazzlearner() {
        return clazzlearner;
    }

    public void setClazzlearner(ClazzlearnerDTO clazzlearner) {
        this.clazzlearner = clazzlearner;
    }

    public ClazzteacherDTO getClazzteacher() {
        return clazzteacher;
    }

    public void setClazzteacher(ClazzteacherDTO clazzteacher) {
        this.clazzteacher = clazzteacher;
    }

    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public ExammarkDTO getExammark() {
        return exammark;
    }

    public void setExammark(ExammarkDTO exammark) {
        this.exammark = exammark;
    }

    public HeadmasterDTO getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(HeadmasterDTO headmaster) {
        this.headmaster = headmaster;
    }

    public LearnersDTO getLearners() {
        return learners;
    }

    public void setLearners(LearnersDTO learners) {
        this.learners = learners;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
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

    public SubclazzDTO getSubclazz() {
        return subclazz;
    }

    public void setSubclazz(SubclazzDTO subclazz) {
        this.subclazz = subclazz;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public TeachersDTO getTeachers() {
        return teachers;
    }

    public void setTeachers(TeachersDTO teachers) {
        this.teachers = teachers;
    }

    public TeachersubDTO getTeachersub() {
        return teachersub;
    }

    public void setTeachersub(TeachersubDTO teachersub) {
        this.teachersub = teachersub;
    }

}
