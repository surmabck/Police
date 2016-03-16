/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.person.suspect;

import java.util.Objects;
import model.person.Person;

/**
 *
 * @author Bartosz
 */
public class Suspect extends Person {

    private Integer credibility;
    private Integer amountOfCasesAgainst;

    public Suspect() {
        super();
        credibility = 0;
        amountOfCasesAgainst = 0;
    }

    public Integer getCredibility() {
        return credibility;
    }

    public void setCredibility(Integer credibility) {
        this.credibility = credibility;
    }

    public Integer getAmountOfCasesAgainst() {
        return amountOfCasesAgainst;
    }

    public void setAmountOfCasesAgainst(Integer amountOfCasesAgainst) {
        this.amountOfCasesAgainst = amountOfCasesAgainst;
    }

    @Override
    public String toString() {
        return "Suspect{" + "credibility=" + credibility + ", amountOfCasesAgainst=" + amountOfCasesAgainst + ", " + super.toString() + '}';
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 37 * hash + Objects.hashCode(this.credibility);
        hash = 37 * hash + Objects.hashCode(this.amountOfCasesAgainst);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Suspect other = (Suspect) obj;
            if (!Objects.equals(this.credibility, other.credibility)) {
                return false;
            }
            if (!Objects.equals(this.amountOfCasesAgainst, other.amountOfCasesAgainst)) {
                return false;
            }
        }

        return true;
    }

}
