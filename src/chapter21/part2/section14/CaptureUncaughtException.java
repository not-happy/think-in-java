package chapter21.part2.section14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-04-23 11:16
 **/
public class CaptureUncaughtException {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());

        exec.execute(new ExceptionThread2());
    }

}
