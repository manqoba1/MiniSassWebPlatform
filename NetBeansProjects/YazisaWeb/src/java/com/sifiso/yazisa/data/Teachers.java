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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "teachers")
@NamedQueries({
    @NamedQuery(name = "Teachers.findAll", query = "SELECT t FROM Teachers t"),
    @NamedQuery(name = "Teachers.findByTeacherID", query = "SELECT t FROM Teachers t WHERE t.teacherID = :teacherID"),
    @NamedQuery(name = "Teachers.findByName", query = "SELECT t FROM Teachers t WHERE t.name = :name"),
    @NamedQuery(name = "Teachers.findBySurname", query = "SELECT t FROM Teachers t WHERE t.surname = :surname"),
    @NamedQuery(name = "Teachers.findByIdnumber", query = "SELECT t FROM Teachers t WHERE t.idnumber = :idnumber"),
    @NamedQuery(name = "Teachers.findByEmail", query = "SELECT t FROM Teachers t WHERE t.email = :email"),
    @NamedQuery(name = "Teachers.findByCell", query = "SELECT t FROM Teachers t WHERE t.cell = :cell"),
    @NamedQuery(name = "Teachers.findByUsername", query = "SELECT t FROM Teachers t WHERE t.username = :username"),
    @NamedQuery(name = "Teachers.findByPassword", query = "SELECT t FROM Teachers t WHERE t.password = :password")})
public class Teachers implements Serializable {

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
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Teachersub> teachersubList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Gcmdevice> gcmdeviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Clazzteacher> clazzteacherList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Exam> examList;
    @JoinColumn(name = "schoolID", referencedColumnName = "schoolID")
    @ManyToOne(optional = false)
    private School school;

    public Teachers() {
    }

    public Teachers(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public Teachers(Integer teacherID, String name, String surname, String idnumber, String email, String cell, String username, String password) {
        this.teacherID = teacherID;
        this.name = name;
        this.surname = surname;
        this.idnumber = idnumber;
        this.email = email;
        this.cell = cell;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Teachersub> getTeachersubList() {
        return teachersubList;
    }

    public void setTeachersubList(List<Teachersub> teachersubList) {
        this.teachersubList = teachersubList;
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

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.teacherID == null && other.teacherID != null) || (this.teacherID != null && !this.teacherID.equals(other.teacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Teachers[ teacherID=" + teacherID + " ]";
    }

}
