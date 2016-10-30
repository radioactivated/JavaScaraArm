package radioactivated.scara.serial.test;

/**
 * Created by gaow on 10/30/2016.
 */
import jssc.SerialPort; import jssc.SerialPortException;

/** * * @author scream3r */ public class JSCCTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SerialPort serialPort = new SerialPort("COM6");
        try {
            System.out.println("Port opened: " + serialPort.openPort());
            System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
            System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));
            //System.out.println("Port closed: " + serialPort.closePort());
            for(int i = 0; i < 256; i++) {
                System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));
                System.out.println(serialPort.readString(7));
            }
        }
        catch (SerialPortException ex){
            System.out.println(ex);
        }
    }
}
