package basics;

import com.sun.tools.javac.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.function.Supplier;

public class Example_05_Exceptions {

    public static void main(String[] args) throws Exception{
    }

    private static void example1() {
        // Что выведет?
        Supplier<Integer> intSupplier = () -> {
            try {
                return 1;
            } catch (Exception ignored) {
                return 2;
            } finally {
                return 3;
            }
        };

        intSupplier.get();

        Supplier<Integer> intSupplierWithException = () -> {
            try {
                throw new RuntimeException();
            } catch (Exception ignored) {
                return 2;
            } finally {
                return 3;
            }
        };

        intSupplierWithException.get();
    }

    private static void example2() throws URISyntaxException, FileNotFoundException  {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(Main.class.getClassLoader().getResource("test.txt").toURI()));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
                throw new RuntimeException("Something happened on reading");
            }
        } finally {
            if (scanner != null) {
                scanner.close();
                throw new RuntimeException("Something happened on closing");
            }
        }
    }


}
