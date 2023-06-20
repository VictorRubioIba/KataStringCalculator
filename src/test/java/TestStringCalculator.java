import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void testEmptyString(){

        String emptyString = "";
        int sumOfDigits = 0;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testOneDigitString(){

        String emptyString = "4";
        int sumOfDigits = 4;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testTwoDigitString(){

        String emptyString = "1,2";
        int sumOfDigits = 3;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testLotDigitString(){

        String emptyString = "1,2,3,4,5,6,7,8,9";
        int sumOfDigits = 45;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testDifferentSeparatorDigitString(){

        String emptyString = "1\n2,3";
        int sumOfDigits = 6;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test

    public void testPersonalSeparatorDigitString(){

        String emptyString = "\n1;2";
        int sumOfDigits = 3;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test

    public void testNegativeNumbersDigitString(){

        String emptyString = "1,-2,-3";
        try {
            stringCalculator.Add(emptyString);

        }catch ( NegativeNumberException.NegativesNotAllowed e){
            Assertions.assertEquals(e.getMessage(),"Negatives Not Allowed. Numbers are: -2 -3 " );
        }


    }
    @Test
    public void testGreaterOneThousandNumbersDigitString(){

        String emptyString = "1001, 2";
        int sumOfDigits = 2;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testMultipleSeparatorDigitString(){

        String emptyString = "//[*][%]\n1*2%3";
        int sumOfDigits = 6;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
    @Test
    public void testMultipleLongerLengthSeparatorDigitString(){

        String emptyString = "//[foo][bar]\n1foo2bar3";
        int sumOfDigits = 6;
        Assertions.assertEquals( stringCalculator.Add(emptyString),sumOfDigits);
    }
}
