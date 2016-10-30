package radioactivated.scara;
import radioactivated.scara.serial.SerialComm;

import java.io.IOException;
import java.util.Scanner;
import jssc.SerialPort;
import jssc.SerialPortException;

/**
 * Created by gaow on 10/30/2016.
 */
public class ScaraController {
    static Scanner inScanner = new Scanner(System.in);

    public static void main(String[] args) {
        SerialPort port = new SerialPort("COM5");
        
    }
}
