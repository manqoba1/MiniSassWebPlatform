/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "clazz")
@NamedQueries({
    @NamedQuery(name = "Clazz.findAll", query = "SELECT c FROM Clazz c"),
    @NamedQuery(name = "Clazz.findByClazzID", query = "SELECT c FROM Clazz c WHERE c.clazzID = :clazzID"),
    @NamedQuery(name = "Clazz.findByClassName", query = "SELECT c FROM Clazz c WHERE c.className = :className"),
    @NamedQuery(name = "Clazz.findByClassTypeID", query = "SELECT c FROM Clazz c WHERE c.classTypeID = :classTypeID")})
public class Clazz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clazzID")
    private Integer clazzID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "className")
    private String className;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classTypeID")
    private int classTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazz")
    private List<Clazzteacher> clazzteacherList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazz")
    private List<Clazzlearner> clazzlearnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazz")
    private List<Exam> examList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clazz")
    private List<Subclazz> subclazzList;

    public Clazz() {
    }

    public Clazz(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public Clazz(Integer clazzID, String className, int classTypeID) {
        this.clazzID = clazzID;
        this.className = className;
        this.classTypeID = classTypeID;
    }

    public Integer getClazzID() {
        return clazzID;
    }

    public void setClazzID(Integer clazzID) {
        this.clazzID = clazzID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassTypeID() {
        return classTypeID;
    }

    public void setClassTypeID(int classTypeID) {
        this.classTypeID = classTypeID;
    }

    public List<Clazzteacher> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<Clazzteacher> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<Clazzlearner> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<Clazzlearner> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public List<Subclazz> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<Subclazz> subclazzList) {
        this.subclazzList = subclazzList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clazzID != null ? clazzID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clazz)) {
            return false;
        }
        Clazz other = (Clazz) object;
        if ((this.clazzID == null && other.clazzID != null) || (this.clazzID != null && !this.clazzID.equals(other.clazzID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Clazz[ clazzID=" + clazzID + " ]";
    }
    
}
