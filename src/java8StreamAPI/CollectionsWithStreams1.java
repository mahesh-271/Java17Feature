package java8StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectionsWithStreams1 {

    public static boolean isAnagrams(String str1, String str2) {

        if (str1.length () != str2.length ()) {
            return false;
        }
        char[] str1Array = str1.toCharArray ();
        char[] str2Array = str2.toCharArray ();
        Arrays.sort ( str1Array );
        Arrays.sort ( str2Array );
        return Arrays.equals ( str1Array, str2Array );
    }
    public static void main(String[] args) {

        //write a program to check strings are anagrams or not

        String str1 = "listen";
        String str2 = "silent";

        //check anagrams or not :

        boolean checkAnagrams = str1.chars ()
                .sorted ()
                .mapToObj ( val -> (char) val )
                .toList ()
                .equals ( str2.chars ()
                        .sorted ()
                        .mapToObj ( va -> (char) va )
                        .toList () );
        System.out.println ( "The Two Strings are  : " + checkAnagrams );

        //  remove duplicates from list
        List<String> listValues = List.of ( "apple", "orange", "banana", "apple", "orange" );

        listValues.stream ()
                .distinct ()
                .toList ();

        //find alll numbers starts with 1

        List<Integer> numbersList = List.of ( 10, 22, 11, 43, 12, 134, 112 );

        List<Integer> filteringNumbers = numbersList.stream ()
                .map ( num -> String.valueOf ( num ) )
                .filter ( val -> val.startsWith ( "1" ) )
                .mapToInt ( val -> Integer.parseInt ( val ) )
                .boxed ()
                .toList ();

        List<Integer> startsWithOne = numbersList.stream ()
                .filter ( val -> String.valueOf ( val ).startsWith ( "1" ) )
                .toList ();

        System.out.println ( startsWithOne );

        System.out.println ( filteringNumbers );

        // join two two streams

        List<Integer> num1 = List.of ( 1, 2, 3, 4, 5 );
        List<Integer> num2 = List.of ( 6, 7, 8, 9, 10 );

        List<Integer> resultedSteam = Stream.concat ( num1.stream (), num2.stream () )
                .toList ();

        //check if numbers are prime or not

        boolean isResult = resultedSteam.stream ()
                .anyMatch ( CollectionsWithStreams1::isPrime );

        System.out.println ( "Prime numbers are : " + isResult );
    }
    //check if list contains prime number or not

    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt ( num ); i++) {

            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
