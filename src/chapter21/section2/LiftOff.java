package chapter21.section2;

/**
 * @author xuyong
 * @since 2019-03-20 23:47
 **/
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    /**
     * id 声明为 final 是因为 id 作为线程标识，不希望声明后再改变了
     */
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "). ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
