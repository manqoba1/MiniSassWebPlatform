/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Exammark;

/**
 *
 * @author CodeTribe1
 */
public class ExammarkDTO {

    private Integer examMarkID;
    private Integer mark;
    private Integer passFail;
    private long dateRegistered;
    private ExamDTO exam;
    private LearnersDTO learners;

    public ExammarkDTO() {
    }

    public ExammarkDTO(Exammark em) {
        examMarkID = em.getExamMarkID();
        mark = em.getMark();
        passFail = em.getPassFail();
        dateRegistered = em.getDateRegistered().getTime();
        exam = new ExamDTO(em.getExam());
        learners = new LearnersDTO(em.getLearners());
    }

    public Integer getExamMarkID() {
        return examMarkID;
    }

    public void setExamMarkID(Integer examMarkID) {
        this.examMarkID = examMarkID;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getPassFail() {
        return passFail;
    }

    public void setPassFail(Integer passFail) {
        this.passFail = passFail;
    }

    public long getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(long dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public ExamDTO getExam() {
        return exam;
    }

    public void setExam(ExamDTO exam) {
        this.exam = exam;
    }

    public LearnersDTO getLearners() {
        return learners;
    }

    public void setLearners(LearnersDTO learners) {
        this.learners = learners;
    }

}
