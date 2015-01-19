/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class AttendenceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer attendenceID, subjectID, studentID, teacherID;
    private long dateAttended;
    private StudentDTO student;
    private SubjectDTO subject;
    private Integer attendenceFlag;
    private String message;
    private TeacherDTO teacher;

    public AttendenceDTO() {
    }

    public AttendenceDTO(Attendence a) {
        attendenceID = a.getAttendenceID();
        attendenceFlag = a.getAttendenceFlag();
        message = a.getMessage();
        dateAttended = a.getDateAttended().getTime();
        student = new StudentDTO(a.getStudent());
        subject = new SubjectDTO(a.getSubject());
        teacher = new TeacherDTO(a.getTeacher());
        teacherID = a.getTeacher().getTeacherID();
        subjectID = a.getSubject().getSubjectID();
        studentID = a.getStudent().getStudentID();
    }

    public Integer getAttendenceID() {
        return attendenceID;
    }

    public void setAttendenceID(Integer attendenceID) {
        this.attendenceID = attendenceID;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public long getDateAttended() {
        return dateAttended;
    }

    public void setDateAttended(long dateAttended) {
        this.dateAttended = dateAttended;
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

    public Integer getAttendenceFlag() {
        return attendenceFlag;
    }

    public void setAttendenceFlag(Integer attendenceFlag) {
        this.attendenceFlag = attendenceFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Attendence[ attendenceID=" + attendenceID + " ]";
    }

}
