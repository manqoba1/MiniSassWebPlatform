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
@Table(name = "parent")
@NamedQueries({
    @NamedQuery(name = "Parent.findAll", query = "SELECT p FROM Parent p"),
    @NamedQuery(name = "Parent.login",
            query = "SELECT p FROM Parent p WHERE p.email = :email AND p.password = :password"),
    @NamedQuery(name = "Parent.findByParentID", query = "SELECT p FROM Parent p WHERE p.parentID = :parentID"),
    @NamedQuery(name = "Parent.findByParentName", query = "SELECT p FROM Parent p WHERE p.parentName = :parentName"),
    @NamedQuery(name = "Parent.findByParentSurname", query = "SELECT p FROM Parent p WHERE p.parentSurname = :parentSurname"),
    @NamedQuery(name = "Parent.findByParentIdNo", query = "SELECT p FROM Parent p WHERE p.parentIdNo = :parentIdNo"),
    @NamedQuery(name = "Parent.findByEmail", query = "SELECT p FROM Parent p WHERE p.email = :email"),
    @NamedQuery(name = "Parent.findByCell", query = "SELECT p FROM Parent p WHERE p.cell = :cell"),
    @NamedQuery(name = "Parent.findByPassword", query = "SELECT p FROM Parent p WHERE p.password = :password")})
public class Parent implements Serializable {
    @Size(max = 500)
    @Column(name = "sessionID")
    private String sessionID;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parentID")
    private Integer parentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "parentName")
    private String parentName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "parentSurname")
    private String parentSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "parentIdNo")
    private String parentIdNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cell")
    private String cell;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Student> studentList;
    @OneToMany(mappedBy = "parent")
    private List<Gcmdevice> gcmdeviceList;

    public Parent() {
    }

    public Parent(Integer parentID) {
        this.parentID = parentID;
    }

    public Parent(Integer parentID, String parentName, String parentSurname, String parentIdNo, String email, String cell, String password) {
        this.parentID = parentID;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.parentIdNo = parentIdNo;
        this.email = email;
        this.cell = cell;
        this.password = password;
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public void setParentSurname(String parentSurname) {
        this.parentSurname = parentSurname;
    }

    public String getParentIdNo() {
        return parentIdNo;
    }

    public void setParentIdNo(String parentIdNo) {
        this.parentIdNo = parentIdNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Gcmdevice> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<Gcmdevice> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parentID != null ? parentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parent)) {
            return false;
        }
        Parent other = (Parent) object;
        if ((this.parentID == null && other.parentID != null) || (this.parentID != null && !this.parentID.equals(other.parentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Parent[ parentID=" + parentID + " ]";
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

}
