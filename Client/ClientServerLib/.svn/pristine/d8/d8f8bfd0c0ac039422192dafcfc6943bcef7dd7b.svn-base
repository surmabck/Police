/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.person.suspect.Suspect;
import model.person.user.User;
import model.person.witness.Witness;

/**
 *
 * @author Bartosz
 */
public class PoliceCase implements Serializable{

    private PoliceCaseState state;
    private User officer;
    private String description;
    private String longDescription;
    private Integer id;
    private List<Witness> victims = new ArrayList<>();
    private List<Suspect> suspects = new ArrayList<>();

    public PoliceCaseState getState() {
        return state;
    }

    public void setState(PoliceCaseState state) {
        this.state = state;
    }

    public User getOfficer() {
        return officer;
    }

    public void setOfficer(User officer) {
        this.officer = officer;
    }

    public List<Witness> getVictims() {
        return victims;
    }

    public void setVictims(List<Witness> victims) {
        this.victims = victims;
    }

    public List<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(List<Suspect> suspects) {
        this.suspects = suspects;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @Override
    public String toString() {
        return "PoliceCase{" + "state=" + state + ", officer=" + officer + ", description=" + description + ", id=" + id + ", victims=" + victims + ", suspects=" + suspects + '}';
    }

    
    
}
