/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Exam;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ExamDTO {
 private Integer examID;
    
    private long examDate;
    private String description;
    private String courseName;
    private Integer totalMarks;
    private ClazzDTO clazz;
    private TeachersDTO teacher;
    private List<ExammarkDTO> exammarkList;

   public ExamDTO(Exam e) {
       examID = e.getExamID();
       examDate = e.getExamDate().getTime();
       description = e.getDescription();
       courseName = e.getCourseName();
       totalMarks = e.getTotalMarks();
       clazz = new ClazzDTO(e.getClazz());
       teacher = new TeachersDTO(e.getTeacher());
       
   }

    public Integer getExamID() {
        return examID;
    }

    public void setExamID(Integer examID) {
        this.examID = examID;
    }

    public long getExamDate() {
        return examDate;
    }

    public void setExamDate(long examDate) {
        this.examDate = examDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public TeachersDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeachersDTO teacher) {
        this.teacher = teacher;
    }

    public List<ExammarkDTO> getExammarkList() {
        return exammarkList;
    }

    public void setExammarkList(List<ExammarkDTO> exammarkList) {
        this.exammarkList = exammarkList;
    }
    
}
