import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void examplesTest(){
        Сalculator exampleTest = new Сalculator("");
        double answer = exampleTest.mainCalc();
        assertEquals(0.0d, answer);
    }

}