package romerical;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RomanToNumericConverterTest {

    private int converted;
    private String toConvert;

    public RomanToNumericConverterTest(String valueToConvert, int expectedResult){
        this.toConvert = valueToConvert;
        this.converted = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {"I", 1},{"II", 2},{"IV", 4},{"IX", 9},
                {"X", 10},{"XXV", 25},{"XLIX", 49},{"L", 50},{"XCIX", 99},
                {"CMXCIX", 999},{"MI", 1001},{"MMX", 2010},{"DLV", 555}
        });
    }

    @Test
    public void shouldReturnCorrectConversion(){
        int result = RomanToNumericConverter.toNumeric(toConvert);
        Assert.assertEquals(converted, result);
    }

    @Test(expected = NotARomanNumberException.class)
    public void shouldThrowNotARomanNumberExceptionOnNonRomanNumbers(){
        String notARomanNumber = "IIII";

        RomanToNumericConverter.toNumeric(notARomanNumber);
    }

}
