/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.police.model;

import model.person.PersonProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Bartosz
 */
public class SearchModel {

    private ObservableList<PersonProperties> people = FXCollections.observableArrayList();
    public SearchModel() {
    }
    public void setPeople(ObservableList<PersonProperties> people) {
        this.people = people;
    }
    public void deletePerson(PersonProperties p)
    {
        this.people.remove(p);
    }
    public ObservableList<PersonProperties> getPeople() {
        return people;
    }
    public void addPerson(PersonProperties person)
    {
        this.people.add(person);
    }
    public ObservableList<PersonProperties>  getPeopleByName(String name)
    {
        ObservableList<PersonProperties> ppl =  FXCollections.observableArrayList();
        for (PersonProperties p : people)
        {
            if (p.getName().equalsIgnoreCase(name))
                ppl.add(p);
        }
        return ppl;
    }

}
