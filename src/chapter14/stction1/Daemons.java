package chapter14.stction1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author xuyong
 * @since 2019-03-19 23:06
 **/
public class Daemons {

    public static void main(String[] args) throws InterruptedException {
        Thread d = new Daemon();
        System.out.println("d.isDaemon() = " + d.isDaemon());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Waiting for CR");
//        try {
//            stdin.readLine();
//        } catch (IOException e) {
//        }

        Thread.sleep(-2);
    }

}
