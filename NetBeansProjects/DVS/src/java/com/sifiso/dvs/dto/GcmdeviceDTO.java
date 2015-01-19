/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.dto;

import com.sifiso.dvs.data.Gcmdevice;
import java.io.Serializable;

/**
 *
 * @author CodeTribe1
 */
public class GcmdeviceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer gcmDeviceID, doctorID;
    private String model;
    private String serialNumber;
    private String androidVersion;
    private String manufacturer;
    private String product;
    private String registrationID;
    private long dateRegistered;
    private DoctorDTO doctor;

    public GcmdeviceDTO() {
    }

    
    public GcmdeviceDTO(Gcmdevice g) {
        gcmDeviceID = g.getGcmDeviceID();
        model = g.getModel();
        serialNumber = g.getSerialNumber();
        androidVersion = g.getAndroidVersion();
        manufacturer = g.getManufacturer();
        product = g.getProduct();
        registrationID = g.getRegistrationID();
        dateRegistered = g.getDateRegistered().getTime();
        if (g.getDoctor() != null) {
            doctor = new DoctorDTO(g.getDoctor());
        }
    }

    public Integer getGcmDeviceID() {
        return gcmDeviceID;
    }

    public void setGcmDeviceID(Integer gcmDeviceID) {
        this.gcmDeviceID = gcmDeviceID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
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

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

}
