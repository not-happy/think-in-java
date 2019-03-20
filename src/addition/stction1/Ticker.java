package addition.stction1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author xuyong
 * @since 2019-03-19 22:37
 **/
public class Ticker extends Thread {

    private Button b = new Button("Toggle");
    private TextField t = new TextField(10);
    private int count = 0;
    private boolean runFlag = true;


    class ToggleL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            runFlag = !runFlag;
        }
    }

    public Ticker(Container c) {
        b.addActionListener(new ToggleL());
        Panel p = new Panel();
        p.add(t);
        p.add(b);
        c.add(p);
    }

    @Override
    public void run() {
        while (true) {
            if (runFlag) {
                t.setText(Integer.toString(count++));
            }
//            try {
//                sleep(100);
//            } catch (InterruptedException e) {
//            }
        }
    }
}
