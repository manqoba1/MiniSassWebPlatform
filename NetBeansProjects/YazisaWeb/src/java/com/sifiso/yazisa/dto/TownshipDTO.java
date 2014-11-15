/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Township;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class TownshipDTO {

    private Double latitude;
    private Double longitude;
    private static final long serialVersionUID = 1L;
    private Integer townshipID;
    private String townshipName;
    private List<SchoolDTO> schoolList;

    private int province;

    public TownshipDTO() {
    }

    public TownshipDTO(Integer townshipID) {
        this.townshipID = townshipID;
    }

    public TownshipDTO(Township a) {
        this.townshipID = a.getTownshipID();
        this.townshipName = a.getTownshipName();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
        province = a.getProvince().getProvinceID();
    }

    public Integer getTownshipID() {
        return townshipID;
    }

    public void setTownshipID(Integer townshipID) {
        this.townshipID = townshipID;
    }

    public List<SchoolDTO> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<SchoolDTO> schoolList) {
        this.schoolList = schoolList;
    }

    public int getProvince() {
        return province;
    }

    public void setProvince(int province) {
        this.province = province;
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
}
