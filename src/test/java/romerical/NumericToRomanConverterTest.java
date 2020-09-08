package romerical;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NumericToRomanConverterTest {

    private int toConvert;
    private String converted;

    public NumericToRomanConverterTest(int valueToConvert, String expectedResult){
        this.toConvert = valueToConvert;
        this.converted = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{
                {1, "I"},{2, "II"},{4, "IV"},{9, "IX"},
                {10, "X"},{25, "XXV"},{49, "XLIX"},{50, "L"},{99, "XCIX"},
                {999, "CMXCIX"},{1001, "MI"},{2010, "MMX"},{555, "DLV"}
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void aNegativeNumberShouldNotBeConverted(){
        NumericToRomanConverter.toRoman(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aNumberBiggerThan4999ShouldNotBeConverted(){
        NumericToRomanConverter.toRoman(5000);
    }

    @Test
    public void cornerCaseMaxConversion(){
        String result = NumericToRomanConverter.toRoman(4999);

        Assert.assertEquals("MMMMCMXCIX", result);
    }

    @Test
    public void shouldReturnCorrectConversion(){
        String result = NumericToRomanConverter.toRoman(toConvert);
        Assert.assertEquals(converted, result);
    }

}
