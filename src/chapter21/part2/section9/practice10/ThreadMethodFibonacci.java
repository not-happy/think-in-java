package chapter21.part2.section9.practice10;

import java.util.concurrent.*;

/**
 * @author xuyong
 * @since 2019-04-03 09:51
 **/
public class ThreadMethodFibonacci {

    private ExecutorService exec = Executors.newCachedThreadPool();

    class FibonacciCallable implements Callable<Integer> {

        private final int n;

        FibonacciCallable(int n) {
            this.n = n;
        }


        @Override
        public Integer call() throws Exception {
            return fc(n);
        }

        private int fc(int n) {
            if (n < 2) {
                return 1;
            }
            return fc(n - 1) + fc(n - 2);
        }

    }


    public Future<Integer> runTask(int n) {
        return exec.submit(new FibonacciCallable(n));
    }

    public void shutdown() {
        exec.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadMethodFibonacci fibonacci = new ThreadMethodFibonacci();
        Future<Integer> future = fibonacci.runTask(5);
        fibonacci.shutdown();


        System.out.println(future.get());


    }


}
