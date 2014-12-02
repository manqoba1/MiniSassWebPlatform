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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aubreyM
 */
public class ResponseDTO {

    private Integer statusCode;
    private String message, sessionID, GCMRegistrationID;

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

    private List<IssueDTO> issueList = new ArrayList<>();
    private List<AttendenceDTO> attendenceList = new ArrayList<>();
    private List<ClazzstudentDTO> clazzstudentList = new ArrayList<>();
    private List<ClazzteacherDTO> clazzteacherList = new ArrayList<>();
    private List<DeviceerrorDTO> deviceerrorList = new ArrayList<>();
    private List<GcmdeviceDTO> gcmdeviceList = new ArrayList<>();
    private List<ServererrorDTO> servererrorList = new ArrayList<>();
    private List<ClazzDTO> clazzList = new ArrayList<>();
    private List<CountryDTO> countryList = new ArrayList<>();
    private List<ParentDTO> parentList = new ArrayList<>();
    private List<ProvinceDTO> provinceList = new ArrayList<>();
    private List<SchoolDTO> schoolList = new ArrayList<>();
    private List<SubjectDTO> subjectList = new ArrayList<>();
    private List<TeachersubjectDTO> teachersubjectList = new ArrayList<>();
    private List<TownshipDTO> townshipList = new ArrayList<>();
    private List<StudentDTO> studentList = new ArrayList<>();
    private List<TeacherDTO> teacherList = new ArrayList<>();

    public IssueDTO getIssue() {
        return issue;
    }

    public void setIssue(IssueDTO issue) {
        this.issue = issue;
    }

    public List<IssueDTO> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<IssueDTO> issueList) {
        this.issueList = issueList;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
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

    public AttendenceDTO getAttendence() {
        return attendence;
    }

    public void setAttendence(AttendenceDTO attendence) {
        this.attendence = attendence;
    }

    public ClazzteacherDTO getClazzteacher() {
        return clazzteacher;
    }

    public void setClazzteacher(ClazzteacherDTO clazzteacher) {
        this.clazzteacher = clazzteacher;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public DeviceerrorDTO getDeviceerror() {
        return deviceerror;
    }

    public void setDeviceerror(DeviceerrorDTO deviceerror) {
        this.deviceerror = deviceerror;
    }

    public ClazzstudentDTO getClazzstudent() {
        return clazzstudent;
    }

    public void setClazzstudent(ClazzstudentDTO clazzstudent) {
        this.clazzstudent = clazzstudent;
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

    public List<AttendenceDTO> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<AttendenceDTO> attendenceList) {
        this.attendenceList = attendenceList;
    }

    public List<ClazzstudentDTO> getClazzstudentList() {
        return clazzstudentList;
    }

    public void setClazzstudentList(List<ClazzstudentDTO> clazzstudentList) {
        this.clazzstudentList = clazzstudentList;
    }

    public List<ClazzteacherDTO> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<ClazzteacherDTO> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<DeviceerrorDTO> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<DeviceerrorDTO> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public List<GcmdeviceDTO> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<GcmdeviceDTO> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    public List<ServererrorDTO> getServererrorList() {
        return servererrorList;
    }

    public void setServererrorList(List<ServererrorDTO> servererrorList) {
        this.servererrorList = servererrorList;
    }

    public List<ClazzDTO> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<ClazzDTO> clazzList) {
        this.clazzList = clazzList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
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

    public List<SubjectDTO> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectDTO> subjectList) {
        this.subjectList = subjectList;
    }

    public List<TeachersubjectDTO> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<TeachersubjectDTO> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

    public List<StudentDTO> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentDTO> studentList) {
        this.studentList = studentList;
    }

    public List<TeacherDTO> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<TeacherDTO> teacherList) {
        this.teacherList = teacherList;
    }

}
