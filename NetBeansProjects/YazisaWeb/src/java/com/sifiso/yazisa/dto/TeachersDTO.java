/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Teachers;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class TeachersDTO {

    private Integer teacherID;

    private String name;
    private String surname;
    private int idnumber;
    private String email;
    private String cell;
    private String username;
    private String password;
    private List<TeachersubDTO> teachersubList;
    private List<ClazzteacherDTO> clazzteacherList;
    private List<ExamDTO> examList;
    private SchoolDTO school;

    public TeachersDTO(Teachers t) {
        teacherID = t.getTeacherID();
        name = t.getName();
        surname = t.getSurname();
        idnumber = t.getIdnumber();
        email = t.getEmail();
        cell = t.getCell();
        username = t.getUsername();
        password = t.getPassword();
        school = new SchoolDTO(t.getSchool());
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
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

    public List<TeachersubDTO> getTeachersubList() {
        return teachersubList;
    }

    public void setTeachersubList(List<TeachersubDTO> teachersubList) {
        this.teachersubList = teachersubList;
    }

    public List<ClazzteacherDTO> getClazzteacherList() {
        return clazzteacherList;
    }

    public void setClazzteacherList(List<ClazzteacherDTO> clazzteacherList) {
        this.clazzteacherList = clazzteacherList;
    }

    public List<ExamDTO> getExamList() {
        return examList;
    }

    public void setExamList(List<ExamDTO> examList) {
        this.examList = examList;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }

}
