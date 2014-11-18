/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.transfer.dto;

import com.sifiso.yazisa.data.Teachers;
import com.sifiso.yazisa.dto.AbsenteeDTO;
import com.sifiso.yazisa.dto.ClazzDTO;
import com.sifiso.yazisa.dto.ClazzlearnerDTO;
import com.sifiso.yazisa.dto.ClazzteacherDTO;
import com.sifiso.yazisa.dto.CountryDTO;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class ResponseDTO {

    private Integer statusCode;
    private String message, sessionID, GCMRegistrationID;
    private List<AbsenteeDTO> absenteeList = new ArrayList<>();
    private List<ClazzDTO> clazzList = new ArrayList<>();
    private List<ClazzlearnerDTO> clazzlearnerList = new ArrayList<>();
    private List<ClazzteacherDTO> clazzteacherList = new ArrayList<>();
    private List<CountryDTO> countryList = new ArrayList<>();
    private List<ExamDTO> examList = new ArrayList<>();
    private List<ExammarkDTO> exammarkList = new ArrayList<>();
    private List<HeadmasterDTO> headmasterList = new ArrayList<>();
    private List<ParentDTO> parentList = new ArrayList<>();
    private List<ProvinceDTO> provinceList = new ArrayList<>();
    private List<SchoolDTO> schoolList = new ArrayList<>();
    private List<SubclazzDTO> subclazzList = new ArrayList<>();
    private List<SubjectDTO> subjectList = new ArrayList<>();
    private List<TeachersDTO> teachersList = new ArrayList<>();
    private List<TeachersubDTO> teachersubList = new ArrayList<>();
    private List<TownshipDTO> townshipList = new ArrayList<>();
    private List<LearnersDTO> learnersList = new ArrayList<>();
    private SubclazzDTO subclazz;
    private TeachersubDTO teachersub;
    private TeachersDTO teachers;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<LearnersDTO> getLearnersList() {
        return learnersList;
    }

    public TeachersDTO getTeachers() {
        return teachers;
    }

    public void setTeachers(TeachersDTO teachers) {
        this.teachers = teachers;
    }

    public void setLearnersList(List<LearnersDTO> learnersList) {
        this.learnersList = learnersList;
    }

    public TeachersubDTO getTeachersub() {
        return teachersub;
    }

    public void setTeachersub(TeachersubDTO teachersub) {
        this.teachersub = teachersub;
    }

    public SubclazzDTO getSubclazz() {
        return subclazz;
    }

    public void setSubclazz(SubclazzDTO subclazz) {
        this.subclazz = subclazz;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getGCMRegistrationID() {
        return GCMRegistrationID;
    }

    public void setGCMRegistrationID(String GCMRegistrationID) {
        this.GCMRegistrationID = GCMRegistrationID;
    }

    public List<AbsenteeDTO> getAbsenteeList() {
        return absenteeList;
    }

    public void setAbsenteeList(List<AbsenteeDTO> absenteeList) {
        this.absenteeList = absenteeList;
    }

    public List<ClazzDTO> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<ClazzDTO> clazzList) {
        this.clazzList = clazzList;
    }

    public List<ClazzlearnerDTO> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<ClazzlearnerDTO> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public List<ClazzteacherDTO> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<ClazzteacherDTO> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

    public List<ExamDTO> getExamList() {
        return examList;
    }

    public void setExamList(List<ExamDTO> examList) {
        this.examList = examList;
    }

    public List<ExammarkDTO> getExammarkList() {
        return exammarkList;
    }

    public void setExammarkList(List<ExammarkDTO> exammarkList) {
        this.exammarkList = exammarkList;
    }

    public List<HeadmasterDTO> getHeadmasterList() {
        return headmasterList;
    }

    public void setHeadmasterList(List<HeadmasterDTO> headmasterList) {
        this.headmasterList = headmasterList;
    }

    public List<ParentDTO> getParentList() {
        return parentList;
    }

    public void setParentList(List<ParentDTO> parentList) {
        this.parentList = parentList;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

    public List<SchoolDTO> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<SchoolDTO> schoolList) {
        this.schoolList = schoolList;
    }

    public List<SubclazzDTO> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<SubclazzDTO> subclazzList) {
        this.subclazzList = subclazzList;
    }

    public List<SubjectDTO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectDTO> subjectList) {
        this.subjectList = subjectList;
    }

    public List<TeachersDTO> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<TeachersDTO> teachersList) {
        this.teachersList = teachersList;
    }

    public List<TeachersubDTO> getTeachersubList() {
        return teachersubList;
    }

    public void setTeachersubList(List<TeachersubDTO> teachersubList) {
        this.teachersubList = teachersubList;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

}
