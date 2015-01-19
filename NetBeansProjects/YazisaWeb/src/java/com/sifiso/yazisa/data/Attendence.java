/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "attendence")
@NamedQueries({
    @NamedQuery(name = "Attendence.findAll", query = "SELECT a FROM Attendence a"),
     @NamedQuery(name = "Attendence.findByStudentID", 
            query = "SELECT a FROM Attendence a WHERE a.student.studentID =:studentID AND FUNCTION('YEAR', CURRENT_DATE) = FUNCTION('YEAR',a.dateAttended) ORDER BY a.dateAttended DESC"),  
    @NamedQuery(name = "Attendence.findByStudent", 
            query = "SELECT a FROM Attendence a WHERE a.student.studentID =:studentID AND a.attendenceFlag =:flag AND FUNCTION('YEAR', CURRENT_DATE) = FUNCTION('YEAR',a.dateAttended)"),
    @NamedQuery(name = "Attendence.findByAttendenceID", query = "SELECT a FROM Attendence a WHERE a.attendenceID = :attendenceID"),
    @NamedQuery(name = "Attendence.findByDateAttended", query = "SELECT a FROM Attendence a WHERE a.dateAttended = :dateAttended"),
    @NamedQuery(name = "Attendence.findByAttendenceFlag", query = "SELECT a FROM Attendence a WHERE a.attendenceFlag = :attendenceFlag")})
public class Attendence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendenceID")
    private Integer attendenceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAttended")
    @Temporal(TemporalType.DATE)
    private Date dateAttended;
    @Column(name = "attendenceFlag")
    private Integer attendenceFlag;
    @Lob
    @Size(max = 65535)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID")
    @ManyToOne
    private Subject subject;

    public Attendence() {
    }

    public Attendence(Integer attendenceID) {
        this.attendenceID = attendenceID;
    }

    public Attendence(Integer attendenceID, Date dateAttended) {
        this.attendenceID = attendenceID;
        this.dateAttended = dateAttended;
    }

    public Integer getAttendenceID() {
        return attendenceID;
    }

    public void setAttendenceID(Integer attendenceID) {
        this.attendenceID = attendenceID;
    }

    public Date getDateAttended() {
        return dateAttended;
    }

    public void setDateAttended(Date dateAttended) {
        this.dateAttended = dateAttended;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    public int hashCode() {
        int hash = 0;
        hash += (attendenceID != null ? attendenceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendence)) {
            return false;
        }
        Attendence other = (Attendence) object;
        if ((this.attendenceID == null && other.attendenceID != null) || (this.attendenceID != null && !this.attendenceID.equals(other.attendenceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Attendence[ attendenceID=" + attendenceID + " ]";
    }

}
