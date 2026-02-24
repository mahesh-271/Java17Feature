package java8StreamAPI;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams4WithInBuildMethods {

    public static void main(String[] args) {

        var evenNumbers = IntStream.of ( 12,43,13,11,333,111,3,333,33,4,321,22,3344 )
                .filter ( val -> val %2==0 )
                .boxed ()
                .toList ();

        var oddNumbers = IntStream.of ( 22,44,22,33,43,235,543,345,567,77,8,7,677 )
                .filter ( val -> val %2==1 )
                .boxed ()
                .toList ();

        var totalCount = IntStream.of ( 1,4,2,3,21,2,3 )
                .count ();

        int skippedNoOfElements  = 3;
        var skipNNumberOfElements = IntStream.of ( 1,3,2,1,3,2,1,44,345,55,543,554 )
                .skip ( skippedNoOfElements )
                .boxed ()
                .toList ();

        //for looping purpose

        var printAllElementsFrom1To10 = IntStream.rangeClosed ( 1,10 )
                .boxed ()
                .toList ();

        Double avearage = DoubleStream.of ( 10.0, 10.0 )
                .average ().orElse ( 0.0 );

        //summary statistics
        DoubleSummaryStatistics values = Stream.of(12.32, 123.43, 22.0, 34.0, 65.43, 456.66)
                .mapToDouble(ip -> ip)
                .summaryStatistics();

//        System.out.println ("Total Avearage is : " + values.getAverage ());
//        System.out.println ("Total count is : " + values.getCount ());
//        System.out.println ("Total sum is : " + values.getSum ());







    }
}
