package chapter21.part2.section14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-04-23 11:09
 **/
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }

}
