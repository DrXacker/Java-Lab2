import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void examplesTest(){
        Сalculator exampleTest = new Сalculator("2+3*5");
        double answer = exampleTest.mainCalc();
        assertEquals(15.0d, answer);
    }

}