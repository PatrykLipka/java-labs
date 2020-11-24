package pl.polsl.lab.datingapp.model.enums;

import org.apache.commons.lang3.StringUtils;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Gender tests class
 * @author Tomasz Knura
 * @version 0.0.1
 */
public class GenderTest {
    
    /**
     * Test of toString method, of class Gender.
     * @param gender hobby which will be tested
     */
    @ParameterizedTest
    @EnumSource(Gender.class)
    public void testToString(Gender gender) {
        assertTrue(StringUtils.isAllLowerCase(gender.toString()));
    }
}
