package pl.polsl.lab.datingapp.model.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import pl.polsl.lab.datingapp.model.entities.Person;

/**
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class RepositoryTest {
    /**
     * Method which is executed before all the tests
     */
    @BeforeEach
    public void setUp() {
        RepositoryImpl repositoryImpl = new RepositoryImpl();
    }
    
    /**
     * Test of addItem method, of class Repository.
     */
    @ParameterizedTest
    public void testAddItem() {
    }

    /**
     * Test of removeItem method, of class Repository.
     */
    @ParameterizedTest
    public void testRemoveItem() {
    }

    /**
     * Test of findByIndex method, of class Repository.
     */
    @ParameterizedTest
    public void testFindByIndex() {
    }

    /**
     * Inner class with sample repository implementation on PersonClass
     */
    public class RepositoryImpl extends Repository<Person> {
        RepositoryImpl() {
            super();
        }
    }
}
