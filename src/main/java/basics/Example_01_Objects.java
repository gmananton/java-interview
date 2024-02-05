package basics;

public class Example_01_Objects {

    public static void main(String[] args) {
        Integer first = 1;
        Integer second = 1;
        System.out.println(first == second);
        System.out.println(first.equals(second));

        first = 1000;
        second = 1000;
        System.out.println(first == second);
        System.out.println(first.equals(second));

        String sFirst = "s";
        String sSecond = "s";
        System.out.println(sFirst.equals(sSecond));
        System.out.println(sFirst == sSecond);
    }

}
