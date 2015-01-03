package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer clientID;
    private String name;
    private String surname;
    private String email;
    private String tell;
    private String pin;
    private String address;
    private String standNumber;
    private List<MedicalaidDTO> medicalaidList = new ArrayList<MedicalaidDTO>();
    private List<VisitDTO> visitList = new ArrayList<VisitDTO>();
    private List<PatientfileDTO> patientfileList = new ArrayList<PatientfileDTO>();

    public ClientDTO() {
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStandNumber() {
        return standNumber;
    }

    public void setStandNumber(String standNumber) {
        this.standNumber = standNumber;
    }

    public List<MedicalaidDTO> getMedicalaidList() {
        return medicalaidList;
    }

    public void setMedicalaidList(List<MedicalaidDTO> medicalaidList) {
        this.medicalaidList = medicalaidList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientDTO)) {
            return false;
        }
        ClientDTO other = (ClientDTO) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Client[ clientID=" + clientID + " ]";
    }

}
