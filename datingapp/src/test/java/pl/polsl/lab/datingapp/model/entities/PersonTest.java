package pl.polsl.lab.datingapp.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;
import pl.polsl.lab.datingapp.model.exceptions.InvalidDateFormatException;

/**
 * Person tests class
 * @author Tomasz Knura
 * @version 0.0.1
 */
public class PersonTest {
    private Person person;

    /**
     * Method which is executed before all the tests
     */
    @BeforeEach
    public void setUp() {
        person = new Person(
                "Karol",
                "Wiśniewski",
                Gender.MALE,
                LocalDate.of(1996, 01, 07),
                new Preferences(
                        5,
                        Gender.MALE,
                        new ArrayList<>(Arrays.asList(Hobby.CINEMA, Hobby.CHESS)))
        );
    }

    /**
     * Test of setDate method, of class Person.
     * @param date date which will be tested
     * @param isValid is passed date valid
     */
    @ParameterizedTest
    @CsvSource({"1995-12-15,true", "1990-01-20,true", "001-021-23,false", "1992-21-3,false"})
    @Order(0)
    public void testSetDate(String date, boolean isValid) {
        try {
            person.setDateOfBirth(date);
            assertTrue(person.getDateOfBirth().toString().equals(date));
        } catch(InvalidDateFormatException e) {
            if(!isValid){
                return;
            }
            fail(e.getMessage());
        }
    }
    
    /**
     * Test of getAge method, of class Person.
     * @param date date of birth of a person which age will be calculated
     * @param age age which should be a result
     */
    @ParameterizedTest
    @CsvSource({"1995-12-15,24", "1992-10-30,28", "1962-05-11,58"})
    @Order(1)
    public void testGetAge(String date, int age) throws InvalidDateFormatException {
        person.setDateOfBirth(date);
        assertTrue(age == person.getAge());
    }
}
