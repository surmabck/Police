/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.cases;

import javafx.beans.property.IntegerProperty;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.person.suspect.Suspect;
import model.person.suspect.SuspectProperties;
import model.person.user.UserProperties;
import model.person.witness.Witness;
import model.person.witness.WitnessProperties;

/**
 *
 * @author Bartosz
 */
public class PoliceCaseProperties {

    private ObjectProperty<PoliceCaseState> state;
    private ObjectProperty<UserProperties> officer;
    private StringProperty description;
    private StringProperty longDescription;
    private IntegerProperty id;
    private ObservableList<WitnessProperties> victims = FXCollections.observableArrayList();
    private ObservableList<SuspectProperties> suspects = FXCollections.observableArrayList();
    public PoliceCaseProperties() {
        state = new SimpleObjectProperty<>(PoliceCaseState.completed);
        officer = new SimpleObjectProperty<>(new UserProperties());
        description = new SimpleStringProperty("Opis");
        id = new SimpleIntegerProperty(0);
        longDescription = new SimpleStringProperty("Dlugi opis");
    }
    public ObjectProperty<PoliceCaseState> getState() {
        return state;
    }

    public void setState(ObjectProperty<PoliceCaseState> state) {

        this.state = state;
    }

    public ObjectProperty<UserProperties> getOfficer() {
        return officer;
    }

    public void setOfficer(ObjectProperty<UserProperties> officer) {
        this.officer = officer;
    }

    public ObservableList<WitnessProperties> getVictims() {
        return victims;
    }

    public void setVictims(ObservableList<WitnessProperties> victims) {
        this.victims = victims;
    }

    public ObservableList<SuspectProperties> getSuspects() {
        return suspects;
    }

    public void setSuspects(ObservableList<SuspectProperties> suspects) {
        this.suspects = suspects;
    }

    public StringProperty getDescription() {
        return description;
    }

    public void setDescription(StringProperty description) {
        this.description = description;
    }

    public IntegerProperty getId() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(StringProperty longDescription) {
        this.longDescription = longDescription;
    }

    
    @Override
    public String toString() {
        return "PoliceCaseProperties{" + "state=" + state + ", officer=" + officer + ", description=" + description + ", id=" + id + ", victims=" + victims + ", suspects=" + suspects + '}';
    }

    public PoliceCase getModel() {
        PoliceCase ret = new PoliceCase();
        for (SuspectProperties s : suspects) {
            ret.getSuspects().add(s.getModel());

        }
        for (WitnessProperties s : victims) {
            ret.getVictims().add(s.getModel());
        }
        ret.setOfficer(getOfficer().get().getModel());
        ret.setState(getState().get());
        ret.setDescription(getDescription().get());
        ret.setId(getId().get());
        ret.setLongDescription(getLongDescription().get());
        return ret;
    }

    public void setModel(PoliceCase p) {
        suspects.remove(0, suspects.size());
        victims.remove(0, victims.size());

        for (Suspect s : p.getSuspects()) {
            SuspectProperties suspect = new SuspectProperties();
            suspect.setModel(s);
            suspects.add(suspect);
        }
        for (Witness w : p.getVictims()) {
            WitnessProperties witness = new WitnessProperties();
            witness.setModel(w);
            victims.add(witness);
        }
        UserProperties of = new UserProperties();
        of.setModel(p.getOfficer());
        getOfficer().set(of);
        getState().set(p.getState());
        getDescription().set(p.getDescription());
        getId().set(p.getId());
        getLongDescription().set(p.getLongDescription());
    }

}
