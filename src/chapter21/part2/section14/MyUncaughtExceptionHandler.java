package chapter21.part2.section14;

/**
 * @author xuyong
 * @since 2019-04-23 11:14
 **/
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
