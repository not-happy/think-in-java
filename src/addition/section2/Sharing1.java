package addition.section2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xuyong
 * @since 2019-03-19 23:23
 **/
public class Sharing1 extends Applet {

    TwoCounter[] s;
    private static int accessCount = 0;

    private static TextField aCount = new TextField("0", 10);

    public static void incrementAccess() {
        accessCount++;
        aCount.setText(Integer.toString(accessCount));
    }

    private Button
            start = new Button("Start"),
            observer = new Button("Observe");

    private boolean isApplet = true;
    private int numCounters = 0;
    private int numObservers = 0;

    @Override
    public void init() {
        if (isApplet) {
            numCounters = 100;
            numObservers = 1;
        }
        s = new TwoCounter[numCounters];
        for (int i = 0; i < s.length; i++) {
            s[i] = new TwoCounter(this);
        }
        Panel p = new Panel();
        start.addActionListener(new StartL());
        p.add(start);
        observer.addActionListener(new ObserverL());
        p.add(observer);
        p.add(new Label("Access Count"));
        p.add(aCount);
        add(p);
    }

    class StartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < s.length; i++) {
                s[i].start();
            }
        }
    }

    class ObserverL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < numObservers; i++) {
                new Watcher(Sharing1.this);
            }
        }
    }

    public static void main(String[] args) {
        Sharing1 applet = new Sharing1();
//        applet.isApplet = false;
        applet.numCounters = (args.length == 0 ? 5 : Integer.parseInt(args[0]));
        applet.numObservers = (args.length < 2 ? 5 : Integer.parseInt(args[1]));

        Frame aFrame = new Frame("Sharing1");
        aFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        aFrame.add(applet, BorderLayout.CENTER);
        aFrame.setSize(350, applet.numCounters * 100);
        applet.init();
        applet.start();
        aFrame.setVisible(true);
    }


}
