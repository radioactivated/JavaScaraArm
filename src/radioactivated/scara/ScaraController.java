package radioactivated.scara;

import radioactivated.scara.serial.SerialComm;

/**
 * Created by gaow on 10/30/2016.
 */
public class ScaraController {

    static SerialComm serial1 = new SerialComm();
    public static void main(String[] args) {
        serial1.initialize();
        System.out.println("Hello world!");
    }
}
