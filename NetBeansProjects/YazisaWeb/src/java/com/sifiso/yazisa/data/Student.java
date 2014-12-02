/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStudentID", query = "SELECT s FROM Student s WHERE s.studentID = :studentID"),
    @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name"),
    @NamedQuery(name = "Student.findBySurname", query = "SELECT s FROM Student s WHERE s.surname = :surname"),
    @NamedQuery(name = "Student.findByIdNumber", query = "SELECT s FROM Student s WHERE s.idNumber = :idNumber"),
    @NamedQuery(name = "Student.findByDateOfBirth", query = "SELECT s FROM Student s WHERE s.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"),
    @NamedQuery(name = "Student.findByCell", query = "SELECT s FROM Student s WHERE s.cell = :cell"),
    @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")})
public class Student implements Serializable {

    @Size(max = 500)
    @Column(name = "sessionID")
    private String sessionID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Issue> issueList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studentID")
    private Integer studentID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idNumber")
    private String idNumber;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cell")
    private String cell;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "parentID", referencedColumnName = "parentID")
    @ManyToOne(optional = false)
    private Parent parent;
    @OneToMany(mappedBy = "student")
    private List<Gcmdevice> gcmdeviceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Clazzstudent> clazzstudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Attendence> attendenceList;

    public Student() {
    }

    public Student(Integer studentID) {
        this.studentID = studentID;
    }

    public Student(Integer studentID, String idNumber, String email, String cell) {
        this.studentID = studentID;
        this.idNumber = idNumber;
        this.email = email;
        this.cell = cell;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<Gcmdevice> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<Gcmdevice> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

    public List<Clazzstudent> getClazzstudentList() {
        return clazzstudentList;
    }

    public void setClazzstudentList(List<Clazzstudent> clazzstudentList) {
        this.clazzstudentList = clazzstudentList;
    }

    public List<Attendence> getAttendenceList() {
        return attendenceList;
    }

    public void setAttendenceList(List<Attendence> attendenceList) {
        this.attendenceList = attendenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Student[ studentID=" + studentID + " ]";
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
