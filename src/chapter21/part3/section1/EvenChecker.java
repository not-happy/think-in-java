package chapter21.part3.section1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-04-23 13:37
 **/
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int id) {
        generator = g;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }

}
