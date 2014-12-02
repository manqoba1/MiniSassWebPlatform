/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Teachersubject;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class TeachersubjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer teacherSubjectID, subjectID, teacherID;
    private TeacherDTO teacher;
    private SubjectDTO subject;

    public TeachersubjectDTO(Teachersubject a) {
        teacherSubjectID = a.getTeacherSubjectID();
        subjectID = a.getSubject().getSubjectID();
        teacherID = a.getSubject().getSubjectID();
        subject = new SubjectDTO(a.getSubject());
        teacher = new TeacherDTO(a.getTeacher());
    }

    public Integer getTeacherSubjectID() {
        return teacherSubjectID;
    }

    public void setTeacherSubjectID(Integer teacherSubjectID) {
        this.teacherSubjectID = teacherSubjectID;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

}
