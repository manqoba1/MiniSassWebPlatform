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
public class PatientfileDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer patientFileID, clientID, doctorID;
    private String fileUrl;
    private long dateMade;
    private ClientDTO client;
    private DoctorDTO doctor;
    private List<VisitDTO> visitList = new ArrayList<>();

    public PatientfileDTO() {
    }

    public PatientfileDTO(Patientfile a) {
        this.patientFileID = a.getPatientFileID();
        fileUrl = a.getFileUrl();
        dateMade = a.getDateMade().getTime();
        clientID = a.getClient().getClientID();
        doctorID = a.getDoctor().getDoctorID();
        client = new ClientDTO(a.getClient());
        doctor = new DoctorDTO(a.getDoctor());

    }

    public Integer getPatientFileID() {
        return patientFileID;
    }

    public void setPatientFileID(Integer patientFileID) {
        this.patientFileID = patientFileID;
    }

    public List<VisitDTO> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitDTO> visitList) {
        this.visitList = visitList;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public long getDateMade() {
        return dateMade;
    }

    public void setDateMade(long dateMade) {
        this.dateMade = dateMade;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
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
        hash += (patientFileID != null ? patientFileID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientfileDTO)) {
            return false;
        }
        PatientfileDTO other = (PatientfileDTO) object;
        if ((this.patientFileID == null && other.patientFileID != null) || (this.patientFileID != null && !this.patientFileID.equals(other.patientFileID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Patientfile[ patientFileID=" + patientFileID + " ]";
    }

}
