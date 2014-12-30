/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import com.sifiso.dvs.data.Client;
import com.sifiso.dvs.data.Doctor;
import com.sifiso.dvs.data.Doctortype;
import com.sifiso.dvs.data.Medicalaid;
import com.sifiso.dvs.data.Patientfile;
import com.sifiso.dvs.data.Receptionist;
import com.sifiso.dvs.data.Surgery;
import com.sifiso.dvs.data.Township;
import com.sifiso.dvs.data.Visit;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
public class Generator {

    @PersistenceContext
    EntityManager em;

    Random random;

    public void generate() {
        random = new Random();
       /* Surgery s = new Surgery();
        s.setName("School Surgery#" + random.nextInt(1000));
        s.setAddress("10211 Nkunala Ave");
        s.setEmail("schoool" + random.nextInt(10000) + "@med.org");
        s.setCode("" + random.nextInt(10000));
        s.setTel("" + random.nextInt(999999999));
        Township t = em.find(Township.class, 7);
        s.setTownship(t);

        em.persist(s);
        em.flush();

        addDoctorType();*/
        //addClient();
        //addMedicalAid();
        //addDoctor(em.find(Surgery.class, 2));
        addReception(em.find(Surgery.class, 2));
       // addVisit();*/
    }

    private void addClient() {
        for (int i = 0; i < tname.length; ++i) {
            random = new Random();
            Client t = new Client();
            t.setAddress(random.nextInt(999) + " Ekangala ");
            t.setEmail(tname[i]+random.nextInt(1000) + "@gmail.com");
            t.setTell("" + random.nextInt(1000000000));
            t.setName(tname[i] + random.nextInt(1000));
            t.setPin("" + random.nextInt(1000));
            t.setStandNumber("" + random.nextInt(999));
            t.setSurname(tsurname[i] + random.nextInt(1000));

            em.persist(t);
            em.flush();
            //addMedicalAid();
            addPatientFile(t);
        }
    }

    private void addDoctor(Surgery p) {
        random = new Random();
        for (int i = 0; i < doctorName.length; ++i) {

            Doctor t = new Doctor();
            t.setTell("" + random.nextInt(1000000000));
            t.setEmail(tname[i] + random.nextInt(1000) + "@gmail.com");
            t.setRefNumber("" + random.nextInt(1000000000));
            t.setName(tname[i]);
            t.setPin("" + random.nextInt(1000));
            t.setDoctorType(em.find(Doctortype.class, (5)));
            t.setSurname(tsurname[i]);
            t.setSurgery(p);

            em.persist(t);
        }
    }

    private void addReception(Surgery p) {
        random = new Random();

        Receptionist t = new Receptionist();
        t.setTell("" + random.nextInt(1000000000));
        t.setEmail(tname[1] + random.nextInt(1000) + "@gmail.com");
        t.setName(tname[1]);
        t.setPin("" + random.nextInt(1000));
        t.setSurname(tsurname[1]);
        t.setSurgery(p);

        em.persist(t);

    }

    private void addPatientFile(Client c) {
        random = new Random();

        Patientfile t = new Patientfile();
        t.setClient(c);
        t.setDoctor(em.find(Doctor.class, 3));
        t.setDateMade(new Date());
        t.setFileUrl("" + random.nextInt(1000));

        em.persist(t);

    }

    private void addDoctorType() {
        for (int x = 0; x < doctorName.length; x++) {
            Doctortype s = new Doctortype();
            s.setName(doctorName[x]);
            em.persist(s);
        }
    }

    private void addVisit() {
        for (int x = 0; x < doctorName.length; x++) {
            Visit s = new Visit();
            s.setPaymentType(type[random.nextInt(type.length)]);
            s.setFlag(random.nextInt(1));
            s.setVisitedDate(new Date());
            s.setPatientfile(em.find(Patientfile.class, (x + 2)));
            s.setDoctor(em.find(Doctor.class, 2));
            s.setReceptionist(em.find(Receptionist.class, 2));
            em.persist(s);
        }
    }

    private void addMedicalAid() {
        Client c = em.find(Client.class, random.nextInt(10));
        if (c != null) {
            random = new Random();
            Medicalaid t = new Medicalaid();
            t.setAidOption("" + random.nextInt(1000000000));
            t.setClient(c);
            t.setClientType(type[random.nextInt(type.length)]);
            t.setName(medName[random.nextInt(medName.length)]);
            t.setGender(random.nextInt(1));
            t.setMemberNumber("" + random.nextInt(1000000000));

            em.persist(t);
        }
    }

    private String[] tname = {"Sifiso", "Thabo", "Lina"};
    private String[] tsurname = {"Mtshweni", "Matha", "Moyo"};
    private String[] doctorName = {"GP", "Dentist", "Geography"};
    private String[] medName = {"Gems", "Descovery"};
    private String[] option = {"Ruby", "Emerald", "Onyx"};
    private String[] type = {"Dependent", "Main", "Spouse"};
}
