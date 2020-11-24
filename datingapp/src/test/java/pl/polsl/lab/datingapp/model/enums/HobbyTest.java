package pl.polsl.lab.datingapp.model.enums;

import org.apache.commons.lang3.StringUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Hobby tests class
 * @author Tomasz Knura
 * @version 0.0.1
 */
public class HobbyTest {
    
    /**
     * Test of toString method, of class Gender.
     * @param hobby hobby which will be tested
     */
    @ParameterizedTest
    @EnumSource(Hobby.class)
    public void testToString(Hobby hobby) {
        assertTrue(StringUtils.isAllLowerCase(hobby.toString()));
    }
}
