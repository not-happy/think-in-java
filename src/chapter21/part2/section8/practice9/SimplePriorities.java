package chapter21.part2.section8.practice9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author xuyong
 * @since 2019-04-02 14:02
 **/
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 100000000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new PrioritiesThreadFactory(Thread.MIN_PRIORITY));
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities());
        }
        exec.shutdown();

        ExecutorService exec1 = Executors.newCachedThreadPool(new PrioritiesThreadFactory(Thread.MAX_PRIORITY));
        for (int i = 0; i < 5; i++) {
            exec1.execute(new SimplePriorities());
        }
        exec1.shutdown();
    }

    static class PrioritiesThreadFactory implements ThreadFactory {

        private final int priority;

        public PrioritiesThreadFactory(int priority) {
            this.priority = priority;
        }

        @Override

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(priority);
            return t;
        }
    }


}
