/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.gate.dto;

import com.sifiso.dvs.dto.ClientDTO;
import com.sifiso.dvs.dto.CountryDTO;
import com.sifiso.dvs.dto.DeviceerrorDTO;
import com.sifiso.dvs.dto.DoctorDTO;
import com.sifiso.dvs.dto.DoctortypeDTO;
import com.sifiso.dvs.dto.MedicalaidDTO;
import com.sifiso.dvs.dto.PatientfileDTO;
import com.sifiso.dvs.dto.ProvinceDTO;
import com.sifiso.dvs.dto.ReceptionistDTO;
import com.sifiso.dvs.dto.ServererrorDTO;
import com.sifiso.dvs.dto.SurgeryDTO;
import com.sifiso.dvs.dto.TownshipDTO;
import com.sifiso.dvs.dto.VisitDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CodeTribe1
 */
public class ResponseDTO implements Serializable {

    private Integer statusCode;
    private String message, sessionID, GCMRegistrationID;

    private ClientDTO client;
    private CountryDTO country;
    private DeviceerrorDTO deviceerror;
    private DoctortypeDTO doctortype;
    private MedicalaidDTO medicalaid;
    private PatientfileDTO patientfile;
    private ProvinceDTO province;
    private ReceptionistDTO receptionist;
    private ServererrorDTO servererror;
    private SurgeryDTO surgery;
    private TownshipDTO township;
    private VisitDTO visit;
    private DoctorDTO doctor;

    private List<ClientDTO> clientList = new ArrayList<>();
    private List<CountryDTO> countryList = new ArrayList<>();
    private List<DeviceerrorDTO> deviceerrorList = new ArrayList<>();
    private List<DoctorDTO> doctorList = new ArrayList<>();
    private List<DoctortypeDTO> doctortypeList = new ArrayList<>();
    private List<MedicalaidDTO> medicalaidList = new ArrayList<>();
    private List<PatientfileDTO> patientfileList = new ArrayList<>();
    private List<ProvinceDTO> provinceList = new ArrayList<>();
    private List<ReceptionistDTO> receptionistList = new ArrayList<>();
    private List<ServererrorDTO> servererrorList = new ArrayList<>();
    private List<SurgeryDTO> surgeryList = new ArrayList<>();
    private List<TownshipDTO> townshipList = new ArrayList<>();
    private List<VisitDTO> visitList = new ArrayList<>();

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getGCMRegistrationID() {
        return GCMRegistrationID;
    }

    public void setGCMRegistrationID(String GCMRegistrationID) {
        this.GCMRegistrationID = GCMRegistrationID;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public DeviceerrorDTO getDeviceerror() {
        return deviceerror;
    }

    public void setDeviceerror(DeviceerrorDTO deviceerror) {
        this.deviceerror = deviceerror;
    }

    public DoctortypeDTO getDoctortype() {
        return doctortype;
    }

    public void setDoctortype(DoctortypeDTO doctortype) {
        this.doctortype = doctortype;
    }

    public MedicalaidDTO getMedicalaid() {
        return medicalaid;
    }

    public void setMedicalaid(MedicalaidDTO medicalaid) {
        this.medicalaid = medicalaid;
    }

    public PatientfileDTO getPatientfile() {
        return patientfile;
    }

    public void setPatientfile(PatientfileDTO patientfile) {
        this.patientfile = patientfile;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }

    public ReceptionistDTO getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(ReceptionistDTO receptionist) {
        this.receptionist = receptionist;
    }

    public ServererrorDTO getServererror() {
        return servererror;
    }

    public void setServererror(ServererrorDTO servererror) {
        this.servererror = servererror;
    }

    public SurgeryDTO getSurgery() {
        return surgery;
    }

    public void setSurgery(SurgeryDTO surgery) {
        this.surgery = surgery;
    }

    public TownshipDTO getTownship() {
        return township;
    }

    public void setTownship(TownshipDTO township) {
        this.township = township;
    }

    public VisitDTO getVisit() {
        return visit;
    }

    public void setVisit(VisitDTO visit) {
        this.visit = visit;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public List<ClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientDTO> clientList) {
        this.clientList = clientList;
    }

    public List<CountryDTO> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<CountryDTO> countryList) {
        this.countryList = countryList;
    }

    public List<DeviceerrorDTO> getDeviceerrorList() {
        return deviceerrorList;
    }

    public void setDeviceerrorList(List<DeviceerrorDTO> deviceerrorList) {
        this.deviceerrorList = deviceerrorList;
    }

    public List<DoctorDTO> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<DoctorDTO> doctorList) {
        this.doctorList = doctorList;
    }

    public List<DoctortypeDTO> getDoctortypeList() {
        return doctortypeList;
    }

    public void setDoctortypeList(List<DoctortypeDTO> doctortypeList) {
        this.doctortypeList = doctortypeList;
    }

    public List<MedicalaidDTO> getMedicalaidList() {
        return medicalaidList;
    }

    public void setMedicalaidList(List<MedicalaidDTO> medicalaidList) {
        this.medicalaidList = medicalaidList;
    }

    public List<PatientfileDTO> getPatientfileList() {
        return patientfileList;
    }

    public void setPatientfileList(List<PatientfileDTO> patientfileList) {
        this.patientfileList = patientfileList;
    }

    public List<ProvinceDTO> getProvinceList() {
        return provinceList;
    }

    public void setProvinceList(List<ProvinceDTO> provinceList) {
        this.provinceList = provinceList;
    }

    public List<ReceptionistDTO> getReceptionistList() {
        return receptionistList;
    }

    public void setReceptionistList(List<ReceptionistDTO> receptionistList) {
        this.receptionistList = receptionistList;
    }

    public List<ServererrorDTO> getServererrorList() {
        return servererrorList;
    }

    public void setServererrorList(List<ServererrorDTO> servererrorList) {
        this.servererrorList = servererrorList;
    }

    public List<SurgeryDTO> getSurgeryList() {
        return surgeryList;
    }

    public void setSurgeryList(List<SurgeryDTO> surgeryList) {
        this.surgeryList = surgeryList;
    }

    public List<TownshipDTO> getTownshipList() {
        return townshipList;
    }

    public void setTownshipList(List<TownshipDTO> townshipList) {
        this.townshipList = townshipList;
    }

    public List<VisitDTO> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<VisitDTO> visitList) {
        this.visitList = visitList;
    }

}
