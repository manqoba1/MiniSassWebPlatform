/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Province;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ProvinceDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer provinceID;

    private String provinceName;
    private Double latitude;
    private Double longitude;
    private Integer countryID;
    private List<TownshipDTO> townshipList = new ArrayList<>();

    public ProvinceDTO() {
    }

    public ProvinceDTO(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public ProvinceDTO(Province a) {
        this.provinceID = a.getProvinceID();
        this.provinceName = a.getProvinceName();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
        countryID = a.getCountry().getCountryID();
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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

    public Integer getcountryID() {
        return countryID;
    }

    public void setcountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

}
