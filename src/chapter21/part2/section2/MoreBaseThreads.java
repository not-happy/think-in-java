package chapter21.part2.section2;

/**
 * @author xuyong
 * @since 2019-03-20 23:57
 **/
public class MoreBaseThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
