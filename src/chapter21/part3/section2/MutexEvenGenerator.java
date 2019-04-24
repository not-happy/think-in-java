package chapter21.part3.section2;

import chapter21.part3.section1.EvenChecker;
import chapter21.part3.section1.IntGenerator;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuyong
 * @since 2019-04-23 15:49
 **/
public class MutexEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();

        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }

}
