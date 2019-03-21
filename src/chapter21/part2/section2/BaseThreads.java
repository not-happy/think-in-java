package chapter21.part2.section2;

/**
 * @author xuyong
 * @since 2019-03-20 23:54
 **/
public class BaseThreads {

    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }

}
