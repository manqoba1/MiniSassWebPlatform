/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import com.sifiso.dvs.data.Client;
import com.sifiso.dvs.data.Doctor;
import com.sifiso.dvs.data.Medicalaid_;
import com.sifiso.dvs.data.Patientfile;
import com.sifiso.dvs.data.Visit;
import com.sifiso.dvs.dto.ClientDTO;
import com.sifiso.dvs.dto.DoctorDTO;
import com.sifiso.dvs.dto.PatientfileDTO;
import com.sifiso.dvs.dto.VisitDTO;
import com.sifiso.dvs.gate.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CodeTribe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ListUtil {

    @PersistenceContext
    EntityManager em;

    public ResponseDTO getDoctorData(int id) {
        ResponseDTO resp = new ResponseDTO();
        resp.setVisitList(getVisitByDoctorID(id));
        resp.setPatientfileList(getPatientFileByDoctorID(id));

        return resp;
    }

    private List<VisitDTO> getVisitByDoctorID(int id) {
        List<VisitDTO> list = new ArrayList<>();
        Query q = em.createNamedQuery("Visit.findByDoctorID", Visit.class);
        q.setParameter("id", id);
        List<Visit> visits = q.getResultList();
        for (Visit v : visits) {
            list.add(new VisitDTO(v));
        }
        return list;
    }

    private List<VisitDTO> getVisitByClientID(int id) {
        List<VisitDTO> list = new ArrayList<>();
        Query q = em.createNamedQuery("Visit.findByClientID", Visit.class);
        q.setParameter("id", id);
        List<Visit> visits = q.getResultList();
        for (Visit v : visits) {
            list.add(new VisitDTO(v));
        }
        return list;
    }

    private List<VisitDTO> getVisitByReceptionID(int id) {
        List<VisitDTO> list = new ArrayList<>();
        Query q = em.createNamedQuery("Visit.findByReceptionistID", Visit.class);
        q.setParameter("id", id);
        List<Visit> visits = q.getResultList();
        for (Visit v : visits) {
            VisitDTO dTO = new VisitDTO(v);           
            list.add(dTO);
        }
        return list;
    }

    private List<PatientfileDTO> getPatientFileByDoctorID(int id) {
        List<PatientfileDTO> list = new ArrayList<>();
        Query q = em.createNamedQuery("Patientfile.findByDoctor", Patientfile.class);
        q.setParameter("id", id);
        List<Patientfile> patientfiles = q.getResultList();
        for (Patientfile p : patientfiles) {
            PatientfileDTO dTO = new PatientfileDTO(p);
            for(Visit v: p.getVisitList()){
                dTO.getVisitList().add(new VisitDTO(v));
            }
            list.add(dTO);
        }
        return list;
    }

    public ResponseDTO getDoctors(int surgeryID) {
        ResponseDTO resp = new ResponseDTO();
        List<DoctorDTO> doctorList = new ArrayList<>();
        Query q = em.createNamedQuery("Doctor.findBySurgeryID", Doctor.class);
        q.setParameter("id", surgeryID);
        List<Doctor> doctors = q.getResultList();
        for (Doctor d : doctors) {
            DoctorDTO doctorDTO = new DoctorDTO(d);
            for (Visit v : d.getVisitList()) {
                doctorDTO.getVisitList().add(new VisitDTO(v));
            }
            for (Patientfile p : d.getPatientfileList()) {
                doctorDTO.getPatientfileList().add(new PatientfileDTO(p));
            }
            doctorList.add(doctorDTO);
        }
        resp.setDoctorList(doctorList);
        return resp;
    }

    public ResponseDTO getClientDataByStand(String standNumber, int doctorID, int surgeryID) {
        ResponseDTO resp = new ResponseDTO();
        List<PatientfileDTO> patientfileList = new ArrayList<>();
        Query q = em.createNamedQuery("Patientfile.findClientByStdDocIDSurgID", Patientfile.class);
        q.setParameter("stnd", standNumber);
        q.setParameter("doctorID", doctorID);
        q.setParameter("surgeryID", surgeryID);
        List<Patientfile> patientfiles = q.getResultList();
        for (Patientfile c : patientfiles) {
            PatientfileDTO dTO = new PatientfileDTO(c);
            patientfileList.add(dTO);
        }
        resp.setPatientfileList(patientfileList);
        return resp;
    }

    public ResponseDTO getClientDataByFile(int clientID, int doctorID, int surgeryID) {
        ResponseDTO resp = new ResponseDTO();
        List<PatientfileDTO> patientfileList = new ArrayList<>();
        Query q = em.createNamedQuery("Patientfile.findClientByClientIDDocIDSurgID", Patientfile.class);
        q.setParameter("clientID", clientID);
        q.setParameter("doctorID", doctorID);
        q.setParameter("surgeryID", surgeryID);
        List<Patientfile> patientfiles = q.getResultList();
        for (Patientfile c : patientfiles) {
            PatientfileDTO dTO = new PatientfileDTO(c);
            patientfileList.add(dTO);
        }
        resp.setPatientfileList(patientfileList);
        return resp;
    }
}
