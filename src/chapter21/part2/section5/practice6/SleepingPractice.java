package chapter21.part2.section5.practice6;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-03-27 23:34
 **/
public class SleepingPractice {

    static class SleepingRandom implements Runnable {

        @Override
        public void run() {
            int sleep = new Random().nextInt(10) + 1;
            try {
                TimeUnit.SECONDS.sleep(sleep);
                System.out.print(sleep + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingRandom());
        }
        exec.shutdown();
    }


}
