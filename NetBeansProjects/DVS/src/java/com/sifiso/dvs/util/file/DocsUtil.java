/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util.file;

import com.sifiso.dvs.data.Client;
import com.sifiso.dvs.data.Doctor;
import com.sifiso.dvs.data.Patientfile;
import com.sifiso.dvs.data.Surgery;
import com.sifiso.dvs.util.dvsProperties;
import java.io.File;

/**
 *
 * @author CodeTribe1
 */
public class DocsUtil {
    public static File getPatientFile(Patientfile cc) {
        File dir = dvsProperties.getDocumentDir();
        Surgery p = cc.getDoctor().getSurgery();
        Client c = cc.getClient();
        File surgeryDir = new File(dir, "surgery" + p.getSurgeryID());
        if (!surgeryDir.exists()) {
            surgeryDir.mkdir();
        }
       
        File clientDir = new File(surgeryDir, "clients");
        if (!clientDir.exists()) {
            clientDir.mkdir();
        }
        File file = new File(clientDir, "client" + c.getClientID()+ ".pdf");
        if (file.exists()) {
            file.delete();
        }
        
        return file;
        
    }
}
