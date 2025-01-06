/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.agm.model;

/**
 *
 * @author Prasamsha 
 */
public class paintingInfo {
    private int artId;
    private String name;
    private String date;
    private String medium;
    private String contact;
    private int price;
    private String address;
    private String formatt;
    private String size;
    

    public paintingInfo() {
    }

    public paintingInfo(int artId, String name, String date, String medium, String contact, int price, String address, String formatt, String size) {
        this.artId = artId;
        this.name = name;
        this.date = date;
        this.medium = medium;
        this.contact = contact;
        this.price = price;
        this.address = address;
        this.formatt = formatt;
        this.size = size;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
       this.contact=contact; 
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFormatt() {
        return formatt;
    }

    public void setFormatt(String formatt) {
        this.formatt = formatt;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
