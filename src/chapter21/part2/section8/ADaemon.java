package chapter21.part2.section8;

import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-04-02 13:50
 **/
public class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("This should always run?");
        }
    }
}
