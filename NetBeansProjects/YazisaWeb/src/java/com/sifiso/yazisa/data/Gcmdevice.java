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
import javax.validation.constraints.Size;

/**
 *
 * @author CodeTribe1
 */
@Entity
@Table(name = "gcmdevice")
@NamedQueries({
    @NamedQuery(name = "Gcmdevice.findAll", query = "SELECT g FROM Gcmdevice g"),
    @NamedQuery(name = "Gcmdevice.findByGcmDeviceID", query = "SELECT g FROM Gcmdevice g WHERE g.gcmDeviceID = :gcmDeviceID"),
    @NamedQuery(name = "Gcmdevice.findByModel", query = "SELECT g FROM Gcmdevice g WHERE g.model = :model"),
    @NamedQuery(name = "Gcmdevice.findBySerialNumber", query = "SELECT g FROM Gcmdevice g WHERE g.serialNumber = :serialNumber"),
    @NamedQuery(name = "Gcmdevice.findByAndroidVersion", query = "SELECT g FROM Gcmdevice g WHERE g.androidVersion = :androidVersion"),
    @NamedQuery(name = "Gcmdevice.findByManufacturer", query = "SELECT g FROM Gcmdevice g WHERE g.manufacturer = :manufacturer"),
    @NamedQuery(name = "Gcmdevice.findByProduct", query = "SELECT g FROM Gcmdevice g WHERE g.product = :product"),
    @NamedQuery(name = "Gcmdevice.findByRegistrationID", query = "SELECT g FROM Gcmdevice g WHERE g.registrationID = :registrationID"),
    @NamedQuery(name = "Gcmdevice.findByDateRegistered", query = "SELECT g FROM Gcmdevice g WHERE g.dateRegistered = :dateRegistered")})
public class Gcmdevice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gcmDeviceID")
    private Integer gcmDeviceID;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    @Size(max = 255)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Size(max = 45)
    @Column(name = "androidVersion")
    private String androidVersion;
    @Size(max = 255)
    @Column(name = "manufacturer")
    private String manufacturer;
    @Size(max = 255)
    @Column(name = "product")
    private String product;
    @Size(max = 255)
    @Column(name = "registrationID")
    private String registrationID;
    @Column(name = "dateRegistered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegistered;
    @JoinColumn(name = "headmasterID", referencedColumnName = "headMasterID")
    @ManyToOne(optional = false)
    private Headmaster headmaster;
    @JoinColumn(name = "learnerID", referencedColumnName = "learnersID")
    @ManyToOne(optional = false)
    private Learners learner;
    @JoinColumn(name = "parentID", referencedColumnName = "parentID")
    @ManyToOne(optional = false)
    private Parent parent;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne(optional = false)
    private Teachers teacher;

    public Gcmdevice() {
    }

    public Gcmdevice(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public Integer getGcmDeviceID() {
        return gcmDeviceID;
    }

    public void setGcmDeviceID(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Headmaster getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(Headmaster headmaster) {
        this.headmaster = headmaster;
    }

    public Learners getLearner() {
        return learner;
    }

    public void setLearner(Learners learner) {
        this.learner = learner;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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
        hash += (gcmDeviceID != null ? gcmDeviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gcmdevice)) {
            return false;
        }
        Gcmdevice other = (Gcmdevice) object;
        if ((this.gcmDeviceID == null && other.gcmDeviceID != null) || (this.gcmDeviceID != null && !this.gcmDeviceID.equals(other.gcmDeviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Gcmdevice[ gcmDeviceID=" + gcmDeviceID + " ]";
    }

}
