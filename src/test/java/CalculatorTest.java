import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void examplesTest(){
        Сalculator exampleTest = new Сalculator("-10+100-50-23");
        double answer = exampleTest.mainCalc();
        assertEquals(17.0d, answer);
    }

}