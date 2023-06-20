import java.util.Arrays;
import java.util.stream.Stream;

public class StringCalculator {

    public int Add(String numbers){

        if(numbers.length()==0){
           return 0;
        }else{
            return sumStrings(stringSeparator(numbers));
        }

    }

    private String[] stringSeparator(String numbers){
        String regex = "[^-\\d]";
        return numbers.split(regex);
    }

    private int sumStrings(String[] numbers){

         negativeNumberException(Arrays.stream(numbers)
                 .filter(el->el!="")
                 .mapToInt(Integer::parseInt)
                 .filter(el->el<0)
                 .toArray()
                 );


        return Arrays.stream(numbers)
                .filter(el->el!="")
                .mapToInt(Integer::parseInt)
                .filter(el->el>0&&el<=1000)
                .sum();
    }

    private void negativeNumberException(int[] negativeNumbers){
        String negativeNumber="";
        if(negativeNumbers.length>0){

            for(int number :negativeNumbers){
                 negativeNumber+=String.valueOf(number);
                 negativeNumber+=" ";
            }
            NegativeNumberException.throwExceptionIfNegativeExists(negativeNumber);
        }

    }
}
