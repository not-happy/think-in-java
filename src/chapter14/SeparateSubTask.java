package chapter14;

/**
 * @author xuyong
 * @since 2019-03-18 22:55
 **/
public class SeparateSubTask extends Thread {

    private int count = 0;
    private Counter2 c2;
    private boolean runFlag = true;

    public SeparateSubTask(Counter2 c2){
        this.c2 = c2;
        start();
    }

    public void invertFlag(){
        runFlag = !runFlag;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (runFlag) {
                c2.t.setText(Integer.toString(count++));
            }
        }
    }
}
