/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person.suspect;

import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.person.PersonProperties;

/**
 *
 * @author Bartosz
 */
public class SuspectProperties extends PersonProperties{
    private IntegerProperty credibility;
    private IntegerProperty amountOfCasesAgainst;
    public SuspectProperties() {
        this("",0,"",0,0,"","","","",0,0);
    }

    public SuspectProperties(
            String name, Integer id, String surname, Integer phoneNumber, Integer age, String cityName, 
            String streetName, String apartment, String postCode,int credibility,int amountOfCasesAgainst) {
        super(name, id, surname, phoneNumber, age, cityName, streetName, apartment, postCode);
        this.credibility = new SimpleIntegerProperty(credibility);
        this.amountOfCasesAgainst = new SimpleIntegerProperty(amountOfCasesAgainst);
    }
    public IntegerProperty getCredibilityProperty() {
        return credibility;
    }

    public IntegerProperty getAmountOfCasesAgainstProperty() {
        return amountOfCasesAgainst;
    }



    public void setCredibilityProperty(IntegerProperty credibility) {
        this.credibility = credibility;
    }

    
    public void setAmountOfCasesAgainstProperty(IntegerProperty amountOfCasesAgainst) {
        this.amountOfCasesAgainst = amountOfCasesAgainst;
    }


    public Integer getCredibility() {
        return credibility.get();
    }

    public Integer getAmountOfCasesAgainst() {
        return amountOfCasesAgainst.get();
    }

    public void setCredibility(Integer credibility) {
        this.credibility.set(credibility);
    }

    public void setAmountOfCasesAgainst(Integer amountOfCasesAgainst) {
        this.amountOfCasesAgainst.set(amountOfCasesAgainst);
    }
    
    public Suspect getModel() {
        Suspect ret = new Suspect();
        ret.setName(getName());
        ret.setSurname(getSurname());
        ret.setAge(getAge());
        ret.setPhoneNumber(getPhoneNumber());
        ret.setAddress(getAddress().getModel());
        ret.setId(getId());
        ret.setAmountOfCasesAgainst(getAmountOfCasesAgainst());
        ret.setCredibility(getCredibility());
        return ret;
    }

    public void setModel(Suspect user) {
        setId(user.getId());
        setAge(user.getAge());
        setName(user.getName());
        setPhoneNumber(user.getPhoneNumber());
        setSurname(user.getSurname());
        setAddress(user.getAddress().getApartment(), user.getAddress().getCityName(), user.getAddress().getPostCode(), user.getAddress().getStreetName());
        setCredibility(user.getCredibility());
        setAmountOfCasesAgainst(user.getAmountOfCasesAgainst());
    }

    
}
