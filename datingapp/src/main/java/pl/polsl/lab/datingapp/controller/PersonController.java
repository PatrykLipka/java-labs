package pl.polsl.lab.datingapp.controller;

import pl.polsl.lab.datingapp.model.entities.Person;
import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;
import pl.polsl.lab.datingapp.model.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller which controls person repository
 * @version 0.0.2
 * @author Tomasz Knura
 */
public class PersonController {
    /** persons repository */
    private PersonRepository personRepository;

    /**
     * Argument constructor
     * @param personRepository repository with persons data
     */
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Method which search for a date for passed person object
     * @param person person object which date we are searching for
     * @return person which is best matching passed person
     */
    public Person findADate(Person person) {
        List<Person> candidatesList = person.getPreferences().getInterestGender() == Gender.MALE ?
                getAllByGender(Gender.MALE) : person.getPreferences().getInterestGender() == Gender.FEMALE ?
                getAllByGender(Gender.FEMALE) : getAll();
        int bestMatchScore = 0;
        Person resultDate = null;

        for(Person p : candidatesList) {
            if(person != p) {
                int currentPersonMatchScore = CalculateMatch(person, p);
                if (bestMatchScore < currentPersonMatchScore) {
                    bestMatchScore = currentPersonMatchScore;
                    resultDate = p;
                }
            }
        }
        return resultDate;
    }

    /**
     * Method which get all persons filtered by their gender
     * @param gender gender of persons we are looking for
     * @return list of person with given gender
     */
    public List<Person> getAllByGender(Gender gender) {
        List<Person> resultList = personRepository.getList()
                .stream()
                .filter(p -> p.getGender() == gender)
                .collect(Collectors.toList());

        return resultList;
    }

    /**
     * Method which get all persons from repository
     * @return list of all persons
     */
    public List<Person> getAll() {
        return personRepository.getList();
    }

    /**
     * Method which calculate the score between two person objects
     * @param p1 first person
     * @param p2 second person
     * @return score of a match between given persons
     */
    public int CalculateMatch(Person p1, Person p2) {
        int score = 0;
        if ((p1.getAge() - p2.getAge()) <= p1.getPreferences().getAgeDifference()) {
            score += 5;
        }
        if ((p1.getAge() - p2.getAge()) <= p2.getPreferences().getAgeDifference()) {
            score += 5;
        }
        for (Hobby h1 : p1.getPreferences().getHobbies()) {
            for (Hobby h2 : p2.getPreferences().getHobbies()) {
                if (h2 == h1) {
                    score += 1;
                }
            }
         }
        return score;
    }
}
