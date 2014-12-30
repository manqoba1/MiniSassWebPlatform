/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "deviceerror")
@NamedQueries({
    @NamedQuery(name = "Deviceerror.findAll", query = "SELECT d FROM Deviceerror d"),
    @NamedQuery(name = "Deviceerror.findByDeviceErrorID", query = "SELECT d FROM Deviceerror d WHERE d.deviceErrorID = :deviceErrorID"),
    @NamedQuery(name = "Deviceerror.findByErrorDate", query = "SELECT d FROM Deviceerror d WHERE d.errorDate = :errorDate"),
    @NamedQuery(name = "Deviceerror.findByPackageName", query = "SELECT d FROM Deviceerror d WHERE d.packageName = :packageName"),
    @NamedQuery(name = "Deviceerror.findByAppVersionName", query = "SELECT d FROM Deviceerror d WHERE d.appVersionName = :appVersionName"),
    @NamedQuery(name = "Deviceerror.findByAppVersionCode", query = "SELECT d FROM Deviceerror d WHERE d.appVersionCode = :appVersionCode"),
    @NamedQuery(name = "Deviceerror.findByBrand", query = "SELECT d FROM Deviceerror d WHERE d.brand = :brand"),
    @NamedQuery(name = "Deviceerror.findByPhoneModel", query = "SELECT d FROM Deviceerror d WHERE d.phoneModel = :phoneModel"),
    @NamedQuery(name = "Deviceerror.findByAndroidVersion", query = "SELECT d FROM Deviceerror d WHERE d.androidVersion = :androidVersion")})
public class Deviceerror implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deviceErrorID")
    private Integer deviceErrorID;
    @Column(name = "errorDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date errorDate;
    @Size(max = 255)
    @Column(name = "packageName")
    private String packageName;
    @Size(max = 255)
    @Column(name = "appVersionName")
    private String appVersionName;
    @Size(max = 45)
    @Column(name = "appVersionCode")
    private String appVersionCode;
    @Size(max = 255)
    @Column(name = "brand")
    private String brand;
    @Size(max = 500)
    @Column(name = "phoneModel")
    private String phoneModel;
    @Size(max = 45)
    @Column(name = "androidVersion")
    private String androidVersion;
    @Lob
    @Size(max = 65535)
    @Column(name = "stackTrace")
    private String stackTrace;
    @Lob
    @Size(max = 65535)
    @Column(name = "logCat")
    private String logCat;
    @JoinColumn(name = "doctorID", referencedColumnName = "doctorID")
    @ManyToOne(optional = false)
    private Doctor doctor;

    public Deviceerror() {
    }

    public Deviceerror(Integer deviceErrorID) {
        this.deviceErrorID = deviceErrorID;
    }

    public Integer getDeviceErrorID() {
        return deviceErrorID;
    }

    public void setDeviceErrorID(Integer deviceErrorID) {
        this.deviceErrorID = deviceErrorID;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    public String getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getLogCat() {
        return logCat;
    }

    public void setLogCat(String logCat) {
        this.logCat = logCat;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deviceErrorID != null ? deviceErrorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deviceerror)) {
            return false;
        }
        Deviceerror other = (Deviceerror) object;
        if ((this.deviceErrorID == null && other.deviceErrorID != null) || (this.deviceErrorID != null && !this.deviceErrorID.equals(other.deviceErrorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Deviceerror[ deviceErrorID=" + deviceErrorID + " ]";
    }

}
