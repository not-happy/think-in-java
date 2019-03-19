package chapter14.stction1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xuyong
 * @since 2019-03-19 22:43
 **/
public class Counter4 extends Applet {

    private Button start = new Button("Start");
    private boolean started = false;
    private Ticker[] s;
    private boolean isApplet = true;
    private int size;

    @Override
    public void init() {
        if (isApplet) {
            size = 20;
            s = new Ticker[size];
            for (int i = 0; i < s.length; i++) {
                s[i] = new Ticker(this);
                start.addActionListener(new StartL());
                add(start);
            }
        }
    }

    class StartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!started) {
                started = true;
                for (int i = 0; i < s.length; i++) {
                    s[i].start();
                }
            }
        }
    }

    public static void main(String[] args) {
        Counter4 applet = new Counter4();
        applet.size = (args.length == 0 ? 5 : Integer.parseInt(args[0]));
        Frame aFrame = new Frame("Counter4");
        aFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        aFrame.add(applet, BorderLayout.CENTER);
        applet.setSize(200, applet.size * 50);
        applet.init();
        applet.start();
        aFrame.setVisible(true);
    }

}
