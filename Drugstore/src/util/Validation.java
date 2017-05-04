/*
 * Copyright (c) 2015 Pastor Tantalean.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Pastor Tantalean - initial API and implementation and/or initial documentation
 */
package util;

import controller.UserDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Sergio Pastor
 */
public class Validation {

    public static String validateUsername(String username) {
        String message = "Correcto";
        if (username.length() < 3 || username.length() > 30) {
            message = "El nombre de usuario debe tener entre 3 y 30 carácteres.";
        }
        for (int i = 0; i < username.length(); ++i) {
            char c = username.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                message = "Solo se permiten letras y números";
            }
        }
        if (UserDAO.existUsername(username)) {
            message = "El nombre de usuario ya existe, elija otro.";
        }
        return message;
    }

    public static String validatePassword(String password) {
        String message = "Correcto";
        if (password.length() < 5 || password.length() > 40) {
            message = "La contraseña debe tener entre 5 y 100 carácteres.";
        }
        return message;
    }

    public static String validateFirstName(String firstName) {
        String message = "Correcto";
        if (firstName.isEmpty()) {
            message = "No ha ingresado los nombres.";
        }
        for (int i = 0; i < firstName.length(); ++i) {
            char c = firstName.charAt(i);
            if (!Character.isAlphabetic(c) && c != ' ') {
                message = "Los nombres solo pueden contener letras.";
            }
        }
        return message;
    }

    public static String validateLastName(String lastName) {
        String message = "Correcto";
        if (lastName.isEmpty()) {
            message = "No ha ingresado los apellidos.";
        }
        for (int i = 0; i < lastName.length(); ++i) {
            char c = lastName.charAt(i);
            if (!Character.isAlphabetic(c) && c != ' ' && c != '-') {
                message = "Los apellidos solo pueden contener letras.";
            }
        }
        return message;
    }

    public static String validateEmail(String email) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        String message = "Correcto";
        if (!email.isEmpty() && !matcher.matches()) {
            message = "No ha ingresado un correo electrónico correcto.";
        }
        return message;
    }

    public static String validatePhoneNumber(String phoneNumber) {
        String message = "Correcto";
        final String PHONE_NUMBER_PATTERN = "[0-9]{6,30}";
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!phoneNumber.isEmpty() && !matcher.matches()) {
            message = "El número telefónico debe contener entre 6 y 30 dígitos.";
        }
        return message;
    }

    public static String validateAge(String age) {
        String message = "Correcto";
        try {
            int ageTest = Integer.parseInt(age);
            if (ageTest < 0 || ageTest > 150) {
                message = "La edad debe ser un número entre 0 y 150.";
            }
        } catch (NumberFormatException ex) {
            message = "La edad debe ser un número entre 0 y 150.";
        }
        return message;
    }
/*
    public static void main(String[] args) {
        String test = "";
        System.err.println(validateEmail(test));
        test = "012345678901234567890123456781";
        System.err.println(validatePhoneNumber(test));
        test = "000000123";
        System.err.println(validateAge(test));
    }
    */

}
