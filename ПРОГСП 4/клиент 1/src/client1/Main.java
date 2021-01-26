package client1;
import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание потока вывода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание потока ввода
            for(int i=1; i<=7; i++){
                System.out.println("Введите результаты "+i+"-го участника: ");
                String clientMessage = stdin.readLine();
                coos.writeObject(clientMessage);
            }
            System.out.println("1 место: "+cois.readObject()+" участник "+cois.readObject());
            System.out.println("2 место: "+cois.readObject()+" участник "+cois.readObject());
            System.out.println("3 место: "+cois.readObject()+" участник "+cois.readObject());


            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        }catch(Exception e) {
            e.printStackTrace();//выполнение метода исключения е
        }
    }
}
