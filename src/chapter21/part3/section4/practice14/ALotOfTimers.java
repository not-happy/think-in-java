package chapter21.part3.section4.practice14;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author xuyong
 * @since 2019-07-26 16:01
 **/
public class ALotOfTimers {

    public static void main(String[] args) throws InterruptedException {
        int size = 1000;
        for (int j = 0; j < size; j++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("i think so");
                }
            }, 2000);
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("exit");
                System.exit(0);
            }
        }, 10000);

    }

}
