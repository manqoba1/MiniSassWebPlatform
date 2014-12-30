/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.dto;

import com.sifiso.dvs.data.*;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class DeviceerrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer deviceErrorID, doctorID;
    private long errorDate;
    private String packageName;
    private String appVersionName;
    private String appVersionCode;
    private String brand;
    private String phoneModel;
    private String androidVersion;
    private String stackTrace;
    private String logCat;
    private DoctorDTO doctor;

    public DeviceerrorDTO() {
    }

    public DeviceerrorDTO(Deviceerror a) {
        this.deviceErrorID = a.getDeviceErrorID();
        doctorID = a.getDoctor().getDoctorID();
        errorDate = a.getErrorDate().getTime();
        packageName = a.getPackageName();
        appVersionCode = a.getAppVersionCode();
        brand = a.getBrand();
        phoneModel = a.getPhoneModel();
        androidVersion = a.getAndroidVersion();
        stackTrace = a.getStackTrace();
        logCat = a.getLogCat();
        doctor = new DoctorDTO(a.getDoctor());
    }

    public Integer getDeviceErrorID() {
        return deviceErrorID;
    }

    public void setDeviceErrorID(Integer deviceErrorID) {
        this.deviceErrorID = deviceErrorID;
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

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public long getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(long errorDate) {
        this.errorDate = errorDate;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
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
        if (!(object instanceof DeviceerrorDTO)) {
            return false;
        }
        DeviceerrorDTO other = (DeviceerrorDTO) object;
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
