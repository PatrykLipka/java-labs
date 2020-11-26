package pl.polsl.lab.datingapp.model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;

/**
 * Preferences tests class
 * @author Tomasz Knura
 * @version 0.0.1
 */
public class PreferencesTest {
    private Preferences preferences;

    /**
     * Method which is executed before all the tests
     */
    @BeforeEach
    public void setUp() {
        preferences = new Preferences(
                5,
                Gender.MALE,
                new ArrayList<>(Arrays.asList(
                        Hobby.CINEMA,
                        Hobby.CHESS,
                        Hobby.FOOTBALL)
                )
        );
    }
    
    /**
     * Test of setHobbies method, of class Preferences.
     * @param hobbies list of hobbies which will be tested
     */
    @ParameterizedTest
    @EmptySource
    public void testSetHobbies(List<Hobby> hobbies) {
        try {
          preferences.setHobbies(hobbies);
          fail("An exception should be thrown");
        } catch (Exception e) {}
    }
}
