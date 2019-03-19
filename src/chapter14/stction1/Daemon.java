package chapter14.stction1;

/**
 * @author xuyong
 * @since 2019-03-19 23:03
 **/
public class Daemon extends Thread {

    private static final int SIZE = 10;
    private Thread[] t = new Thread[SIZE];

    public Daemon() {
        setDaemon(true);
        start();
    }

    @Override

    public void run() {
        for (int i = 0; i < SIZE; i++) {
            t[i] = new DaemonSpawn(i);
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.println("t[" + i + "].isDeamon() = " + t[i].isDaemon());
        }
        while (true) {
            yield();
        }
    }

    class DaemonSpawn extends Thread {
        public DaemonSpawn(int i) {
            System.out.println("DaemonSpawn" + i + "started");
            start();
        }

        @Override
        public void run() {
            while (true) {
                yield();
            }
        }
    }

}
