package chapter21.part3.section2.practice11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuyong
 * @since 2019-04-23 15:05
 **/
public class SynchronizedPractice {

    private int x = 0;
    private int y = 0;

    private void even() {
        while (x == y) {
            ++x;
            ++y;
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        SynchronizedPractice practice = new SynchronizedPractice();
        for (int i = 0; i < 10; i++) {
            exec.execute(new PracticeThread(practice));
        }
        exec.shutdown();
    }

    static class PracticeThread extends Thread {

        private SynchronizedPractice practice;

        public PracticeThread(SynchronizedPractice practice) {
            this.practice = practice;
        }

        @Override
        public void run() {
            practice.even();
        }
    }

}
