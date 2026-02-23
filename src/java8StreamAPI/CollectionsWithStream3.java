package java8StreamAPI;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsWithStream3 {

    public static void main(String[] args) {

        //find first repeatative character in a given string

        String name = "janagundlamahesh";

        //o/p : a

        Set<Character> set = new HashSet<> ();

        Character firstRepeatativeCharacter = name.chars ()
                .mapToObj ( val -> (char) val )
                .filter ( val -> !set.add ( val ) )
                .findFirst ()
                .orElse ( null );

        List<Integer> integers = List.of ( 12, 332, 11, 1122, 22, 123, 3, 321, 133212, 3, 3, 32, 2, 23, 3, 32233, 3, 44, 22, 2, 2, 3, 3, 223 );


        List<Integer> startsWith3 = integers.stream ()
                .filter ( val -> String.valueOf ( val ).startsWith ( "3" ) )
                .toList ();

        System.out.println ( startsWith3 );

        List<Integer> evenNumbers = IntStream.rangeClosed ( 0, 12 )
                .boxed ()
                .filter ( val -> val % 2 == 0 )
                .toList ();

        System.out.println ( evenNumbers );

        List<Integer> oddNumbers = IntStream.rangeClosed ( 2, 14 )
                .boxed ()
                .filter ( val -> val % 2 == 1 )
                .toList ();

        System.out.println ( "Odd Numbers are : " + oddNumbers );

        //is Anagram check

        String string1 = "abc";
        String string2 = "cab";

        boolean isAnagram = string1.chars ()
                .sorted ()
                .mapToObj ( val -> (char) val )
                .toList ()
                .equals ( string2.chars ()
                        .sorted ()
                        .mapToObj ( val -> (char) val )
                        .toList () );

        System.out.println ( "Is Anagram are : " + isAnagram );


        //Missing elements

        List<Integer> inputs = List.of ( 1, 3, 4, 5 );

        List<Integer> missingElements = IntStream.rangeClosed ( 1, inputs.size () )
                .filter ( val -> !inputs.contains ( val ) )
                .boxed ()
                .toList ();

        //System.out.println (missingElements);

        String string = "I am Mahesh";

        String count = Arrays.stream ( string.split ( " " ) )
                .map ( val -> new StringBuilder ( val ).reverse ().toString () )
                .collect ( Collectors.joining ( " , " ) );

        System.out.println ( count );
    }
}
