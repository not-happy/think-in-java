package chapter21.part2.section2.practice1;

/**
 * @author xuyong
 * @since 2019-03-21 00:01
 **/
public class Practice1 implements Runnable {

    public Practice1() {
        System.out.println("started");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.print("xyong ");
            Thread.yield();
        }
        System.out.println("ended");
    }
}
