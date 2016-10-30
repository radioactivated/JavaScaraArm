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
    static final byte readyBytes[] = {1,1,1,1,1,1,1,1};
    public static void main(String[] args) {
        SerialPort port = new SerialPort("COM6");
        try{
            port.openPort();
            port.setParams(9600,SerialPort.BAUDRATE_9600,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE,true,false); // must set DTR and RTS as appropriate.

            while(!port.readString(6).equals("Ready!")) {
                System.out.println(port.readString(6));
                System.out.println("a");
                //listen for "ready bytes" from
                //System.out.println("listening");
            }
            System.out.println("Ready");
        }catch(Exception e) {
            System.out.println("asdfa");
            e.printStackTrace();
        }

        while(true) {
            try {

                //System.out.println(port.readBytes());
                System.out.print("Enter a number:");
                String in = inScanner.next();
                System.out.println("sys:"+in);
                port.writeBytes(in.getBytes());
                System.out.println(port.readString());
            } catch (Exception e) {

            }
        }

    }
}
