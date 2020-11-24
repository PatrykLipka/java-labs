package pl.polsl.lab.datingapp.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Gender enum class
 * @version 0.0.1
 * @author Tomasz Knura
 */
public enum Gender {
    MALE,
    FEMALE;

    /**
     * Simple to string conversion method
     * @return enum object name as a lowercase String
     */
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    /**
     * Method which get all possible enum values
     * @return all enum values as a list
     */
    public static List<Gender> getAllValues() {
        return Arrays.asList(Gender.values());
    }

    /**
     * Method which get all possible enum values as a string list
     * @return all enum values as a string list
     */
    public static List<String> getAllValuesAsString() {
        List<String> result = new ArrayList<>();
        for(Gender h : Gender.values()) {
            result.add(h.toString());
        }
        return result;
    }
}
