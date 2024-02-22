package basics;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class Example_04_StreamsAndLambdas {

    public static void main(String[] args) {
        example2();
    }

    private static void example1() {
        List<Integer> values = List.of(1, 1, 2, 3, 4, 4, 5, 6);

        // 1) Найти максимальный элемент

        // 2) Найти уникальный список квадратов четных элементы

        // 3) Посчитать кол-во уникальных элементов
    }

    private static void example2() {
        List<Client> clients = List.of(
                new Client("client1", "Moscow", Set.of(1111111, 2222222)),
                new Client("client2", "Moscow", Set.of(3333333, 4444444)),
                new Client("client3", "St.Petersburg", Set.of(5555555)),
                new Client("client4", "St.Petersburg", Set.of()));

        // 1) Получить список всех счетов всех клиентов

        // 2) Сгруппировать клиентов по признаку наличия счета

        // 3) Сгруппировать клиентов по принадлежности к городу

        // 4) Посчитать кол-во счетов у каждого клиента
    }

    private static void example3() {
        int a = 1;

        // что выведет здесь
        for (int i = 0; i < 10; i++) {
            System.out.println(a++);
        }

        // и здесь?
        // IntStream.range(0, 10).forEach(i -> System.out.println(a++));

    }

    @RequiredArgsConstructor
    @Getter
    @ToString
    private static class Client {

        private final String name;
        private final String city;
        private final Set<Integer> accountNumbers;
    }
}
