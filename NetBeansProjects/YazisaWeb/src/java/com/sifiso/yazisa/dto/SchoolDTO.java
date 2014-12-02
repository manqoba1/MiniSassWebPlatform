/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.School;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class SchoolDTO implements Serializable {

    private Integer schoolID, townshipID;
    private static final long serialVersionUID = 1L;

    private String schoolName;
    private double latitude;
    private double longitude;
    private String tell;
    private String address;
    private String postalCode;
    private String email;
    private TownshipDTO township;
    private List<DeviceerrorDTO> deviceerrorList = new ArrayList<>();
    private List<ClazzDTO> clazzList;

    public SchoolDTO(School s) {
        schoolID = s.getSchoolID();
        schoolName = s.getSchoolName();
        latitude = s.getLatitude();
        longitude = s.getLongitude();
        tell = s.getTell();
        address = s.getAddress();
        postalCode = s.getPostalCode();
        email = s.getEmail();
        townshipID = s.getTownship().getTownshipID();
        township = new TownshipDTO(s.getTownship());

    }

    public Integer getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(Integer schoolID) {
        this.schoolID = schoolID;
    }

    public Integer getTownshipID() {
        return townshipID;
    }

    public void setTownshipID(Integer townshipID) {
        this.townshipID = townshipID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    public List<DeviceerrorDTO> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<DeviceerrorDTO> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public List<ClazzDTO> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<ClazzDTO> clazzList) {
        this.clazzList = clazzList;
    }

}
