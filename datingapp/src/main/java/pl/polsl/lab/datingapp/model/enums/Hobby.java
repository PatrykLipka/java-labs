package pl.polsl.lab.datingapp.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hobby enum class
 * @version 0.0.1
 * @author Tomasz Knura
 */
public enum Hobby {
    FOOTBALL,
    CHESS,
    MUSIC,
    VAPE,
    FISHING,
    TRAVELING,
    CINEMA,
    SWIMMING,
    BOOKS,
    KNITTING,
    PHOTOGRAPHY,
    COOKING,
    SKIING,
    SKATING,
    CYCLING,
    RUNNING,
    SPORT,
    PARTYING,
    BASKETBALL,
    DRAWING;

    /**
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
    public static List<Hobby> getAllValues() {
        return Arrays.asList(Hobby.values());
    }

     /**
     * Method which get all possible enum values as a string list
     * @return all enum values as a string list
     */
    public static List<String> getAllValuesAsString() {
        List<String> result = new ArrayList<>();
        for(Hobby h : Hobby.values()) {
            result.add(h.toString());
        }
        return result;
    }
}