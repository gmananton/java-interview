package concurrency;

public class Example_01_Sum {

    private int value = 0;


    public void doTheWorkInParallel() throws InterruptedException {
        int repeatTime = 1000;
        int numberOfThreads = 100;
        Runnable runnable = () -> {
            for (int i = 0; i < repeatTime; i++) {
                value++;
            }
        };

        Thread workers[] = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            workers[i] = new Thread(runnable, String.valueOf(i));
            workers[i].start();
        }
        for (int j = 0; j < numberOfThreads; j++) {
            workers[j].join(); //todo add catch exception
        }

        System.out.printf("value = %d expected = %d", value, repeatTime * numberOfThreads);
        assert value == repeatTime * numberOfThreads;
    }

}
