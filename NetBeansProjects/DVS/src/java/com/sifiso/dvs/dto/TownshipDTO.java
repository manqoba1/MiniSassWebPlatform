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
public class TownshipDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer townshipID, provinceID;
    private String townshipName;
    private Double latitude;
    private Double longitude;
    private ProvinceDTO province;
    private List<SurgeryDTO> surgeryList = new ArrayList<>();

    public TownshipDTO() {
    }

    public TownshipDTO(Integer townshipID) {
        this.townshipID = townshipID;
    }

    public TownshipDTO(Township a) {
        this.townshipID = a.getTownshipID();
        this.townshipName = a.getTownshipName();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        provinceID = a.getProvince().getProvinceID();
        province = new ProvinceDTO(a.getProvince());
    }

    public Integer getTownshipID() {
        return townshipID;
    }

    public void setTownshipID(Integer townshipID) {
        this.townshipID = townshipID;
    }

    public String getTownshipName() {
        return townshipName;
    }

    public void setTownshipName(String townshipName) {
        this.townshipName = townshipName;
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

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public List<SurgeryDTO> getSurgeryList() {
        return surgeryList;
    }

    public void setSurgeryList(List<SurgeryDTO> surgeryList) {
        this.surgeryList = surgeryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (townshipID != null ? townshipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TownshipDTO)) {
            return false;
        }
        TownshipDTO other = (TownshipDTO) object;
        if ((this.townshipID == null && other.townshipID != null) || (this.townshipID != null && !this.townshipID.equals(other.townshipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Township[ townshipID=" + townshipID + " ]";
    }

}
