package chapter21.part2.section12;

import java.io.IOException;

/**
 * @author xuyong
 * @since 2019-04-23 10:39
 **/
public class RespponsiveUI extends Thread {

    static class UnresponsiveUI {

        private volatile double d = 1;

        public UnresponsiveUI() throws IOException {
            while (d > 0) {
                d = d + (Math.PI + Math.E) / d;
            }
            System.in.read();
        }
    }

    private static volatile double d = 1;

    public RespponsiveUI() {
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
//        new UnresponsiveUI();
        new RespponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
