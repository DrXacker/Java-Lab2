import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    public void examplesTest() throws Exception {
        Сalculator exampleTest = new Сalculator("-2+2");
        assertEquals(0.0d, exampleTest.mainCalc());

        exampleTest = new Сalculator("sin(0)^2+cos(0)^2");
        assertEquals(1.0d, exampleTest.mainCalc());

        exampleTest = new Сalculator("P-3");
        assertEquals(Math.PI-3, exampleTest.mainCalc());

        exampleTest = new Сalculator("2-");
        assertThrows(Exception.class, exampleTest::mainCalc);

    }

}