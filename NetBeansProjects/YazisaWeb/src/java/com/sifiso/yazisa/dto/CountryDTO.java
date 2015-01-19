/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Country;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class CountryDTO implements Serializable{

    private Double latitude;
    private Double longitude;
    private static final long serialVersionUID = 1L;
    private Integer countryID;
    private String countryName;
    private String countryCode;
    private List<ProvinceDTO> provinceList = new ArrayList<>();

    public CountryDTO() {
    }

    public CountryDTO(Integer countryID) {
        this.countryID = countryID;
    }

    public CountryDTO(Country a) {
        this.countryID = a.getCountryID();
        this.countryName = a.getCountryName();
        this.countryCode = a.getCountryCode();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
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

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

}
