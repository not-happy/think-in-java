package chapter21.part2.section3.practice4;

/**
 * @author xuyong
 * @since 2019-03-27 22:56
 **/
public class Fibonacci implements Runnable {

    private static int taskCount = 0;
    private final int id;
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
        this.id = taskCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print("#" + id + " " + fc(i) + "    ");
            Thread.yield();
        }
        System.out.println();
    }

    private int fc(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fc(n - 1) + fc(n - 2);
        }
    }


}
