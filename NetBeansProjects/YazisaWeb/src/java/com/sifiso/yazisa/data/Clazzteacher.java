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
@Table(name = "clazzteacher")
@NamedQueries({
    @NamedQuery(name = "Clazzteacher.findAll", query = "SELECT c FROM Clazzteacher c"),
        @NamedQuery(name = "Clazzteacher.findClazzByTeacher", query = "SELECT c FROM Clazzteacher c WHERE c.teacher.teacherID = :teacherID"),
    @NamedQuery(name = "Clazzteacher.findByClazzTeacherID", query = "SELECT c FROM Clazzteacher c WHERE c.clazzTeacherID = :clazzTeacherID")})
public class Clazzteacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clazzTeacherID")
    private Integer clazzTeacherID;
    @JoinColumn(name = "clazzID", referencedColumnName = "clazzID")
    @ManyToOne(optional = false)
    private Clazz clazz;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teacher teacher;

    public Clazzteacher() {
    }

    public Clazzteacher(Integer clazzTeacherID) {
        this.clazzTeacherID = clazzTeacherID;
    }

    public Integer getClazzTeacherID() {
        return clazzTeacherID;
    }

    public void setClazzTeacherID(Integer clazzTeacherID) {
        this.clazzTeacherID = clazzTeacherID;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzTeacherID != null ? clazzTeacherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clazzteacher)) {
            return false;
        }
        Clazzteacher other = (Clazzteacher) object;
        if ((this.clazzTeacherID == null && other.clazzTeacherID != null) || (this.clazzTeacherID != null && !this.clazzTeacherID.equals(other.clazzTeacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazzteacher[ clazzTeacherID=" + clazzTeacherID + " ]";
    }

}
