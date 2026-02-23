package java8StreamAPI;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class ArraysWithStream {

    public static void main(String[] args) {

        int arr[] = {1, 3, 4, 66, 43, 23, 5, 233, 6543, 54};

        //Basic Stream Intermediate Opearations :

        // summary statistics provides methods that we can use for our basic opearations
        //In this class using only for IntSummaryStatistics , and same way use it for Long , Double , ......

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

        System.out.println ( "Total count after accepting the values is  : " + summaryStatistics.getCount () );
    }
}
