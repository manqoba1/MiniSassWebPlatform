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
@Table(name = "teachersub")
@NamedQueries({
    @NamedQuery(name = "Teachersub.login", 
            query = "SELECT t FROM Teachersub t WHERE t.teacher.username = :username AND t.teacher.password = :password"),
     @NamedQuery(name = "Teachersub.findAll", query = "SELECT t FROM Teachersub t"),
    @NamedQuery(name = "Teachersub.findByTeacherSubID", query = "SELECT t FROM Teachersub t WHERE t.teacherSubID = :teacherSubID")})
public class Teachersub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacherSubID")
    private Integer teacherSubID;
    @JoinColumn(name = "subclazzID", referencedColumnName = "subClazzID")
    @ManyToOne(optional = false)
    private Subclazz subclazz;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teachers teacher;

    public Teachersub() {
    }

    public Teachersub(Integer teacherSubID) {
        this.teacherSubID = teacherSubID;
    }

    public Integer getTeacherSubID() {
        return teacherSubID;
    }

    public void setTeacherSubID(Integer teacherSubID) {
        this.teacherSubID = teacherSubID;
    }

    public Subclazz getSubclazz() {
        return subclazz;
    }

    public void setSubclazz(Subclazz subclazz) {
        this.subclazz = subclazz;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherSubID != null ? teacherSubID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachersub)) {
            return false;
        }
        Teachersub other = (Teachersub) object;
        if ((this.teacherSubID == null && other.teacherSubID != null) || (this.teacherSubID != null && !this.teacherSubID.equals(other.teacherSubID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Teachersub[ teacherSubID=" + teacherSubID + " ]";
    }

}
