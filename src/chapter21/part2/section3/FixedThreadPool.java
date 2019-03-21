package chapter21.part2.section3;

import chapter21.part2.section2.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-03-21 23:19
 **/
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();

    }

}
