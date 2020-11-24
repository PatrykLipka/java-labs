package pl.polsl.lab.datingapp.model.repositories;

import pl.polsl.lab.datingapp.model.entities.Person;
import pl.polsl.lab.datingapp.model.entities.Preferences;
import pl.polsl.lab.datingapp.model.enums.Gender;
import pl.polsl.lab.datingapp.model.enums.Hobby;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class which holds list of persons
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class PersonRepository extends Repository<Person> {

    public PersonRepository() {
        setList(new ArrayList<>(Arrays.asList(new Person(
                        "Monika",
                        "Harnaś",
                        Gender.FEMALE,
                        LocalDate.of(1990, 12, 23),
                        new Preferences(
                                3,
                                Gender.MALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.MUSIC,
                                        Hobby.BOOKS,
                                        Hobby.BASKETBALL,
                                        Hobby.CINEMA
                                ))
                        )
                ),
                new Person(
                        "Andrzej",
                        "Tatra",
                        Gender.MALE,
                        LocalDate.of(1980, 12, 23),
                        new Preferences(
                                10,
                                Gender.FEMALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.FOOTBALL,
                                        Hobby.FISHING,
                                        Hobby.CYCLING,
                                        Hobby.COOKING
                                ))
                        )
                ),
                new Person(
                        "Michał",
                        "Żubr",
                        Gender.MALE,
                        LocalDate.of(1999, 12, 23),
                        new Preferences(
                                5,
                                Gender.MALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.MUSIC,
                                        Hobby.COOKING,
                                        Hobby.BASKETBALL,
                                        Hobby.FISHING
                                ))
                        )
                ),
                new Person(
                        "Grażyna",
                        "Kustosz",
                        Gender.FEMALE,
                        LocalDate.of(1985, 12, 23),
                        new Preferences(
                                2,
                                Gender.MALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.FISHING,
                                        Hobby.SKATING,
                                        Hobby.BASKETBALL,
                                        Hobby.CINEMA
                                ))
                        )
                ),
                new Person(
                        "Antoni",
                        "Perła",
                        Gender.MALE,
                        LocalDate.of(1998, 12, 23),
                        new Preferences(
                                4,
                                Gender.FEMALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.MUSIC,
                                        Hobby.BOOKS,
                                        Hobby.DRAWING,
                                        Hobby.CINEMA
                                ))
                        )
                ),
                new Person(
                        "Kasia",
                        "Kozel",
                        Gender.FEMALE,
                        LocalDate.of(1995, 12, 23),
                        new Preferences(
                                10,
                                Gender.FEMALE,
                                new ArrayList<Hobby>(Arrays.asList(
                                        Hobby.CHESS,
                                        Hobby.KNITTING,
                                        Hobby.TRAVELING,
                                        Hobby.CINEMA
                                ))
                        )
                )
        )));
    }
}
