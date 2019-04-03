package chapter21.part2.section8;

import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-04-02 13:47
 **/
public class Daemons {

    public static void main(String[] args) throws InterruptedException {

        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ". ");
        TimeUnit.MILLISECONDS.sleep(50);
    }

}
