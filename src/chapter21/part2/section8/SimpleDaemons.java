package chapter21.part2.section8;

import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-04-02 11:52
 **/
public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All deamon started");
        TimeUnit.MILLISECONDS.sleep(175);
    }

}
