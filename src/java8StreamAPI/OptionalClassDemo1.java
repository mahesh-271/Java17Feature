package java8StreamAPI;

import java.util.List;
import java.util.Optional;

public class OptionalClassDemo1 {

    public static void main(String[] args) {

       var upperCase =  Optional.ofNullable(List.of ("Cena", "John"))
                .map(List::stream)
                .stream()
                .flatMap(s -> s)
                .map(String::toUpperCase)
               .toList ();

        System.out.println (upperCase);

    }
}
