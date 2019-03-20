package addition.stction1;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xuyong
 * @since 2019-03-18 22:27
 **/
public class Counter2 extends Applet {

    private Button
            onOff = new Button("Toggle"),
            start = new Button("Start");

    TextField t = new TextField(10);
    private SeparateSubTask sp = null;

    @Override
    public void init() {
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }

    public static void main(String[] args) {
        Counter2 applet = new Counter2();
        Frame aFrame = new Frame("Counter2");

        aFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        aFrame.add(applet, BorderLayout.CENTER);
        aFrame.setSize(300, 200);
        applet.init();
        applet.start();
        aFrame.setVisible(true);

    }

    class StartL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (sp == null) {
                sp = new SeparateSubTask(Counter2.this);
            }
        }
    }

    class OnOffL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (sp != null) {
                sp.invertFlag();
            }
        }
    }

}
