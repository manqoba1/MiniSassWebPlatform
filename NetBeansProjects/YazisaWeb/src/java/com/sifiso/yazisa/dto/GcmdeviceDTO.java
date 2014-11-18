/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

public class GcmdeviceDTO implements Serializable {

    private Integer gcmDeviceID;
    private String model;
    private String serialNumber;
    private String androidVersion;
    private String manufacturer;
    private String product;
    private String registrationID;
    private long dateRegistered;
    private HeadmasterDTO headmaster;
    private LearnersDTO learner;
    private ParentDTO parent;
    private TeachersDTO teacher;

    public GcmdeviceDTO() {
    }

    public GcmdeviceDTO(Gcmdevice a) {
        gcmDeviceID = a.getGcmDeviceID();
        model = a.getModel();
        serialNumber = a.getSerialNumber();
        androidVersion = a.getAndroidVersion();
        manufacturer = a.getManufacturer();
        product = a.getProduct();
        registrationID = a.getRegistrationID();
        dateRegistered = a.getDateRegistered().getTime();
        headmaster = new HeadmasterDTO(a.getHeadmaster());
        learner = new LearnersDTO(a.getLearner());
        parent = new ParentDTO(a.getParent());
        teacher = new TeachersDTO(a.getTeacher());
    }

    public GcmdeviceDTO(Integer gcmDeviceID) {
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

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public HeadmasterDTO getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(HeadmasterDTO headmaster) {
        this.headmaster = headmaster;
    }

    public LearnersDTO getLearner() {
        return learner;
    }

    public void setLearner(LearnersDTO learner) {
        this.learner = learner;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
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
        if (!(object instanceof GcmdeviceDTO)) {
            return false;
        }
        GcmdeviceDTO other = (GcmdeviceDTO) object;
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
