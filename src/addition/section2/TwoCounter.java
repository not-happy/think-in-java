package addition.section2;

import java.awt.*;

/**
 * @author xuyong
 * @since 2019-03-19 23:19
 **/
public class TwoCounter extends Thread {

    private boolean started = false;
    private TextField
            t1 = new TextField(5),
            t2 = new TextField(5);

    private Label l = new Label("count1 == count2");
    private int count1 = 0, count2 = 0;

    public TwoCounter(Container c) {
        Panel p = new Panel();
        p.add(t1);
        p.add(t2);
        p.add(l);
        c.add(p);
    }

    @Override
    public void start() {
        if (!started) {
            started = true;
            super.start();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                t1.setText(Integer.toString(count1++));
                t2.setText(Integer.toString(count2++));
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public void synchTest() {
        Sharing1.incrementAccess();
        if (count1 != count2) {
            l.setText("Unsynched");
        }
    }
}

class Watcher extends Thread {

    private Sharing1 p;

    public Watcher(Sharing1 p) {
        this.p = p;
        start();
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < p.s.length; i++) {
                p.s[i].synchTest();
            }
            try {
                sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }


}
