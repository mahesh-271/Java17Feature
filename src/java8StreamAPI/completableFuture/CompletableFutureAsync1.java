package java8StreamAPI.completableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAsync1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println ("Thread name is : " + Thread.currentThread ());

        CompletableFuture.supplyAsync ( () -> "Mahesh" )
                .thenApply ( val -> val.toUpperCase () )
                .thenAccept ( System.out::println )
                .join ();

        System.out.println ("Thread name is : " + Thread.currentThread ());

        System.out.println ( "       " );

        CompletableFuture.supplyAsync ( () -> {
                    var result = List.of ( "Mahesh", "Killu" )
                            .stream ()
                            .filter ( val -> val.startsWith ( "M" ) || val.startsWith ( "K" ) )
                            .map ( String::toUpperCase )
                            .toList ();
                    return result;
                } )
                .thenApply ( val -> val + "  : " )
                .thenAccept ( System.out::println )
                .join();

        System.out.println ( "Thread name is : " + Thread.currentThread ());
    }
}
