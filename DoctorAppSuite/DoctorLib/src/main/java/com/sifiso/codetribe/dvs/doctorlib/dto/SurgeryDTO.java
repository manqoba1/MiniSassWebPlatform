package com.sifiso.codetribe.dvs.doctorlib.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-30.
 */
public class SurgeryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer surgeryID, townshipID;
    private String name;
    private String code;
    private String address;
    private String email;
    private String tel;
    private Double latitude;
    private Double longitude;
    private TownshipDTO township;
    private List<DoctorDTO> doctorList = new ArrayList<DoctorDTO>();
    private List<ReceptionistDTO> receptionistList = new ArrayList<ReceptionistDTO>();
    public SurgeryDTO() {
    }

    public Integer getSurgeryID() {
        return surgeryID;
    }

    public void setSurgeryID(Integer surgeryID) {
        this.surgeryID = surgeryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getTownshipID() {
        return townshipID;
    }

    public void setTownshipID(Integer townshipID) {
        this.townshipID = townshipID;
    }


    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (surgeryID != null ? surgeryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SurgeryDTO)) {
            return false;
        }
        SurgeryDTO other = (SurgeryDTO) object;
        if ((this.surgeryID == null && other.surgeryID != null) || (this.surgeryID != null && !this.surgeryID.equals(other.surgeryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Surgery[ surgeryID=" + surgeryID + " ]";
    }
}
