/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.util;

import java.util.regex.Pattern;

/**
 * This class contains methods to validate names, IDs, dates, contact numbers,
 * prices, addresses, and sizes using regular expressions and the methods to
 * ensure that no fields are left empty.
 *
 * @author Prasamsha Singh
 */
public class ValidationUtil {

    /**
     * the following code is used for validating the things entered by the admin
     */

    private static final Pattern ART_ID_PATTERN = Pattern.compile("\\d{4}$");  // 4 digits only
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$");  // Allow spaces in names
    private static final Pattern DATE_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s.,-/]+$");
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^98\\d{8}$");  // Contact format
    private static final Pattern PRICE_PATTERN = Pattern.compile("^\\d+(\\.\\d{1,2})?$");  // Price format
    private static final Pattern ADDRESS_PATTERN = Pattern.compile("^[a-zA-Z0-9\\s.,-/]+$");  // Address format
    private static final Pattern SIZE_PATTERN = Pattern.compile("^\\d+ X \\d+$");  // Correct format for size

    /**
     * method to check if the string is null or empty
     * @param item string 
     * @return true if the String is null or empty otherwise false 
     */
    public static boolean checkNullOrEmpty(String item) {
        return item == null || item.trim().isEmpty();
    }

     /**
     * ensures that the name entered contains only alphabets and is not empty
     * @param name the name to validate
     * @return true if the name is valid otherwise false 
     */
    public static boolean validateName(String name) {
        return !checkNullOrEmpty(name) && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Ensures that the ID entered contains exactly 4 numeric digits and is not empty.
     * 
     * @param artID the ID to validate
     * @return true if the ID is valid, otherwise false
     */
    public static boolean validateID(String artID) {
        return !checkNullOrEmpty(artID) && ART_ID_PATTERN.matcher(artID).matches();
    }

    /**
     * Ensures that the date entered contains alphanumeric characters and allowed punctuation 
     * (space, '.', ',', '-', '/'), and is not empty.
     * 
     * @param date the date to validate
     * @return true if the date is valid otherwise false
     */
    public static boolean validateDate(String date) {
        return !checkNullOrEmpty(date) && DATE_PATTERN.matcher(date).matches();
    }

     /**
     * Ensures that the contact number starts with "98" and  has exactly 10 digits, and is not empty.
     * @param contact the contact number to validate
     * @return true if the contact is valid, otherwise false
     */
    public static boolean validateContact(String contact) {
        return !checkNullOrEmpty(contact) && CONTACT_PATTERN.matcher(contact).matches();
    }
    
    /**
     * Ensures that the price entered is a numeric value with up to 2 decimal places and is not empty.
     * 
     * @param price the price to validate
     * @return true if the price is valid otherwise false
     */
    public static boolean validatePrice(String price) {
        return !checkNullOrEmpty(price) && PRICE_PATTERN.matcher(price).matches();
    }

    /**
     * Ensures that the address entered contains alphanumeric characters and allowed punctuation 
     * (space, '.', ',', '-', '/'), and is not empty.
     * 
     * @param address the address to validate
     * @return true if the address is valid otherwise false
     */
    public static boolean validateAddress(String address) {
        return !checkNullOrEmpty(address) && ADDRESS_PATTERN.matcher(address).matches();
    }

     /**
     * Ensures that the size is entered in "Height X Width" form. 
     * @param size the size to validate
     * @return true if the size is valid otherwise false
     */
    public static boolean validateSize(String size) {
        return !checkNullOrEmpty(size) && SIZE_PATTERN.matcher(size).matches();
    }
}
