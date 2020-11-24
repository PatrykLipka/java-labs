package pl.polsl.lab.datingapp.model.entities;

import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;

import java.util.ArrayList;
import java.util.List;
import pl.polsl.lab.datingapp.model.exceptions.EmptyListException;

/**
 * Preferences entity class
 * @version 0.0.2
 * @author Tomasz Knura
 */
public class Preferences {
    /** maximal age difference preference */
    private int ageDifference;
    /** interest in gender preference */
    private Gender interestGender;
    /** hobbies preference */
    private List<Hobby> hobbies;

    /**
     * Non argument constructor
     */
    public Preferences() {
        this.ageDifference = 0;
        this.hobbies = new ArrayList<>();
    }

    /**
     * Argument constructor
     * @param ageDifference maximal age difference preference
     * @param interestGender interest in gender preference
     * @param hobbies hobbies preference
     */
    public Preferences(int ageDifference, Gender interestGender, List<Hobby> hobbies) {
        this.ageDifference = ageDifference;
        this.interestGender = interestGender;
        this.hobbies = hobbies;
    }

    /**
     * Age difference getter
     * @return preferred age difference
     */
    public int getAgeDifference() {
        return ageDifference;
    }

    /**
     * Age difference setter
     * @param ageDifference prefered age difference
     */
    public void setAgeDifference(int ageDifference) {
        this.ageDifference = ageDifference;
    }

    /**
     * Interest gender getter
     * @return gender of interests
     */
    public Gender getInterestGender() { return interestGender; }

    /**
     * Interest gender setter
     * @param interestGender gender of interests
     */
    public void setInterestGender(Gender interestGender) { this.interestGender = interestGender; }

    /**
     * Hobbies getter
     * @return list of hobbies
     */
    public List<Hobby> getHobbies() {
        return hobbies;
    }

    /**
     * Hobbies setter
     * @param hobbies list of hobbies
     */
    public void setHobbies(List<Hobby> hobbies) throws EmptyListException {
        if(!hobbies.isEmpty()) {
            this.hobbies = hobbies;
        } else {
            throw new EmptyListException();
        }
    }
}
