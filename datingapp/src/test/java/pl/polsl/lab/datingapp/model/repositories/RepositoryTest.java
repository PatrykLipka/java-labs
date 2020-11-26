package pl.polsl.lab.datingapp.model.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.datingapp.model.entities.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @version 0.0.1
 * @author Tomasz Knura
 */
public class RepositoryTest {
    private RepositoryImpl repositoryImpl;
    /**
     * Method which is executed before all the tests
     */
    @BeforeEach
    public void setUp() {
        repositoryImpl = new RepositoryImpl();
    }
    
    /**
     * Test of addItem method, of class Repository.
     */
    @ParameterizedTest
    @ValueSource(ints = {10})
    public void testAddItem(int amount) {
        for(int i = 0; i < amount; i++) {
            Person p = new Person();
            repositoryImpl.addItem(p);
        }
        assertEquals(amount, repositoryImpl.getList().size());
    }

    /**
     * Test of removeItem method, of class Repository.
     */
    @ParameterizedTest
    @CsvSource({"2,10", "4,10", "0,10", "9,10"})
    public void testRemoveItem(int index, int amount) {
        for(int i = 0; i < amount; i++) {
            Person p = new Person();
            repositoryImpl.addItem(p);
        }
        repositoryImpl.removeItem(index);
        assertEquals(amount - 1, repositoryImpl.getList().size());
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
