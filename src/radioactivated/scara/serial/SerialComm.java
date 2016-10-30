package radioactivated.scara.serial;
// computer running this must have RXTX installed. (http://fizzed.com/oss/rxtx-for-java)
import gnu.io.*; // RXTX library

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * Created by gaow on 10/30/2016.
 */
public class SerialComm {
    SerialPort serPort;

    /**
     * A BufferedReader which will be fed by a InputStreamReader
     * converting the bytes into characters
     * making the displayed results codepage independent
     */
    private DataInputStream input;
    /** The output stream to the port */
    private OutputStream output;

    static final int baudRate = 9600; // must match on Arduino side
    static final int timeOut = 2000;

    private static final String tryPortIds[] = { // put Port IDs to be used here. Assumes only one is connected at a time.
            "COM4",
            "COM5"
    };

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers(); // get an enumeration of all ports on the system

        while(portEnum.hasMoreElements()){
            CommPortIdentifier currPortID = (CommPortIdentifier) portEnum.nextElement(); // grab the next port in the list
            for(String portName : tryPortIds){
                if(currPortID.getName().equals(portName)){
                    portId = currPortID;
                    System.out.println(portName + " found");
                    break;
                } else {
                    System.out.println(portName + " was not found");
                }
            }
        }

        if(portId == null){
            System.out.println("Could not find connected COM port.");
            return;
        }

        // attempt to open the COM port as serPort
        try {
            // actually open the port as a SerialPort
            serPort = (SerialPort) portId.open(this.getClass().getName(),timeOut);

            // set the port's parameters - baudrate, data bits, stop bits, and parity.
            serPort.setSerialPortParams(
                    baudRate,              // baud rate as set before
                    // default Arduino serial parameters.
                    SerialPort.DATABITS_8, // 8 data bits
                    SerialPort.STOPBITS_1, // 1 stop bit
                    SerialPort.PARITY_NONE // no parity
            );

            // for getting input data from serial port.
            // BufferedReader makes input "codepage independent".
            input = new DataInputStream(serPort.getInputStream());
            // for outputting data over the serial port.
            output = serPort.getOutputStream();



        } catch(Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
    }

    public synchronized void close() throws NoSuchPortException {
        if(serPort != null) {
            serPort.removeEventListener();
            serPort.close();
        }
    }

}
