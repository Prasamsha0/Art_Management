/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.amg.util;

import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class validationUtil {
        /**
     * the following code is used for validating the things entered by the admin
     */
   
    private static final Pattern ART_ID_PATTERN = Pattern.compile("\\d{4}$");  // 4 digits only
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");  // Allow spaces in names
    private static final Pattern DATE_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s.,-/]+$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");  // Contact format
    private static final Pattern PRICE_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");  // Price format with optional $
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s.,-/]+$");  // Address format
    private static final Pattern SIZE_PATTERN = Pattern.compile("^\\d+ X \\d+$");  // Correct format for size

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
    
    // validation to check whether name contains only alphabets and spaces
    public static boolean ValidName(String name) {
        return !isNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    // validation to check whether ID is four digits and not empty
    public static boolean isValidId(String artID) {
        return !isNullOrEmpty(artID) && ART_ID_PATTERN.matcher(artID).matches();
    }

    // validation to check whether date is in dd/mm/yyyy format and not empty
    public static boolean isValidDate(String date) {
        return !isNullOrEmpty(date) && DATE_PATTERN.matcher(date).matches();
    }

//    public static boolean ValidMedium(String medium) {
//        return !isNullOrEmpty(medium) && MEDIUM_PATTERN.matcher(medium).matches();
//    }

    // validation to check whether contact starts from 98__, has 10 digits and not empty
    public static boolean ValidContact(String contact) {
        return !isNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact).matches();
    }

    public static boolean ValidPrice(String price) {
        return !isNullOrEmpty(price) && PRICE_PATTERN.matcher(price).matches();
    }
    // validation to check whether price ends in number, ends with a currency and not empty
    public static boolean ValidAddress(String address) {
        return !isNullOrEmpty(address) && ADDRESS_PATTERN.matcher(address).matches();
    }

//    public static boolean ValidFormat(String format) {
//        return !isNullOrEmpty(format) && FORMAT_PATTERN.matcher(format).matches();
//    }
// validation to check whether size is in height X width form and not empty
    public static boolean ValidSize(String size) {
        return !isNullOrEmpty(size) && SIZE_PATTERN.matcher(size).matches();
    }    
}
