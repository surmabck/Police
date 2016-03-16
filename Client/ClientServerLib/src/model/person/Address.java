/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.io.Serializable;

/**
 *
 * @author Bartosz
 */
public class Address implements Serializable{

    private String cityName;

    private String streetName;

    private String apartment;

    private String postCode;
    
    public Address()
    {
        this("","","","");
    }
    public Address(String cityName, String streetName, String apartment, String postCode)
    {
        this.cityName = cityName;
        this.streetName = streetName;
        this.apartment = apartment;
        this.postCode = postCode;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" + "cityName=" + cityName + ", streetName=" + streetName + ", apartment=" + apartment + ", postCode=" + postCode + '}';
    }
    
    
}
