package chapter21.part2.section4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xuyong
 * @since 2019-03-21 23:36
 **/
public class CallableDemo {

    static class TaskWithResult implements Callable<String> {

        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            return "result of TaskWithResult " + id;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
