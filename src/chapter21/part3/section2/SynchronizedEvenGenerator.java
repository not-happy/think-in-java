package chapter21.part3.section2;

import chapter21.part3.section1.EvenChecker;
import chapter21.part3.section1.IntGenerator;

/**
 * @author xuyong
 * @since 2019-04-23 14:14
 **/
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
