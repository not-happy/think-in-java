package chapter21.part2.section14;

import java.util.concurrent.ThreadFactory;

/**
 * @author xuyong
 * @since 2019-04-23 11:15
 **/
class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
