package chapter21.part2.section8;

import java.util.concurrent.ThreadFactory;

/**
 * @author xuyong
 * @since 2019-04-02 11:59
 **/
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
