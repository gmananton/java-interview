package basics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

public class Example_03_Optional {

    public static void main(String[] args) {

        System.out.println(
                Optional.of(null)
        );

        System.out.println(
                Optional.of(new Person(null))
                        .map(Person::getName)
        );

        System.out.println(
                Optional.ofNullable(null)
        );

    }


    @AllArgsConstructor
    @Getter
    private static class Person {
        private final String name;
    }
}
