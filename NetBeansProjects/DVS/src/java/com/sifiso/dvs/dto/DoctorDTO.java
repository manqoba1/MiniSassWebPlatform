/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.dto;

import com.sifiso.dvs.data.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer doctorID, surgeryID, doctorTypeID;
    private String name;
    private String surname;
    private String refNumber;
    private String email;
    private String tell;
    private String pin;
    private SurgeryDTO surgery;
    private DoctortypeDTO doctorType;
    private List<GcmdeviceDTO> gcmdeviceList = new ArrayList<>();
    private List<DeviceerrorDTO> deviceerrorList = new ArrayList<>();
    private List<VisitDTO> visitList = new ArrayList<>();
    private List<PatientfileDTO> patientfileList = new ArrayList<>();

    public DoctorDTO() {
    }

    public DoctorDTO(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public DoctorDTO(Doctor a) {
        this.doctorID = a.getDoctorID();
        this.pin = a.getPin();
        name = a.getName();
        surname = a.getSurname();
        refNumber = a.getRefNumber();
        email = a.getEmail();
        tell = a.getTell();
        surgery = new SurgeryDTO(a.getSurgery());
        surgeryID = a.getSurgery().getSurgeryID();
        doctorTypeID = a.getDoctorType().getDoctorTypeID();
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

    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public Integer getDoctorTypeID() {
        return doctorTypeID;
    }

    public void setDoctorTypeID(Integer doctorTypeID) {
        this.doctorTypeID = doctorTypeID;
    }

    public SurgeryDTO getSurgery() {
        return surgery;
    }

    public void setSurgery(SurgeryDTO surgery) {
        this.surgery = surgery;
    }

    public DoctortypeDTO getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(DoctortypeDTO doctorType) {
        this.doctorType = doctorType;
    }

    public List<VisitDTO> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitDTO> visitList) {
        this.visitList = visitList;
    }

    public List<PatientfileDTO> getPatientfileList() {
        return patientfileList;
    }

    public void setPatientfileList(List<PatientfileDTO> patientfileList) {
        this.patientfileList = patientfileList;
    }

    public List<DeviceerrorDTO> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<DeviceerrorDTO> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public List<GcmdeviceDTO> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<GcmdeviceDTO> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
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
        if (!(object instanceof DoctorDTO)) {
            return false;
        }
        DoctorDTO other = (DoctorDTO) object;
        if ((this.doctorID == null && other.doctorID != null) || (this.doctorID != null && !this.doctorID.equals(other.doctorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Doctor[ doctorID=" + doctorID + " ]";
    }

}
