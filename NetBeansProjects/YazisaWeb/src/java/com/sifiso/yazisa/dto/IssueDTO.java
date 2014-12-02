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
public class IssueDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer issueID, studentID, teacherID;
    private String message;
    private StudentDTO student;
    private TeacherDTO teacher;
    private long issueDate;

    public IssueDTO() {
    }

    public IssueDTO(Issue a) {
        issueID = a.getIssueID();
        studentID = a.getStudent().getStudentID();
        teacherID = a.getTeacher().getTeacherID();
        message = a.getMessage();
        student = new StudentDTO(a.getStudent());
        teacher = new TeacherDTO(a.getTeacher());
        issueDate = a.getIssueDate().getTime();
    }

    public long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getIssueID() {
        return issueID;
    }

    public void setIssueID(Integer issueID) {
        this.issueID = issueID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issueID != null ? issueID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IssueDTO)) {
            return false;
        }
        IssueDTO other = (IssueDTO) object;
        if ((this.issueID == null && other.issueID != null) || (this.issueID != null && !this.issueID.equals(other.issueID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Issue[ issueID=" + issueID + " ]";
    }

}
