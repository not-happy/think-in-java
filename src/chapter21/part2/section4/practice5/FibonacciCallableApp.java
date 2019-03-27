package chapter21.part2.section4.practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xuyong
 * @since 2019-03-27 23:16
 **/
public class FibonacciCallableApp {

    static class FibonacciCallable implements Callable<Integer> {

        private static int taskCount = 0;
        private final int id;
        private final int n;

        FibonacciCallable(int n) {
            this.id = taskCount++;
            this.n = n;
        }

        @Override
        public Integer call() throws Exception {
            return fc(n);
        }

        private int fc(int n) {
            if (n < 2) {
                return 1;
            } else {
                return fc(n - 1) + fc(n - 2);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new FibonacciCallable(i)));
        }

        for (Future<Integer> result : results) {
            try {
                System.out.print(result.get() + " ");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return;
            } finally {
                exec.shutdown();
            }
        }

    }

}
