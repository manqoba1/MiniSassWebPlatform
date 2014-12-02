/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.yazisa.util;

import java.util.Random;
import sun.security.util.Password;

/**
 *
 * @author CodeTribe1
 */
public class PasswordGenerator {

    Random r1 = new Random(512);
    Random r2 = new Random(4);
    private final char[] special = {'@', '#', '$', '%', '*'};

    public String getPassword(String name) {

        String password = null, hName;
        if (name.length() > 5) {
            hName = name.substring(0, 1).toUpperCase() + name.substring(2, 3).toLowerCase();
        } else {
            hName = name.substring(0, 1);
        }
        password = r1.nextInt() + "" + r1.nextInt(10) + special[r2.nextInt()] + hName + r1.nextInt();
        return password;
    }
}
