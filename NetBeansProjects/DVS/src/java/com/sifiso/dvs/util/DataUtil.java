/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import com.sifiso.dvs.data.Client;
import com.sifiso.dvs.data.Deviceerror;
import com.sifiso.dvs.data.Doctor;
import com.sifiso.dvs.data.Doctortype;
import com.sifiso.dvs.data.Medicalaid;
import com.sifiso.dvs.data.Patientfile;
import com.sifiso.dvs.data.Receptionist;
import com.sifiso.dvs.data.Surgery;
import com.sifiso.dvs.data.Township;
import com.sifiso.dvs.data.Visit;
import com.sifiso.dvs.dto.ClientDTO;
import com.sifiso.dvs.dto.DoctorDTO;
import com.sifiso.dvs.dto.DoctortypeDTO;
import com.sifiso.dvs.dto.MedicalaidDTO;
import com.sifiso.dvs.dto.PatientfileDTO;
import com.sifiso.dvs.dto.ReceptionistDTO;
import com.sifiso.dvs.dto.SurgeryDTO;
import com.sifiso.dvs.dto.VisitDTO;
import com.sifiso.dvs.gate.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author CodeTribe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DataUtil {

    @PersistenceContext
    EntityManager em;

    static final Logger log = Logger.getLogger(DataUtil.class.getSimpleName());

    public ResponseDTO loginReception(String email, String pin, ListUtil listUtil, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Receptionist.loginReception", Receptionist.class);
            q.setParameter("email", email);
            q.setParameter("pin", pin);
            Receptionist r = (Receptionist) q.getSingleResult();
            ReceptionistDTO rdto = new ReceptionistDTO(r);

            resp.setReceptionist(rdto);
            resp.setDoctorList(listUtil.getDoctors(r.getSurgery().getSurgeryID()).getDoctorList());
        } catch (NoResultException e) {
            log.log(Level.WARNING, "Invalid login attempt: " + email + " pin: " + pin, e);
            resp.setStatusCode(301);
            resp.setMessage("Email address or Password are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }

    public ResponseDTO loginDoctor(String email, String pin, ListUtil listUtil, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("Doctor.loginDoctor", Doctor.class);
            q.setParameter("email", email);
            q.setParameter("pin", pin);
            Doctor r = (Doctor) q.getSingleResult();
            DoctorDTO rdto = new DoctorDTO(r);           
            
            resp.setDoctor(rdto);
            log.log(Level.INFO, "Login");
        } catch (NoResultException e) {
            log.log(Level.WARNING, "Invalid login attempt: " + email + " pin: " + pin, e);
            resp.setStatusCode(301);
            resp.setMessage("Email address or Password are invalid. Please try again.");
            platformUtil.addServerError(301, getErrorString(e), "DataUtil");
        }
        return resp;
    }

    public ResponseDTO registerClient(ClientDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Client c = new Client();
            c.setName(a.getName());
            c.setSurname(a.getSurname());
            c.setAddress(a.getAddress());
            c.setEmail(a.getEmail());
            c.setStandNumber(a.getStandNumber());
            c.setTell(a.getTell());
            c.setPin(a.getPin());
            em.persist(c);
            em.flush();
            resp.getClientList().add(new ClientDTO(c));
            resp.setMessage("Client Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Client");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO registerReception(ReceptionistDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Receptionist c = new Receptionist();
            c.setName(a.getName());
            c.setSurname(a.getSurname());
            c.setEmail(a.getEmail());
            c.setTell(a.getTell());
            c.setPin(a.getPin());
            c.setSurgery(em.find(Surgery.class, a.getSurgeryID()));
            em.persist(c);
            em.flush();
            resp.getReceptionistList().add(new ReceptionistDTO(c));
            resp.setMessage("Receptionist Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO registerDoctor(DoctorDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Doctor c = new Doctor();
            c.setName(a.getName());
            c.setSurname(a.getSurname());
            c.setEmail(a.getEmail());
            c.setTell(a.getTell());
            c.setPin(a.getPin());
            c.setDoctorType(em.find(Doctortype.class, a.getDoctorTypeID()));
            c.setSurgery(em.find(Surgery.class, a.getSurgeryID()));
            c.setRefNumber(a.getRefNumber());
            em.persist(c);
            em.flush();
            resp.getDoctorList().add(new DoctorDTO(c));
            resp.setMessage("Doctor Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO registerSurgery(SurgeryDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Surgery c = new Surgery();
            c.setName(a.getName());
            c.setAddress(a.getAddress());
            c.setEmail(a.getEmail());
            c.setTel(a.getTel());
            c.setLatitude(a.getLatitude());
            c.setLongitude(a.getLongitude());
            c.setTownship(em.find(Township.class, a.getTownshipID()));
            c.setCode(a.getCode());
            em.persist(c);
            em.flush();
            resp.getSurgeryList().add(new SurgeryDTO(c));
            resp.setMessage("Doctor Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    //add methods
    public ResponseDTO addDoctorType(DoctortypeDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Doctortype c = new Doctortype();
            c.setName(a.getName());

            em.persist(c);
            em.flush();
            resp.getDoctortypeList().add(new DoctortypeDTO(c));
            resp.setMessage("Doctor Type Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO addMedicalAid(MedicalaidDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Medicalaid c = new Medicalaid();
            c.setName(a.getName());
            c.setAidOption(a.getAidOption());
            c.setClient(em.find(Client.class, a.getClientID()));
            c.setClientType(a.getClientType());
            c.setGender(a.getGender());
            c.setMemberNumber(a.getMemberNumber());

            em.persist(c);
            em.flush();
            resp.getMedicalaidList().add(new MedicalaidDTO(c));
            resp.setMessage("Doctor Type Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO addPatientFile(PatientfileDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Patientfile c = new Patientfile();
            c.setClient(em.find(Client.class, a.getClientID()));
            c.setDateMade(new Date());
            c.setDoctor(em.find(Doctor.class, a.getDoctorID()));            
            c.setFileUrl(a.getFileUrl());

            em.persist(c);
            em.flush();
            resp.getPatientfileList().add(new PatientfileDTO(c));
            resp.setMessage("Doctor Type Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    public ResponseDTO addVisit(VisitDTO a, PlatformUtil platformUtil) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Visit c = new Visit();
            c.setPatientfile(em.find(Patientfile.class, a.getPatientfileID()));
            c.setDateMade(new Date());
            c.setDoctor(em.find(Doctor.class, a.getDoctorID()));
            c.setReceptionist(em.find(Receptionist.class, a.getReceptionistID()));
            c.setFlag(a.getFlag());
            c.setPaymentType(a.getPaymentType());
            c.setVisitedDate(new Date());

            em.persist(c);
            em.flush();
            resp.getVisitList().add(new VisitDTO(c));
            resp.setMessage("Doctor Type Registered");

        } catch (Exception e) {
            log.log(Level.SEVERE, null, e);
            resp.setStatusCode(101);
            resp.setMessage("Failed to Register Receptionist");
            platformUtil.addServerError(101, getErrorString(e), "DataUtil");
            throw new DataException("Failed to register Present:\n" + getErrorString(e));
        }
        return resp;
    }

    //update method
    public void updateVisit(VisitDTO a) throws DataException {
        try {
            Visit ps = em.find(Visit.class, a.getVisitID());
            if (ps != null) {
                if (a.getFlag() != null) {
                    ps.setFlag(a.getFlag());
                }
                if (a.getVisitedDate() > 0) {
                    ps.setVisitedDate(new Date());
                }

                em.merge(ps);
                log.log(Level.INFO, "Patient Visited updated");
            }
        } catch (Exception e) {
            log.log(Level.OFF, null, e);
            throw new DataException("Failed to update projectSite\n" + getErrorString(e));
        }
    }

    public Doctor getDoctorByID(int doctorID) {
        return em.find(Doctor.class, doctorID);
    }

    public String getErrorString(Exception e) {
        StringBuilder sb = new StringBuilder();
        if (e.getMessage() != null) {
            sb.append(e.getMessage()).append("\n\n");
        }
        if (e.toString() != null) {
            sb.append(e.toString()).append("\n\n");
        }
        StackTraceElement[] s = e.getStackTrace();
        if (s.length > 0) {
            StackTraceElement ss = s[0];
            String method = ss.getMethodName();
            String cls = ss.getClassName();
            int line = ss.getLineNumber();
            sb.append("Class: ").append(cls).append("\n");
            sb.append("Method: ").append(method).append("\n");
            sb.append("Line Number: ").append(line).append("\n");
        }

        return sb.toString();
    }

    public void addAndroidError(Deviceerror err) throws DataException {
        try {
            em.persist(err);
            log.log(Level.INFO, "Android error added");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Failed to add Android Error", e);
            throw new DataException("Failed to add Android Error\n"
                    + getErrorString(e));
        }
    }
}
