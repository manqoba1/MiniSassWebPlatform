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
 * @author Sifiso Mtshweni
 */
public class EventDTO implements Serializable {

    private Integer eventID;
    private String eventName;
    private String eDescription;
    private long eventDate;
    private SchoolDTO school;

    public EventDTO() {
    }

    public EventDTO(Event a) {
        eventID = a.getEventID();
        eventName = a.getEventName();
        eDescription = a.getEDescription();
        eventDate = a.getEventDate().getTime();
        school = new SchoolDTO(a.getSchool());
    }

    public EventDTO(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEDescription() {
        return eDescription;
    }

    public void setEDescription(String eDescription) {
        this.eDescription = eDescription;
    }

    public String geteDescription() {
        return eDescription;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription;
    }

    public long getEventDate() {
        return eventDate;
    }

    public void setEventDate(long eventDate) {
        this.eventDate = eventDate;
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
        hash += (eventID != null ? eventID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventDTO)) {
            return false;
        }
        EventDTO other = (EventDTO) object;
        if ((this.eventID == null && other.eventID != null) || (this.eventID != null && !this.eventID.equals(other.eventID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sifiso.yazisa.data.Event[ eventID=" + eventID + " ]";
    }

}
