package chapter21.part2.section14;

/**
 * @author xuyong
 * @since 2019-04-23 11:12
 **/
class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
