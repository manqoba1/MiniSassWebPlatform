/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.*;
import java.io.Serializable;


/**
 *
 * @author CodeTribe1
 */
public class HeadmasterDTO implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private Integer headMasterID;   
    private String name;  
    private String surname;   
    private String idNumber;    
    private String email;   
    private String cell;   
    private String username;    
    private String password;   
    private SchoolDTO school;

    public HeadmasterDTO() {
    }

  

    public HeadmasterDTO(Headmaster a) {
        this.headMasterID = a.getHeadMasterID();
        this.name = a.getName();
        this.surname = a.getSurname();
        this.idNumber = a.getIdNumber();
        this.email = a.getEmail();
        this.cell = a.getEmail();
        this.username = a.getUsername();
        this.password = a.getPassword();
        school = new SchoolDTO(a.getSchool());
    }

    public Integer getHeadMasterID() {
        return headMasterID;
    }

    public void setHeadMasterID(Integer headMasterID) {
        this.headMasterID = headMasterID;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

   

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (headMasterID != null ? headMasterID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HeadmasterDTO)) {
            return false;
        }
        HeadmasterDTO other = (HeadmasterDTO) object;
        if ((this.headMasterID == null && other.headMasterID != null) || (this.headMasterID != null && !this.headMasterID.equals(other.headMasterID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Headmaster[ headMasterID=" + headMasterID + " ]";
    }
    
}
