/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.sifiso.yazisa.data.Clazz;
import com.sifiso.yazisa.data.Parent;
import com.sifiso.yazisa.data.School;
import com.sifiso.yazisa.data.Student;
import com.sifiso.yazisa.data.Subject;
import com.sifiso.yazisa.data.Teacher;
import com.sifiso.yazisa.data.Township;
import com.sifiso.yazisa.dto.SchoolDTO;
import java.util.Random;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        School s = new School();
        s.setSchoolName("School #" + random.nextInt(1000));
        s.setAddress("10211 Nkunala Ave");
        s.setEmail("schoool" + random.nextInt(10000) + "@gdoe.org");
        s.setPostalCode("" + random.nextInt(10000));
        s.setTell("" + random.nextLong());
        s.setTownship(em.find(Township.class, 7));
        em.persist(s);
        em.flush();
    }

    private void addClasses(School s) {
        for (int i = 0; i < 11; i++) {
            for (int x = 0; x < 4; x++) {
                Clazz c = new Clazz();
                c.setActiveFlag(1);
                c.setSchool(s);
                c.setTotalStudentsPerClazz(40);
                if (i < 9) {
                    c.setClassName((i + 1) + clazzName[x]);
                } else {
                    if (x > 2) {
                        c.setClassName((i + 1) + clazzName[x] + (x + 7));
                    } else {
                        c.setClassName((i + 1) + clazzName[x] + (x + 1));
                    }
                }
                em.persist(c);
            }

        }
    }

    private void addSubjects() {
        for (int i = 0; i < 11; i++) {
            for (int x = 0; x < subCode.length; x++) {
                Subject s = new Subject();

                s.setCode(subCode[x] + (i + 1));
                s.setName(clazzName[x]);
                s.setGrade("Grade" + (i + 1));
                em.persist(s);
            }
        }

    }

    private void addTeacher() {
        for (int i = 0; i < tname.length; ++i) {
            random = new Random();
            Teacher t = new Teacher();
            t.setCell("" + random.nextInt(1000000000));
            t.setEmail(tname[i] + "@gmail.com");
            t.setIdnumber("" + random.nextInt(1000000000));
            t.setName(tname[i]);
            t.setPassword("" + random.nextInt(1000));
            t.setSessionID(null);
            t.setSurname(tsurname[i]);

            em.persist(t);
        }
    }

    private void addStudent(Parent p) {
        for (int i = 0; i < tname.length; ++i) {
            random = new Random();
            Student t = new Student();
            t.setCell("" + random.nextInt(1000000000));
            t.setEmail(tname[i] + "@gmail.com");
            t.setIdNumber("" + random.nextInt(1000000000));
            t.setName(tname[i]);
            t.setPassword("" + random.nextInt(1000));
            t.setSessionID(null);
            t.setSurname(tsurname[i]);
            t.setParent(p);
            em.persist(t);
        }
    }
     private void addParent() {
        for (int i = 0; i < tname.length; ++i) {
            random = new Random();
            Parent t = new Parent();
            t.setCell("" + random.nextInt(1000000000));
            t.setEmail(tname[i] + "@gmail.com");
            t.setParentIdNo("" + random.nextInt(1000000000));
            t.setParentName(tname[i]);
            t.setPassword("" + random.nextInt(1000));
            t.setSessionID(null);
            t.setParentSurname(tsurname[i]);
            
            em.persist(t);
        }
    }
    
    private String[] tname = {"Sifiso", "Thabo", "Lina"};
    private String[] tsurname = {"Mtshweni", "Matha", "Moyo"};
    private String[] subName = {"Mathemetics", "Physical Science", "Geography", "History", "Biology", "English", "Zulu", "Xhosa",
        "IsiNdebele", "Tsonga", "Economics", "Machenical Technology", "Electrical Engineering", "Engineering Graphics and Design", "Economics Management Science",
        "Natural Science", "Life Orientation"};
    private String[] subCode = {"M", "PS", "GEO", "Bio", "EG", "ZU", "XH", "NB", "TS", "ECO", "MT", "EE", "EGD", "EMS", "NS", "LO"};
    private String[] clazzName = {"A", "B", "C", "D", "E", "F", "G", "H", "T"};
}
