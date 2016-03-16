/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person.witness;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.person.PersonProperties;

/**
 *
 * @author Bartosz
 */
public class WitnessProperties extends PersonProperties {

    private IntegerProperty credibility;
    private BooleanProperty isRelatedWithSuspect;
    private BooleanProperty isUnderProtection;

    public WitnessProperties() {
        this("", 0, "", 0, 0, "", "", "", "");
    }

    public WitnessProperties(String name, Integer id, String surname, Integer phoneNumber, Integer age, String cityName,
            String streetName, String apartment, String postCode) {
        this(100, false, false, name, id, surname, phoneNumber, age, cityName, streetName, apartment, postCode);
    }

    public WitnessProperties(Integer credibility, Boolean isRelatedWithSuspect,
            Boolean isUnderProtection, String name, Integer id,
            String surname, Integer phoneNumber, Integer age, String cityName,
            String streetName, String apartment, String postCode) {
        super(name, id, surname, phoneNumber, age, cityName, streetName, apartment, postCode);
        this.credibility = new SimpleIntegerProperty(credibility);
        this.isRelatedWithSuspect = new SimpleBooleanProperty(isRelatedWithSuspect);
        this.isUnderProtection = new SimpleBooleanProperty(isUnderProtection);
    }

    public void setCredibilityProperty(IntegerProperty credibility) {
        this.credibility = credibility;
    }

    public void setIsRelatedWithSuspectProperty(BooleanProperty isRelatedWithSuspect) {
        this.isRelatedWithSuspect = isRelatedWithSuspect;
    }

    public void setIsUnderProtectionProperty(BooleanProperty isUnderProtection) {
        this.isUnderProtection = isUnderProtection;
    }

    public IntegerProperty getCredibilityProperty() {
        return credibility;
    }

    public BooleanProperty getIsRelatedWithSuspectProperty() {
        return isRelatedWithSuspect;
    }

    public BooleanProperty getIsUnderProtectionProperty() {
        return isUnderProtection;
    }

    public void setCredibility(Integer credibility) {
        this.credibility.set(credibility);
    }

    public void setIsRelatedWithSuspect(Boolean isRelatedWithSuspect) {
        this.isRelatedWithSuspect.set(isRelatedWithSuspect);
    }

    public void setIsUnderProtection(Boolean isUnderProtection) {
        this.isUnderProtection.set(isUnderProtection);
    }

    public Integer getCredibility() {
        return credibility.get();
    }

    public Boolean getIsRelatedWithSuspect() {
        return isRelatedWithSuspect.get();
    }

    public Boolean getIsUnderProtection() {
        return isUnderProtection.get();
    }

    public Witness getModel() {
        Witness ret = new Witness();
        ret.setName(getName());
        ret.setSurname(getSurname());
        ret.setAge(getAge());
        ret.setPhoneNumber(getPhoneNumber());
        ret.setAddress(getAddress().getModel());
        ret.setId(getId());
        ret.setCredibility(getCredibility());
        ret.setIsRelatedWithSuspect(getIsRelatedWithSuspect());
        ret.setIsUnderProtection(getIsUnderProtection());
        return ret;
    }

    public void setModel(Witness user) {
        setId(user.getId());
        setAge(user.getAge());
        setName(user.getName());
        setPhoneNumber(user.getPhoneNumber());
        setSurname(user.getSurname());
        setAddress(user.getAddress().getApartment(), user.getAddress().getCityName(), user.getAddress().getPostCode(), user.getAddress().getStreetName());
        setCredibility(user.getCredibility());
        setIsRelatedWithSuspect(user.getIsRelatedWithSuspect());
        setIsUnderProtection(user.getIsUnderProtection());
    }
}
