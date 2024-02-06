package concurrency;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Example_02_ParallelStream {

    public static void main(String[] args) {
    }

    // Будет ли данный стрим гарантированно работать параллельно?
    private static void example1() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);
    }


    //Какие потенциальные проблемы тут могут быть?
    private static void example2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .map(n -> new RestTemplate().getForObject("https://external-data-link", CustomDataObject.class))
                .map(data -> {
                    //perform some dataProcessing
                    return data;
                })
                .toList();
    }

    static class CustomDataObject {
        //stub
    }




}
