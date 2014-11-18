/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Learners;
import com.sifiso.yazisa.data.Parent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class LearnersDTO {

    private Integer learnersID;
    private String name;
    private String surname;
    private String idnumber;
    private String username;
    private String password;
    private String cell;
    private String email;
    private List<ClazzlearnerDTO> clazzlearnerList = new ArrayList<>();
    private List<ParentDTO> parentList = new ArrayList<>();
    private List<ExammarkDTO> exammarkList = new ArrayList<>();
    private List<SubclazzDTO> subclazzList = new ArrayList<>();
    private List<GcmdeviceDTO> gcmdeviceList = new ArrayList<>();

    public LearnersDTO(Learners l) {
        learnersID = l.getLearnersID();
        surname = l.getSurname();
        name = l.getName();
        idnumber = l.getIdnumber();
        username = l.getUsername();
        password = l.getPassword();
        cell = l.getCell();
        email = l.getEmail();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ParentDTO> getParentList() {
        return parentList;
    }

    public void setParentList(List<ParentDTO> parentList) {
        this.parentList = parentList;
    }

    public Integer getLearnersID() {
        return learnersID;
    }

    public void setLearnersID(Integer learnersID) {
        this.learnersID = learnersID;
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

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public List<ClazzlearnerDTO> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<ClazzlearnerDTO> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public List<ExammarkDTO> getExammarkList() {
        return exammarkList;
    }

    public void setExammarkList(List<ExammarkDTO> exammarkList) {
        this.exammarkList = exammarkList;
    }

    public List<SubclazzDTO> getSubclazzList() {
        return subclazzList;
    }

    public void setSubclazzList(List<SubclazzDTO> subclazzList) {
        this.subclazzList = subclazzList;
    }

    public List<GcmdeviceDTO> getGcmdeviceList() {
        return gcmdeviceList;
    }

    public void setGcmdeviceList(List<GcmdeviceDTO> gcmdeviceList) {
        this.gcmdeviceList = gcmdeviceList;
    }

}
