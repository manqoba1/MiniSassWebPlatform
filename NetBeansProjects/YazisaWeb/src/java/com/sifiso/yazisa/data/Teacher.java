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
@Table(name = "teacher")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.login", query = "SELECT t FROM Teacher t WHERE t.email = :email AND t.password = :password"),
    @NamedQuery(name = "Teacher.findByTeacherID", query = "SELECT t FROM Teacher t WHERE t.teacherID = :teacherID"),
    @NamedQuery(name = "Teacher.findByName", query = "SELECT t FROM Teacher t WHERE t.name = :name"),
    @NamedQuery(name = "Teacher.findBySurname", query = "SELECT t FROM Teacher t WHERE t.surname = :surname"),
    @NamedQuery(name = "Teacher.findByIdnumber", query = "SELECT t FROM Teacher t WHERE t.idnumber = :idnumber"),
    @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email"),
    @NamedQuery(name = "Teacher.findByCell", query = "SELECT t FROM Teacher t WHERE t.cell = :cell"),
    @NamedQuery(name = "Teacher.findByPassword", query = "SELECT t FROM Teacher t WHERE t.password = :password")})
public class Teacher implements Serializable {
    @Size(max = 500)
    @Column(name = "sessionID")
    private String sessionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Issue> issueList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "teacherID")
    private Integer teacherID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "idnumber")
    private String idnumber;
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
    @OneToMany(mappedBy = "teacher")
    private List<Gcmdevice> gcmdeviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Clazzteacher> clazzteacherList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Attendence> attendenceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Teachersubject> teachersubjectList;

    public Teacher() {
    }

    public Teacher(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public Teacher(Integer teacherID, String name, String surname, String idnumber, String email, String cell, String password) {
        this.teacherID = teacherID;
        this.name = name;
        this.surname = surname;
        this.idnumber = idnumber;
        this.email = email;
        this.cell = cell;
        this.password = password;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
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

    public List<Gcmdevice> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<Gcmdevice> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    public List<Clazzteacher> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<Clazzteacher> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<Attendence> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<Attendence> attendenceList) {
        this.attendenceList = attendenceList;
    }

    public List<Teachersubject> getTeachersubjectList() {
        return teachersubjectList;
    }

    public void setTeachersubjectList(List<Teachersubject> teachersubjectList) {
        this.teachersubjectList = teachersubjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherID != null ? teacherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherID == null && other.teacherID != null) || (this.teacherID != null && !this.teacherID.equals(other.teacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Teacher[ teacherID=" + teacherID + " ]";
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }
    
}
