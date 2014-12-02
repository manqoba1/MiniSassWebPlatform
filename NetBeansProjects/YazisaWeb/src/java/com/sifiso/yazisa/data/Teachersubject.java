/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "teachersubject")
@NamedQueries({
    @NamedQuery(name = "Teachersubject.findAll", query = "SELECT t FROM Teachersubject t"),
    @NamedQuery(name = "Teachersubject.findSubjectByTeacher", query = "SELECT t FROM Teachersubject t WHERE t.teacher.teacherID = :teacherID"),
    @NamedQuery(name = "Teachersubject.findByTeacherSubjectID", query = "SELECT t FROM Teachersubject t WHERE t.teacherSubjectID = :teacherSubjectID")})
public class Teachersubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacherSubjectID")
    private Integer teacherSubjectID;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID")
    @ManyToOne(optional = false)
    private Subject subject;

    public Teachersubject() {
    }

    public Teachersubject(Integer teacherSubjectID) {
        this.teacherSubjectID = teacherSubjectID;
    }

    public Integer getTeacherSubjectID() {
        return teacherSubjectID;
    }

    public void setTeacherSubjectID(Integer teacherSubjectID) {
        this.teacherSubjectID = teacherSubjectID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachersubject)) {
            return false;
        }
        Teachersubject other = (Teachersubject) object;
        if ((this.teacherSubjectID == null && other.teacherSubjectID != null) || (this.teacherSubjectID != null && !this.teacherSubjectID.equals(other.teacherSubjectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Teachersubject[ teacherSubjectID=" + teacherSubjectID + " ]";
    }

}
