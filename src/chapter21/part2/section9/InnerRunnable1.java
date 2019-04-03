package chapter21.part2.section9;

import java.util.concurrent.TimeUnit;

/**
 * @author xuyong
 * @since 2019-04-02 14:23
 **/
public class InnerRunnable1 {

    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        this.inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        Inner(String name){
            t = new Thread(this, name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if(--countDown == 0){
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return t.getName() + ": " + countDown;
        }
    }

}
