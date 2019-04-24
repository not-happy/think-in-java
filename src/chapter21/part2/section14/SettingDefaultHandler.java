package chapter21.part2.section14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-04-23 11:52
 **/
public class SettingDefaultHandler {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
    }

}
