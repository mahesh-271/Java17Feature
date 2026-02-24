package java8StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysWithStream {

    public static void main(String[] args) {

        int arr[] = {1, 3, 4, 66, 43, 23, 5, 233, 6543, 54};

        //Basic Stream Intermediate Opearations :

        IntSummaryStatistics summaryStatistics =
                Arrays.stream ( arr )
                        .boxed ()
                        .mapToInt ( val -> val )
                        .summaryStatistics ();

        System.out.println ( "Avearage is: " + summaryStatistics.getAverage () );
        System.out.println ( "Total sum  is: " + summaryStatistics.getSum () );
        System.out.println ( "maximum value  is: " + summaryStatistics.getMax () );
        System.out.println ( "Minimum value  is: " + summaryStatistics.getMin () );
        System.out.println ( "Total count   is: " + summaryStatistics.getCount () );

        summaryStatistics.accept ( 439849 );

      //  System.out.println ( "Total count after accepting the values is  : " + summaryStatistics.getCount () );

        String[]namesArray = {"mahesh","ramesh"};

        Arrays.stream(namesArray)
                .forEach ( input -> {
                   Character nonRepeatingCharacter =  input.chars ()
                            .mapToObj ( val -> (char)val )
                            .collect( Collectors.groupingBy ( Function.identity(), LinkedHashMap::new , Collectors.counting ()))
                            .entrySet ()
                            .stream ()
                            .filter(val -> val.getValue ()==1)
                            .map( Map.Entry::getKey)
                            .findFirst ()
                            .orElse ( null );

                 //   System.out.println ("First non repeating character of" + input + " is " + nonRepeatingCharacter);
                } );

        //First repeated character in a given array

        String [] arrayNames = {"mahesh", "abcc","ghighgjeif"};

        Set<Character> set = new HashSet<> ();

        Arrays.stream (arrayNames)
                .forEach ( val -> {
                    Character firstRepeatingCharacter = val.chars ()
                            .mapToObj (ip -> (char) ip )
                            .filter ( val1 -> !set.add ( val1 ))
                            .findFirst ()
                            .orElse ( null );

                    System.out.println ("first non repeating character is : " + firstRepeatingCharacter);
                });
    }
}
