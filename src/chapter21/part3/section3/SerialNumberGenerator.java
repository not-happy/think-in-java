package chapter21.part3.section3;

/**
 * @author xuyong
 * @since 2019-07-02 22:17
 **/
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumber() {
        return serialNumber++;
    }


}