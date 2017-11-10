import java.io.*;
import java.net.*;

public class clienteUDP {
    public static void main(String argv[]) throws Exception{
        BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clienteSocket = new DatagramSocket();
        InetAddress IPAdress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[2014];
        String frase = doUsuario.readLine();
        sendData = frase.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 8010);
        clienteSocket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clienteSocket.receive(receivePacket);
        String fraseModificada = new String(receivePacket.getData());
        System.out.print("DO SERVIDOR: "+ fraseModificada);
        clienteSocket.close();
    }
}
