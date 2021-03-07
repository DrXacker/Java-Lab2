import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void examplesTest(){
        Сalculator exampleTest = new Сalculator("3 +(7 -5/ (2+3))* (7-2)");
        double answer = exampleTest.mainCalc();
        assertEquals(33.0d, answer);
    }

}