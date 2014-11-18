/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

public class DeviceerrorDTO implements Serializable {

    private Integer deviceErrorID;
    private long errorDate;
    private String packageName;
    private String appVersionName;
    private String appVersionCode;
    private String brand;
    private String phoneModel;
    private String androidVersion;
    private String stackTrace;
    private String logCat;
    private SchoolDTO school;

    public DeviceerrorDTO() {
    }

    public DeviceerrorDTO(Deviceerror a) {
        deviceErrorID = a.getDeviceErrorID();
        errorDate = a.getErrorDate().getTime();
        packageName = a.getPackageName();
        appVersionCode = a.getAndroidVersion();
        appVersionName = a.getAppVersionName();
        brand = a.getBrand();
        phoneModel = a.getPhoneModel();
        androidVersion = a.getAndroidVersion();
        stackTrace = a.getStackTrace();
        logCat = a.getLogCat();
        school = new SchoolDTO(a.getSchool());
    }

    public DeviceerrorDTO(Integer deviceErrorID) {
        this.deviceErrorID = deviceErrorID;
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

    public long getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(long errorDate) {
        this.errorDate = errorDate;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
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
        return "com.sifiso.yazisa.data.Deviceerror[ deviceErrorID=" + deviceErrorID + " ]";
    }

}
