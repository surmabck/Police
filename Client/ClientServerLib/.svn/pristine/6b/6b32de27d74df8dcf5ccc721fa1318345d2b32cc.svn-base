/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person.user;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.person.PersonProperties;

/**
 *
 * @author Bartosz
 */
public class UserProperties extends PersonProperties {
    private StringProperty login;
    private StringProperty password;
    private ObjectProperty<UserType> type;
    private StringProperty sessionId;

    public UserProperties() {
        this("","");
    }
    public UserProperties(String login, String password)
    {
       this(login,password,UserType.Officer,"");
    }
    public UserProperties(String login,String password, UserType type,String sessionId)
    {
       this("",0,"",0,0,"","","","",login,password,type,sessionId); 
    }
    public UserProperties(String name, Integer id, String surname, Integer phoneNumber,
            Integer age, String cityName, String streetName,
            String apartment, String postCode, String login, String password,UserType type,String sessionId) 
    {
        super(name, id, surname, phoneNumber, age, cityName, streetName, apartment, postCode);
        this.password = new SimpleStringProperty(password);
        this.login = new SimpleStringProperty(login);
        this.type = new SimpleObjectProperty<>(type);
        this.sessionId = new SimpleStringProperty(sessionId);
    }
    
    public void setType(UserType type) {
        this.type.set(type);
    }

    public UserType getType() {
        return type.get();
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLoginProperty(StringProperty login) {
        this.login = login;
    }

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public StringProperty getLoginProperty() {
        return login;
    }

    public String getLogin() {
        return login.get();
    }

    public UserProperties setLogin(String login) {
        this.login.set(login);
        return this;
    }
    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public StringProperty getPasswordProperty() {
        return password;
    }
    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPasswordProperty(StringProperty password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password.get();
    }

    public UserProperties setPassword(String password) {
        this.password.set(password);
        return this;
    }

    public String getSessionId() {
        return sessionId.get();
    }
    public StringProperty getSessionIdProperty()
    {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId.set(sessionId);
    }
    
    @Override
    public User getModel()
    {
        User ret = new User();
        ret.setAge(getAge());
        ret.setId(getId());
        ret.setLogin(getLogin());
        ret.setName(getName());
        ret.setPassword(getPassword());
        ret.setPhoneNumber(getPhoneNumber());
        ret.setSurname(getSurname());
        ret.setType(getType());
        ret.setSessionId(getSessionId());
        ret.setAddress(getAddress().getModel());
        return ret;
    }
    public void setModel(User user)
    {
        super.setModel(user);
      //  setAge(user.getAge());
        setLogin(user.getLogin());
       // setName(user.getName());
        setPassword(user.getPassword());
       // setPhoneNumber(user.getPhoneNumber());
      //  setSurname(user.getSurname());
        setType(user.getType());
        setSessionId(user.getSessionId());
       // setAddress(user.getAddress().getApartment(), user.getAddress().getCityName(), user.getAddress().getPostCode(), user.getAddress().getStreetName());
    }
}
