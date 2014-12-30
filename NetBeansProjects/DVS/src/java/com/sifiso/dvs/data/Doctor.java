/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

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
@Table(name = "doctor")
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findBySurgeryID", query = "SELECT d FROM Doctor d WHERE d.surgery.surgeryID = :id"),
    @NamedQuery(name = "Doctor.loginDoctor", query = "SELECT d FROM Doctor d WHERE d.email = :email AND d.pin = :pin"),
    @NamedQuery(name = "Doctor.findByDoctorID", query = "SELECT d FROM Doctor d WHERE d.doctorID = :doctorID"),
    @NamedQuery(name = "Doctor.findByName", query = "SELECT d FROM Doctor d WHERE d.name = :name"),
    @NamedQuery(name = "Doctor.findBySurname", query = "SELECT d FROM Doctor d WHERE d.surname = :surname"),
    @NamedQuery(name = "Doctor.findByRefNumber", query = "SELECT d FROM Doctor d WHERE d.refNumber = :refNumber"),
    @NamedQuery(name = "Doctor.findByEmail", query = "SELECT d FROM Doctor d WHERE d.email = :email"),
    @NamedQuery(name = "Doctor.findByTell", query = "SELECT d FROM Doctor d WHERE d.tell = :tell"),
    @NamedQuery(name = "Doctor.findByPin", query = "SELECT d FROM Doctor d WHERE d.pin = :pin")})
public class Doctor implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Deviceerror> deviceerrorList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctorID")
    private Integer doctorID;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "surname")
    private String surname;
    @Size(max = 45)
    @Column(name = "refNumber")
    private String refNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "tell")
    private String tell;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pin")
    private String pin;
    @JoinColumn(name = "surgeryID", referencedColumnName = "surgeryID")
    @ManyToOne(optional = false)
    private Surgery surgery;
    @JoinColumn(name = "doctorTypeID", referencedColumnName = "doctorTypeID")
    @ManyToOne(optional = false)
    private Doctortype doctorType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Visit> visitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Patientfile> patientfileList;

    public Doctor() {
    }

    public Doctor(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Doctor(Integer doctorID, String pin) {
        this.doctorID = doctorID;
        this.pin = pin;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
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

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Doctortype getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(Doctortype doctorType) {
        this.doctorType = doctorType;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public List<Patientfile> getPatientfileList() {
        return patientfileList;
    }

    public void setPatientfileList(List<Patientfile> patientfileList) {
        this.patientfileList = patientfileList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorID != null ? doctorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorID == null && other.doctorID != null) || (this.doctorID != null && !this.doctorID.equals(other.doctorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Doctor[ doctorID=" + doctorID + " ]";
    }

    public List<Deviceerror> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<Deviceerror> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

}
