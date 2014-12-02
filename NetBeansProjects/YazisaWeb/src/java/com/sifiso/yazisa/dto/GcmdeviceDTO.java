/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;

public class GcmdeviceDTO implements Serializable {

    private Integer gcmDeviceID, teacherID, studentID, parentID;
    private String model;
    private String serialNumber;
    private String androidVersion;
    private String manufacturer;
    private String product;
    private String registrationID;
    private long dateRegistered;
    private ParentDTO parent;
    private StudentDTO student;
    private TeacherDTO teacher;

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
        parent = new ParentDTO(a.getParent());
        teacher = new TeacherDTO(a.getTeacher());
        parent = new ParentDTO(a.getParent());
        student = new StudentDTO(a.getStudent());
        teacherID = a.getTeacher().getTeacherID();
        studentID = a.getStudent().getStudentID();
        parentID = a.getParent().getParentID();
    }

    public Integer getParentID() {
        return parentID;
    }

    public void setParentID(Integer parentID) {
        this.parentID = parentID;
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

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
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
