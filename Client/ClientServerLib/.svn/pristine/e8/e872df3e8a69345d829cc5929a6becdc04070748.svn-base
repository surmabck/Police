/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import java.io.Serializable;
import javafx.beans.property.*;

/**
 *
 * @author Bartosz
 */
public class AddressProperties implements Serializable{

    private StringProperty cityName;

    private StringProperty streetName;

    private StringProperty apartment;

    private StringProperty postCode;

    public AddressProperties() {
        this(null, null, null, null);
    }

    public AddressProperties(String cityName, String streetName, String apartment, String postCode) {

        this.cityName =  new SimpleStringProperty(cityName);
        this.streetName =new SimpleStringProperty( streetName);
        this.apartment =new SimpleStringProperty( apartment);
        this.postCode = new SimpleStringProperty(postCode);
    }

    public StringProperty getPostCodeProperty() {
        return postCode;
    }

    /**
     * Get the value of postCode
     *
     * @return the value of postCode
     */
    public String getPostCode() {
        return postCode.get();
    }

    /**
     * Set the value of postCode
     *
     * @param postCode new value of postCode
     */
    public void setPostCode(String postCode) {
        this.postCode.set(postCode);
    }

    public StringProperty getApartmentProperty() {
        return apartment;
    }

    /**
     * Get the value of apartment
     *
     * @return the value of apartment
     */
    public String getApartment() {
        return apartment.get();
    }

    /**
     * Set the value of apartment
     *
     * @param apartment new value of apartment
     */
    public void setApartment(String apartment) {
        this.apartment.set(apartment);
    }

    /**
     * Get the value of streetName
     *
     * @return the value of streetName
     */
    public StringProperty getStreetNameProperty() {
        return streetName;
    }

    public String getStreetName() {
        return streetName.get();
    }

    /**
     * Set the value of streetName
     *
     * @param streetName new value of streetName
     */
    public void setStreetName(String streetName) {
        this.streetName.set(streetName);
    }

    /**
     * Get the value of cityName
     *
     * @return the value of cityName
     */
    public StringProperty getCityNameProperty() {
        return cityName;
    }

    public String getCityName() {
        return cityName.get();
    }

    /**
     * Set the value of cityName
     *
     * @param cityName new value of cityName
     */
    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }
    public Address getModel()
    {
        return new Address(getCityName(),getStreetName(),getApartment(),getPostCode());
    }
    @Override
    public String toString() {
        return "Address{" + "cityName=" + cityName + ", streetName=" + streetName + ", apartment=" + apartment + ", postCode=" + postCode + '}';
    }

}
