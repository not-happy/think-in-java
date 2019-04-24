package chapter21.part3.section1;

/**
 * @author xuyong
 * @since 2019-04-23 13:44
 **/
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
