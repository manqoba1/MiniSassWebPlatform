package com.boha.minisass.util;

import com.boha.minisass.dto.EvaluationDTO;
import com.boha.minisass.transfer.RequestDTO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.MathContext;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author aubreyM
 */
public class JSONGrabber {

    public static void main(String[] args) {

        //create the object you want in the servlet
        RequestDTO req = new RequestDTO();
        req.setRequestType(101);

        EvaluationDTO e = new EvaluationDTO();
        e.setComment("water is clean");
        e.setLatitude(0.2);
        e.setLongitude(0.4);
        e.setOxygen(0.6);
        e.setPH(0.8);
        e.setRemarks("ggggggg");
        e.setScore(0.2);
        e.setWaterClarity(0.3);
        e.setWaterTemperature(0.3);
        e.setEvaluationDate(new Date().getTime());
        e.setTeamMemberID(1);
        e.setConditionsID(1);
        e.setEvaluationSiteID(1);

        req.setEvaluation(e);

        //turn the REquestDTO object into a JSON string
        Gson gson = new Gson();
        String json = gson.toJson(req);

        System.out.println("JSON created\n" + json);
        JSONGrabber grabber = new JSONGrabber();

        int[] A = {10000000, 900000000, 300000000, -100000000, 500000000};
        System.out.println("fhds" + grabber.sun(A));
    }

    public int sun(int[] A) {
        int sum = 0, Q, P, x = 0;
        System.out.println("fhds" + A.length);

        int len = A.length;
        for (int i = 0; i < A.length; i++) {
            Q = (int) (Math.random() * len);
            P = (int) (Math.random() * len);
            System.out.println("Q" + A[Q] + " " + "P" + A[P]);
            sum = A[Q] + A[P];
            if (sum > 1000000000) {
                x = 2;
                break;

            }
            System.out.println("break" + x);
        }
        return sum;
    }

    public void run() {

        String csvFile = "C:/Users/CodeTribe1/Downloads/RiversExcel.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[0]
                        + " , name=" + country[2] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Done");
    }
}

/* THE RESULT

 JSON created
 {"requestType":101,"province":{"provinceID":3,"provinceName":"Gauteng"}}

 */
