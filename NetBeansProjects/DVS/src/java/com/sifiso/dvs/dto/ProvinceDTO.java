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
public class ProvinceDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer provinceID, countryID;
    private String provinceName;
    private Double latitude;
    private Double longitude;
    private CountryDTO country;
    private List<TownshipDTO> townshipList = new ArrayList<>();

    public ProvinceDTO() {
    }

    public ProvinceDTO(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public ProvinceDTO(Province a) {
        this.provinceID = a.getProvinceID();
        this.provinceName = a.getProvinceName();
        latitude = a.getLatitude();
        longitude = a.getLongitude();
        countryID = a.getCountry().getCountryID();
        country = new CountryDTO(a.getCountry());
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

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provinceID != null ? provinceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvinceDTO)) {
            return false;
        }
        ProvinceDTO other = (ProvinceDTO) object;
        if ((this.provinceID == null && other.provinceID != null) || (this.provinceID != null && !this.provinceID.equals(other.provinceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.dvs.data.Province[ provinceID=" + provinceID + " ]";
    }

}
