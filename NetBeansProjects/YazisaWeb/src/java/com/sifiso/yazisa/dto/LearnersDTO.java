/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Learners;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class LearnersDTO {

    private Integer learnersID;
    private String name;
    private String surname;
    private int idnumber;
    private String username;

    private String password;
    private List<ClazzlearnerDTO> clazzlearnerList;
    private ParentDTO parent;
    private List<ExammarkDTO> exammarkList;
    private List<SubclazzDTO> subclazzList;

    public LearnersDTO(Learners l) {
        learnersID = l.getLearnersID();
        surname = l.getSurname();
        name = l.getName();
        idnumber = l.getIdnumber();
        parent = new ParentDTO(l.getParent());
        username = l.getUsername();
        password = l.getPassword();
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

    public int getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public List<ClazzlearnerDTO> getClazzlearnerList() {
        return clazzlearnerList;
    }

    public void setClazzlearnerList(List<ClazzlearnerDTO> clazzlearnerList) {
        this.clazzlearnerList = clazzlearnerList;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
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

}
