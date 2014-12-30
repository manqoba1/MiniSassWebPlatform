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
public class ReceptionistDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer receptionistID, surgeryID;
    private String name;
    private String surname;
    private String email;
    private String tell;
    private String pin;
    private SurgeryDTO surgery;
    private List<VisitDTO> visitList = new ArrayList<>();

    public ReceptionistDTO() {
    }

    public ReceptionistDTO(Receptionist a) {
        this.receptionistID = a.getReceptionistID();
        name = a.getName();
        surname = a.getSurname();
        email = a.getEmail();
        tell = a.getTell();
        pin = a.getPin();
        surgeryID = a.getSurgery().getSurgeryID();
        surgery = new SurgeryDTO(a.getSurgery());
    }

    public Integer getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(Integer receptionistID) {
        this.receptionistID = receptionistID;
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

    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public SurgeryDTO getSurgery() {
        return surgery;
    }

    public void setSurgery(SurgeryDTO surgery) {
        this.surgery = surgery;
    }

    public List<VisitDTO> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitDTO> visitList) {
        this.visitList = visitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receptionistID != null ? receptionistID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceptionistDTO)) {
            return false;
        }
        ReceptionistDTO other = (ReceptionistDTO) object;
        if ((this.receptionistID == null && other.receptionistID != null) || (this.receptionistID != null && !this.receptionistID.equals(other.receptionistID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Receptionist[ receptionistID=" + receptionistID + " ]";
    }

}
