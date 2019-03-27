package chapter21.part2.section3.practice4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-03-27 22:52
 **/
public class ThreadPoolFibonacciApp {

    public static void main(String[] args) {
        ExecutorService singleExec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleExec.execute(new Fibonacci(i + 1));
        }
        singleExec.shutdown();

        ExecutorService cacheExec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cacheExec.execute(new Fibonacci(i + 1));
        }
        cacheExec.shutdown();
//
        ExecutorService fixedExec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            fixedExec.execute(new Fibonacci(i + 1));
        }
        fixedExec.shutdown();
    }

}
