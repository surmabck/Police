/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person;

import model.person.Person;
import javafx.beans.property.*;

/**
 *
 * @author Bartosz
 */
public class PersonProperties {

    private StringProperty name;
    private IntegerProperty id;
    private StringProperty surname;
    private IntegerProperty phoneNumber;
    private IntegerProperty age;
    private ObjectProperty<AddressProperties> address;

    public void setPhoneNumber(IntegerProperty phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber.get();
    }

    public PersonProperties() {
        this("", 0, "", 0, 0, "", "", "", "");
    }

    public PersonProperties(String name, Integer id, String surname,
            Integer phoneNumber, Integer age, String cityName, String streetName, String apartment, String postCode) {
        this.name = new SimpleStringProperty(name);

        this.id = new SimpleIntegerProperty(id);

        this.surname = new SimpleStringProperty(surname);

        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);

        this.age = new SimpleIntegerProperty(age);
        this.address = new SimpleObjectProperty<>(new AddressProperties(cityName, streetName, apartment, postCode));
    }

    public AddressProperties getAddress() {
        return address.get();
    }

    public IntegerProperty getIdProperty() {
        return id;
    }

    public IntegerProperty getPhoneNumberProperty() {
        return phoneNumber;
    }

    public IntegerProperty getAgeProperty() {
        return age;
    }

    public ObjectProperty<AddressProperties> getAddressProperty() {
        return address;
    }

    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(AddressProperties address) {
        this.address.set(address);
    }

    public void setAddress(String apartment, String cityName, String postCode, String streetName) {
        getAddress().setApartment(apartment);
        getAddress().setCityName(cityName);
        getAddress().setPostCode(postCode);
        getAddress().setStreetName(streetName);
    }

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public Integer getAge() {
        return age.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public StringProperty getSurNameProperty() {
        return surname;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(Integer age) {
        this.age.set(age);
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    /**
     * Get the value of surname
     *
     * @return the value of surname
     */
    public String getSurname() {
        return surname.get();
    }

    /**
     * Set the value of surname
     *
     * @param surname new value of surname
     */
    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Integer getId() {
        return id.get();
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Integer id) {
        this.id.set(id);
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name.get();
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name.set(name);
    }

    public Person getModel() {
        return new Person(getName(), getId(), getSurname(), getPhoneNumber(), getAge(), getAddress().getModel());
    }

    public void setModel(Person user) {
        setId(user.getId());
        setAge(user.getAge());
        setName(user.getName());
        setPhoneNumber(user.getPhoneNumber());
        setSurname(user.getSurname());
        setAddress(user.getAddress().getApartment(), user.getAddress().getCityName(), user.getAddress().getPostCode(), user.getAddress().getStreetName());
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", age=" + age + ", address=" + address + '}';
    }

}
