package chapter21.part2.section2.practice2;

/**
 * @author xuyong
 * @since 2019-03-21 23:46
 **/
public class Fibonacci implements Runnable {

    private static int taskCount = 0;
    private final int id;
    private int n;

    public Fibonacci(int n) {
        this.n = n;
        this.id = taskCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print("#" + id + " " + fi(i) + " ");
//            Thread.yield();
        }
        System.out.println();
    }

    private int fi(int i){
        if(i < 2){
            return 1;
        }
        return fi(i - 1) + fi(i - 2);
    }

}
