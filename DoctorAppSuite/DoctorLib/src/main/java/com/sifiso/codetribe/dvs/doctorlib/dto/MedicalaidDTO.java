package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class MedicalaidDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer medicalAidID, clientID;
    private String name;
    private String memberNumber;
    private String aidOption;
    private String clientType;
    private Integer gender;
    private ClientDTO client;

    public MedicalaidDTO() {
    }


    public Integer getMedicalAidID() {
        return medicalAidID;
    }

    public void setMedicalAidID(Integer medicalAidID) {
        this.medicalAidID = medicalAidID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getAidOption() {
        return aidOption;
    }

    public void setAidOption(String aidOption) {
        this.aidOption = aidOption;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalAidID != null ? medicalAidID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalaidDTO)) {
            return false;
        }
        MedicalaidDTO other = (MedicalaidDTO) object;
        if ((this.medicalAidID == null && other.medicalAidID != null) || (this.medicalAidID != null && !this.medicalAidID.equals(other.medicalAidID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Medicalaid[ medicalAidID=" + medicalAidID + " ]";
    }
}
