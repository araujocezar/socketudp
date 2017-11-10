import java.io.*;
import java.net.*;

public class servidorUDP {
    public static void main(String argv[]) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(8010);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String frase = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int porta = receivePacket.getPort();
            String fraseModificada = frase.toUpperCase();
            sendData = fraseModificada.getBytes();
            DatagramPacket sendPackeet = new DatagramPacket(sendData, sendData.length, IPAddress, porta);
            serverSocket.send(sendPackeet);
        }
    }    
}
