package chapter21.part2.section2.practice1;

/**
 * @author xuyong
 * @since 2019-03-21 00:03
 **/
public class PracticeApp {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new Practice1()).start();
        }

    }
}
