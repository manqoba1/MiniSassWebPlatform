/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.dto;

import com.sifiso.yazisa.data.Subclazz;

/**
 *
 * @author CodeTribe1
 */
public class SubclazzDTO {

    private Integer subClazzID;
    private SubjectDTO subject;
    private ClazzDTO clazz;
    private LearnersDTO learners;

    public SubclazzDTO() {

    }

    public SubclazzDTO(Subclazz sc) {
        subClazzID = sc.getSubClazzID();
        subject = new SubjectDTO(sc.getSubject());
        clazz = new ClazzDTO(sc.getClazz());
        learners = new LearnersDTO(sc.getLearners());

    }

    public Integer getSubClazzID() {
        return subClazzID;
    }

    public void setSubClazzID(Integer subClazzID) {
        this.subClazzID = subClazzID;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public ClazzDTO getClazz() {
        return clazz;
    }

    public void setClazz(ClazzDTO clazz) {
        this.clazz = clazz;
    }

    public LearnersDTO getLearners() {
        return learners;
    }

    public void setLearners(LearnersDTO learners) {
        this.learners = learners;
    }

}
