/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sifiso.yazisa.transfer.dto.PhotoUploadDTO;
import com.sifiso.yazisa.transfer.dto.RequestDTO;
import com.sifiso.yazisa.transfer.dto.ResponseDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.joda.time.DateTime;

/**
 *
 * @author aubreyM
 */
@Stateless
public class PhotoUtil {

    public ResponseDTO downloadPhotos(HttpServletRequest request, PlatformUtil platformUtil) throws FileUploadException {
        logger.log(Level.INFO, "######### starting PHOTO DOWNLOAD process\n\n");
        ResponseDTO resp = new ResponseDTO();
        InputStream stream = null;
        File rootDir;
        try {
            rootDir = YazisaProperties.getImageDir();
            logger.log(Level.INFO, "rootDir - {0}", rootDir.getAbsolutePath());
            if (!rootDir.exists()) {
                rootDir.mkdir();
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Properties file problem", ex);
            resp.setMessage("Server file unavailable. Please try later");
            resp.setStatusCode(114);

            return resp;
        }

        PhotoUploadDTO dto = null;
        Gson gson = new Gson();
        File schoolDir = null, classDir = null,
                parentDir = null,
                teacherDir = null, studentDir = null;
        try {
            ServletFileUpload upload = new ServletFileUpload();
            FileItemIterator iter = upload.getItemIterator(request);
            while (iter.hasNext()) {
                FileItemStream item = iter.next();
                String name = item.getFieldName();
                stream = item.openStream();
                if (item.isFormField()) {
                    if (name.equalsIgnoreCase("JSON")) {
                        String json = Streams.asString(stream);
                        if (json != null) {
                            logger.log(Level.INFO, "picture with associated json: {0}", json);
                            dto = gson.fromJson(json, PhotoUploadDTO.class);
                            if (dto != null) {
                                schoolDir = createSchoolDirectory(rootDir, schoolDir, dto.getSchoolID());
                                if (dto.getClassID() > 0) {
                                    classDir = createClassDirectory(schoolDir, classDir, dto.getClassID());
                                }
                                if (dto.getParentID() > 0) {
                                    parentDir = createParentDirectory(
                                            schoolDir, parentDir);
                                }
                                if (dto.getTeacherID() > 0) {
                                    teacherDir = createTeacherDirectory(
                                            schoolDir, teacherDir);
                                }
                                if (dto.getStudentID() > 0) {
                                    studentDir = createStudentDirectory(
                                            schoolDir, studentDir);
                                }
                            }
                        } else {
                            logger.log(Level.WARNING, "JSON input seems pretty fucked up! is NULL..");
                        }
                    }
                } else {
                    File imageFile = null;
                    if (dto == null) {
                        continue;
                    }
                    DateTime dt = new DateTime();
                    String fileName = "";
                    if (dto.isIsFullPicture()) {
                        fileName = "f" + dt.getMillis() + ".jpg";
                    } else {
                        fileName = "t" + dt.getMillis() + ".jpg";
                    }
                    if (dto.getSchoolID() != null) {
                        if (dto.isIsFullPicture()) {
                            fileName = "f" + dto.getSchoolID() + ".jpg";
                        } else {
                            fileName = "t" + dto.getSchoolID() + ".jpg";
                        }
                    }
                    if (dto.getSchoolID() != null) {
                        if (dto.getTeacherID() != null) {
                            if (dto.isIsFullPicture()) {
                                fileName = "f" + dto.getTeacherID() + ".jpg";
                            } else {
                                fileName = "t" + dto.getTeacherID() + ".jpg";
                            }
                        }
                    }
                    if (dto.getSchoolID() != null) {
                        if (dto.getClassID() != null) {
                            if (dto.isIsFullPicture()) {
                                fileName = "f" + dto.getClassID() + "-" + new Date().getYear() + ".jpg";
                            } else {
                                fileName = "t" + dto.getClassID() + "-" + new Date().getYear() + ".jpg";
                            }
                        }
                    }
                    if (dto.getSchoolID() != null) {
                        if (dto.getParentID() != null) {
                            if (dto.isIsFullPicture()) {
                                fileName = "f" + dto.getParentID() + ".jpg";
                            } else {
                                fileName = "t" + dto.getParentID() + ".jpg";
                            }
                        }
                    }
                    if (dto.getSchoolID() != null) {
                        if (dto.getStudentID() != null) {
                            if (dto.isIsFullPicture()) {
                                fileName = "f" + dto.getStudentID() + ".jpg";
                            } else {
                                fileName = "t" + dto.getStudentID() + ".jpg";
                            }
                        }
                    }
                    //
                    switch (dto.getPictureType()) {
                        case PhotoUploadDTO.SCHOOL_IMAGE:
                            imageFile = new File(schoolDir, fileName);
                            break;
                        case PhotoUploadDTO.CLASS_IMAGE:
                            imageFile = new File(classDir, fileName);
                            break;
                        case PhotoUploadDTO.PARENT_IMAGE:
                            imageFile = new File(parentDir, fileName);
                            break;
                        case PhotoUploadDTO.STUDENT_IMAGE:
                            imageFile = new File(studentDir, fileName);
                            break;
                    }

                    writeFile(stream, imageFile);
                    resp.setStatusCode(0);
                    resp.setMessage("Photo downloaded from mobile app ");
                    //add database
                    System.out.println("filepath: " + imageFile.getAbsolutePath());
                    //create uri
                    /*int index = imageFile.getAbsolutePath().indexOf("monitor_images");
                    if (index > -1) {
                        String uri = imageFile.getAbsolutePath().substring(index);
                        System.out.println("uri: " + uri);
                        dto.setUri(uri);
                    }
                    dto.setDateUploaded(new Date());
                    if (dto.isIsFullPicture()) {
                        dto.setThumbFlag(null);
                    } else {
                        dto.setThumbFlag(1);
                    }
                    dataUtil.addPhotoUpload(dto);*/

                }
            }

        } catch (FileUploadException | IOException | JsonSyntaxException ex) {
            logger.log(Level.SEVERE, "Servlet failed on IOException, images NOT uploaded", ex);
            throw new FileUploadException();
        }

        return resp;
    }

    private File createSchoolDirectory(File rootDir, File schoolDir, int id) {
        logger.log(Level.INFO, "task photo to be downloaded");
        schoolDir = new File(rootDir, RequestDTO.SCHOOL_DIR + id);
        if (!schoolDir.exists()) {
            schoolDir.mkdir();
            logger.log(Level.INFO, "task  directory created - {0}",
                    schoolDir.getAbsolutePath());

        }
        return schoolDir;
    }

    private File createClassDirectory(File schoolDir, File classDir, int id) {
        logger.log(Level.INFO, "projectSite photo to be downloaded");
        classDir = new File(schoolDir, RequestDTO.CLASS_DIR + id);
        if (!classDir.exists()) {
            classDir.mkdir();
            logger.log(Level.INFO, "project site  directory created - {0}",
                    classDir.getAbsolutePath());

        }
        return classDir;
    }

    private File createParentDirectory(File schoolDir, File parentDir) {
        parentDir = new File(schoolDir, RequestDTO.PARENT_DIR);
        logger.log(Level.INFO, "just after new {0}", parentDir);
        if (!parentDir.exists()) {
            parentDir.mkdir();
            logger.log(Level.INFO, "projectDir created - {0}",
                    parentDir.getAbsolutePath());

        }
        return parentDir;
    }

    private File createTeacherDirectory(File schoolDir, File teacherDir) {
        teacherDir = new File(schoolDir, RequestDTO.TEACHER_DIR);
        logger.log(Level.INFO, "just after new {0}", teacherDir);
        if (!teacherDir.exists()) {
            teacherDir.mkdir();
            logger.log(Level.INFO, "staffDir created - {0}",
                    teacherDir.getAbsolutePath());

        }
        return teacherDir;
    }

    private File createStudentDirectory(File schoolDir, File studentDir) {
        studentDir = new File(schoolDir, RequestDTO.STUDENT_DIR);
        if (!studentDir.exists()) {
            studentDir.mkdir();
            logger.log(Level.INFO, "company directory created - {0}",
                    studentDir.getAbsolutePath());
        }

        return studentDir;
    }

    private void writeFile(InputStream stream, File imageFile) throws FileNotFoundException, IOException {

        if (imageFile == null) {
            throw new FileNotFoundException();
        }
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            int read;
            byte[] bytes = new byte[2048];
            while ((read = stream.read(bytes)) != -1) {
                fos.write(bytes, 0, read);
            }
            stream.close();
            fos.flush();
        }

        logger.log(Level.WARNING, "### File downloaded: {0} size: {1}",
                new Object[]{imageFile.getAbsolutePath(), imageFile.length()});
    }

    public static double getElapsed(long start, long end) {
        BigDecimal m = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return m.doubleValue();
    }
    static final Logger logger = Logger.getLogger("PhotoUtil");
}
