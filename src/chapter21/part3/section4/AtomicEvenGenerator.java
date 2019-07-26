package chapter21.part3.section4;

import chapter21.part3.section1.EvenChecker;
import chapter21.part3.section1.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyong
 * @since 2019-07-26 15:56
 **/
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger i = new AtomicInteger(0);

    @Override
    public int next() {
        return i.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }

}
