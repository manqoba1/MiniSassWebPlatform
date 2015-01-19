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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "clazzstudent")
@NamedQueries({
    @NamedQuery(name = "Clazzstudent.findAll", query = "SELECT c FROM Clazzstudent c"),
    @NamedQuery(name = "Clazzstudent.findByStudentID", query = "SELECT c FROM Clazzstudent c WHERE c.student.studentID = :studentID"),
    @NamedQuery(name = "Clazzstudent.findStudentByClass", 
            query = "SELECT c FROM Clazzstudent c WHERE c.clazz.clazzID = :clazzID"),
    @NamedQuery(name = "Clazzstudent.findByClazzStudentID", query = "SELECT c FROM Clazzstudent c WHERE c.clazzStudentID = :clazzStudentID"),
    @NamedQuery(name = "Clazzstudent.findByClazzYear", query = "SELECT c FROM Clazzstudent c WHERE c.clazzYear = :clazzYear")})
public class Clazzstudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clazzStudentID")
    private Integer clazzStudentID;
    @Column(name = "clazzYear")
    @Temporal(TemporalType.DATE)
    private Date clazzYear;
    @JoinColumn(name = "clazzID", referencedColumnName = "clazzID")
    @ManyToOne(optional = false)
    private Clazz clazz;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    @ManyToOne(optional = false)
    private Student student;

    public Clazzstudent() {
    }

    public Clazzstudent(Integer clazzStudentID) {
        this.clazzStudentID = clazzStudentID;
    }

    public Integer getClazzStudentID() {
        return clazzStudentID;
    }

    public void setClazzStudentID(Integer clazzStudentID) {
        this.clazzStudentID = clazzStudentID;
    }

    public Date getClazzYear() {
        return clazzYear;
    }

    public void setClazzYear(Date clazzYear) {
        this.clazzYear = clazzYear;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzStudentID != null ? clazzStudentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clazzstudent)) {
            return false;
        }
        Clazzstudent other = (Clazzstudent) object;
        if ((this.clazzStudentID == null && other.clazzStudentID != null) || (this.clazzStudentID != null && !this.clazzStudentID.equals(other.clazzStudentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazzstudent[ clazzStudentID=" + clazzStudentID + " ]";
    }

}
