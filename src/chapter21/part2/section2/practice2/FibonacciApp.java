package chapter21.part2.section2.practice2;

/**
 * @author xuyong
 * @since 2019-03-21 23:58
 **/
public class FibonacciApp {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Fibonacci(i + 1)).start();
        }
    }

}
