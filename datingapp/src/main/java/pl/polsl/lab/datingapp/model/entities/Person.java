/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.datingapp.model.entities;

import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.exceptions.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Person entity class
 * @version 0.0.2
 * @author Tomasz Knura
 */
public class Person {
    /** identity unique for each person */
    private int id;
    /** first name of a person */
    private String firstName;
    /** last name of a person */
    private String lastName;
    /** gender of a person */
    private Gender gender;
    /** date of birth of a person */
    private LocalDate dateOfBirth;
    /** preferences of a person */
    private Preferences preferences;

    /** field which is used for providing unique ids for every created person */
    private static int idProvider = 0;

    /**
     * non-argument constructor
     */
    public Person() {
        this.id = idProvider++;
    }

    /**
     * Argument constructor
     * @param firstName first name of a person
     * @param lastName last name of a person
     * @param gender gender of a person
     * @param dateOfBirth date of birth of a person as a LocalDate object
     * @param preferences preferences of a person
     */
    public Person(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, Preferences preferences) {
        this.id = idProvider++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.preferences = preferences;
    }

    /**
     * Argument constructor
     * @param firstName first name of a person
     * @param lastName last name of a person
     * @param gender gender of a person
     * @param dateOfBirth date of birth of a person as a String object
     * @param preferences preferences of a person
     */
    public Person(String firstName, String lastName, Gender gender, String dateOfBirth, Preferences preferences)
            throws InvalidDateFormatException {
        this.id = idProvider++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.preferences = preferences;
        setDateOfBirth(dateOfBirth);
    }

    /**
     * Id getter
     * @return id of a person
     */
    public int getId() { return id; }

    /**
     * First name getter
     * @return first name of a person as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name setter
     * @param firstName firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name getter
     * @return last name of a person as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name setter
     * @param lastName firstName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date of birth name getter
     * @return date of birth of person
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date of birth name setter
     * @param dateOfBirth date of birth to set
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Date of birth name setter
     * @param dateOfBirth date of birth as a String to set
     * @throws InvalidDateFormatException if given date string is invalid format
     */
    public void setDateOfBirth(String dateOfBirth) throws InvalidDateFormatException {
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(dateOfBirth);
        if(matcher.matches()) {
            this.dateOfBirth = LocalDate.parse(dateOfBirth);
        } else {
            throw new InvalidDateFormatException("Invalid date format");
        }

    }

    /**
     * Preferences getter
     * @return preferences object of a person
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * Preferences setter
     * @param preferences preferences object of a person
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * Gender getter
     * @return gender of a person
     */
    public Gender getGender() { return gender; }

    /**
     * Gender setter
     * @param gender gender of a person
     */
    public void setGender(Gender gender) { this.gender = gender; }

    /**
     * Method which calculate age of a person
     * @return get age calculated based on date of birth
     */
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * Method which parse person object to string
     * @return person as a string object
     */
    public String toString() {
        return ("First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Gender: " + gender.toString() + "\n" +
                "Age: " + getAge() + "\n" +
                "Hobbies: " + preferences.getHobbies().toString());
    }
}
