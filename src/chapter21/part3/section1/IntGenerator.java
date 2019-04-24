package chapter21.part3.section1;

/**
 * @author xuyong
 * @since 2019-04-23 11:59
 **/
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}