package GreenHouseSimilator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PLCCommunication.ICommands;
import PLCCommunication.IMessage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nam
 */
@SuppressWarnings("resource")
public class GreenHouseAutoSERVER implements IGreenHouse, IGreenHouseMessage, ICommands,IMessage, Runnable {

    TemperaturInside tempInside;
    Light light;
    Moisture moist;
    WaterPump waterPump;
    TemperaturOutside tempOutside;
    private Calendar timestamp;
    private static int serialCounter = 0;
    private int greenHouseID;

    public GreenHouseAutoSERVER(int id) {
        this.greenHouseID = id;
        tempInside = new TemperaturInside();
        light = new Light();
        moist = new Moisture();
        waterPump = new WaterPump();
        tempOutside = new TemperaturOutside();

        System.out.println(toString());

    }

    public int getGreenHouseID() {
        return greenHouseID;
    }

    @Override
    public String toString() {
        return "GreenHouseAutoSERVER{" + "tempInside=" + tempInside + ", light=" + light + ", moist=" + moist + ", waterPump=" + waterPump + ", tempOutside=" + tempOutside + ", timestamp=" + timestamp + ", greenHouseID=" + greenHouseID + '}';
    }
    
    

   

    @SuppressWarnings("empty-statement")
    public void makeConnection() throws IOException {
        DatagramSocket socket = new DatagramSocket(UDPSPCKET_Config.PORT);
        byte[] buffer = new byte[32768]; // 32K should be enough for anyone...
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // Create packet ready for receiving incoming UDP datagrams
        System.out.println("Connection true");

        int packetCount = 0;

        while (true) {

            System.out.println("Server running on port " + UDPSPCKET_Config.PORT + ", waiting to receive packet #" + packetCount);
            socket.receive(packet);
            packetCount++;
            System.out.println("packet received:  " + packetCount);
            byte[] data = Arrays.copyOf(packet.getData(), packet.getLength());
            System.out.println("adresse " + packet.getSocketAddress());
            String inData = Arrays.toString(data);
            ;
            System.out.println(inData + "indata");
            int commands = data[0];

            int setData = data[data.length - 1];

            switch (commands) {

                case 0:
                    System.out.println("case 0 is empty");
                    break;
                case 1:

                    tempInside.setTemp(setData);
                    System.out.println(tempInside.toString() + "GREENHOUSEAUTOSERVER new inside temp ");
                       serialCounter++;
                    break;

                case 2:

                    moist.setMoisture(setData);
                    System.out.println(moist.toString());
                     serialCounter++;
                    break;
                case 3:
                    light.setColor(Light.COLOR1);
                    light.setLevel(setData);
                    System.out.println(light.toString());
                     serialCounter++;
                    break;
                case 4:
                    light.setColor(Light.COLOR2);
                    light.setLevel(setData);
                    System.out.println(light.toString());
                     serialCounter++;
                    break;

                case 6:
                    waterPump.addWaterLevel(setData);
                    System.out.println(waterPump.toString());
                     serialCounter++;
                    break;

                case 9:

                    System.out.println("case 9");
                    answerFromPlcToClient(ICommands.READ_GREENHOUSE_TEMP_ACK,(byte) tempInside.getTemp(), packet);
                    serialCounter++;

                    break;

                case 10:
                    System.out.println("case 10");
                    //---------------------------------Sending
//                    DatagramSocket sender = new DatagramSocket();
//                   // byte[] out = new byte[]{(byte) packetCount}; // will overflow at 128...
//
//                    byte outDoorTemp = (byte) tempOutside.getTemp();
//                    byte[] outPacketTest = new byte[]{ICommands.READ_OUTDOOR_TEMP_ACK, 1, 0, 1, IMessage.YEAR,IMessage.MONTH,IMessage.DAY, IMessage.HOUR,IMessage.MINUTE, IMessage.SECOND, outDoorTemp};
//
//                    DatagramPacket outPacket = new DatagramPacket(outPacketTest, outPacketTest.length);
//                    outPacket.setAddress(packet.getAddress());
//                    System.out.println("\n Adresse : " + packet.getAddress() + "port " + packet.getPort() + " socket:  " + packet.getSocketAddress());
//                    outPacket.setPort(packet.getPort());
//                    sender.send(outPacket);
//                    System.out.println("outTemp: " + tempOutside.getTemp());
                    
                    answerFromPlcToClient(ICommands.READ_OUTDOOR_TEMP_ACK,(byte) tempOutside.getTemp(), packet);
                      serialCounter++;
                    break;
                    
                case 17:
                    System.out.println("case 17");
                    
                    answerFromPlcToClient(ICommands.READ_WATER_LEVEL_ACK,(byte) waterPump.getWaterLevel(), packet);
                      serialCounter++;
                      break;
                    
                  
               
            }

        }

    }
    
    public void answerFromPlcToClient(byte command, byte data, DatagramPacket packet) throws IOException
    {
        try {
            DatagramSocket sender = new DatagramSocket();
            
                   // byte outDoorTemp = (byte) tempOutside.getTemp();
                    byte[] outPacketTest = new byte[]{command, 1,(byte) serialCounter, 1,IMessage.YEAR,IMessage.MONTH,IMessage.DAY, IMessage.HOUR,IMessage.MINUTE, IMessage.SECOND, data};
                    System.out.println(serialCounter +" serial nr  GREENHOUSE line 146");
              
                    DatagramPacket outPacket = new DatagramPacket(outPacketTest, outPacketTest.length);
                    outPacket.setAddress(packet.getAddress());
                    System.out.println("\n Adresse : " + packet.getAddress() + "port " + packet.getPort() + " socket:  " + packet.getSocketAddress());
                    outPacket.setPort(packet.getPort());
                    sender.send(outPacket);
                    sender.close();
                    
                    
                    //System.out.println("outTemp: " + tempOutside.getTemp());
            
            
            
            
        } catch (SocketException ex) {
            Logger.getLogger(GreenHouseAutoSERVER.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
    }

    @Override
    public void run() {

        try {

            makeConnection();

        } catch (IOException ex) {
            Logger.getLogger(GreenHouseAutoSERVER.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
