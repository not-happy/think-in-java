package chapter21.part2.section5;

import chapter21.part2.section2.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-03-27 23:26
 **/
public class SleepingTask extends LiftOff {

    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }

}
