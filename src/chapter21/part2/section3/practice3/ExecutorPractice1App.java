package chapter21.part2.section3.practice3;

import chapter21.part2.section2.practice1.Practice1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-03-21 23:28
 **/
public class ExecutorPractice1App {

    public static void main(String[] args) {
        ExecutorService cachedExec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            cachedExec.execute(new Practice1());
        }
        cachedExec.shutdown();

        System.out.println("------------------------------------------");

        ExecutorService fixedExec = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            fixedExec.execute(new Practice1());
        }
        fixedExec.shutdown();

        System.out.println("------------------------------------------");
//        ExecutorService singleExec = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 5; i++) {
//            singleExec.execute(new Practice1());
//        }
//        singleExec.shutdown();

        System.out.println("------------------------------------------");

    }

}
