package chapter21.part2.section8;

/**
 * @author xuyong
 * @since 2019-04-02 13:52
 **/
public class DaemonsDontRunFinally {

    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }

}
