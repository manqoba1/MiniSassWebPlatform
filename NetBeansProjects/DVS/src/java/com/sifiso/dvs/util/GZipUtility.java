/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.dvs.util;

/**
 *
 * @author aubreymalabie
 */
import com.google.gson.Gson;
import com.sifiso.dvs.gate.dto.ResponseDTO;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;
import org.apache.commons.io.IOUtils;

public class GZipUtility {

    static final Gson gson = new Gson();
    static final int ZIP_THRESHOLD = 0;
    private static final Logger logger = Logger.getLogger(GZipUtility.class.getName());

    public static ByteBuffer getZippedResponse(ResponseDTO resp) throws IOException {
        String json = gson.toJson(resp);
        byte[] bytes = null;
        if (json.length() < ZIP_THRESHOLD) {
            bytes = json.getBytes();
            logger.log(Level.INFO, "Creating byteBuffer, No need to zip this, size: {0}", json.length());
        } else {
            bytes = getZippedBytes(json);
            logger.log(Level.INFO, "Creating byteBuffer, unzipped size: {0} packed size: {1}", new Object[]{json.length(), bytes.length});
        }
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        return buf;
    }

    private static byte[] getZippedBytes(String json)
            throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream zos = new GZIPOutputStream(byteArrayOutputStream);
        zos.write(json.getBytes());
        IOUtils.closeQuietly(zos);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        return bytes;

    }

    private static final int BUFFER = 1024;

    public static void unzip(File zippedFile) {
        File dir = zippedFile.getParentFile();
        try {
            BufferedOutputStream dest = null;
            FileInputStream fis = new FileInputStream(zippedFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[BUFFER];
                // write the files to the disk
                File imgFile = new File(dir, entry.getName());
                FileOutputStream fos = new FileOutputStream(imgFile);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                logger.log(Level.INFO, "\n### File de-compressed: {0}", imgFile.getAbsolutePath());
            }
            zis.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to de-compress zipped file", e);
        }

    }
}
