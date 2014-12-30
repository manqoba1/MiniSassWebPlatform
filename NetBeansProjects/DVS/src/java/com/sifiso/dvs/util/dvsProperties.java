/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CodeTribe1
 */
public class dvsProperties {

    public static File getTemporaryDir() {
        getProperties();
        File d = new File(props.getProperty("tempDir"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getDocumentDir() {
        getProperties();
        File d = new File(props.getProperty("document"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getTemporaryZippedDir() {
        getProperties();
        File d = new File(props.getProperty("zipped"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getImageTemplateDir() {
        getProperties();
        File d = new File(props.getProperty("image_templates"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getImageDir() {
        getProperties();
        File d = new File(props.getProperty("images"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    private static void getProperties() {
        if (props != null) {
            return;
        }
        props = new Properties();
        try {
            File f = null;
            f = new File("C:/properties/dvs.properties");
            if (!f.exists()) {
                f = new File("/opt/properties/dvs.properties");
            }
            if (!f.exists()) {
                logger.log(Level.SEVERE, "Ydvsazisa Properties File not found");
            } else {
                logger.log(Level.INFO, "dvs Properties: {0}\n\n\n", f.getAbsolutePath());
                props.load(new FileInputStream(f));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Properties file dvs.properties not found or corrupted");
        }

    }
    private static final Logger logger = Logger.getLogger(dvsProperties.class.getName());
    private static Properties props;
}
