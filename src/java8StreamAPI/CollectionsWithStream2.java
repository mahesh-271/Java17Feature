package java8StreamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsWithStream2 {

    public static void main(String[] args) {

        //find out strings with starts with number

        List<String> stringList = List.of ( "1Hi", "2Hellow", "Good morning" );

        List<String> resultedList = stringList.stream ()
                .filter ( val -> !val.isEmpty () && Character.isDigit ( val.charAt ( 0 ) ) )
                .toList ();

        System.out.println ( "Resulted List : " + resultedList );

        //pallindrom or not


        String str = "madam";

        boolean isPallindrome = IntStream.rangeClosed ( 0, str.length () / 2 )
                .allMatch ( i -> str.charAt ( i ) == str.charAt (
                        str.length () - 1 - i )
                );

        System.out.println ( "is Pallindrome : " + isPallindrome );

        //nth smallest number in  a given arrray

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 3;

        int thirdSmallestNumber = Arrays.stream ( array )
                .boxed ()
                .sorted ()
                .skip ( n - 1 )
                .findFirst ()
                .orElse ( 0 );
        System.out.println ( "Third Smallest Number : " + thirdSmallestNumber );


        //nth highest number

        int n1 = 3;

        int thirdHighestNumber = Arrays.stream ( array )
                .boxed ()
                .distinct ()
                .sorted ( Comparator.reverseOrder () )
                .skip ( n1 - 1 )
                .findFirst ()
                .orElseThrow ( () -> {
                    return new RuntimeException ( "Number is not found" );
                } );

        System.out.println ( "Third highest number is : " + thirdHighestNumber );

        //last element in the given array :

        int lastElement = Arrays.stream ( array )
                .skip ( array.length - 1 )
                .findFirst ()
                .orElse ( 0 );

        System.out.println ( "Last element in the given array : " + lastElement );

        //remove duplicate elements in a given string
        String string = "mahesh";

        String withoutDuplicateElements = string.chars ()
                .mapToObj ( str1 -> (char) str1 )
                .distinct ()
                .map ( String::valueOf )
                .collect ( Collectors.joining ( "" ) );

        System.out.println (withoutDuplicateElements);


        List<String> stringList1 = List.of ( "Apple", "Banana", "Orange", "Orange" );

        Map<String, Long> frequency = stringList1.stream ()
                .collect ( Collectors.groupingBy ( Function.identity (), Collectors.counting () ) );

        frequency.forEach ( (key, value) -> System.out.println ( key + " : " + value ) );
    }
}

