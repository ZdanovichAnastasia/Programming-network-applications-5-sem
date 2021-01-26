package server1;
import java.io.*;
import java.io.OutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.*;

public class Main {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявление объекта класса Socket
        ObjectInputStream sois = null;//объявление байтового потока ввода
        ObjectOutputStream soos = null;//объявление байтового потока вывода

        try {
            System.out.println("server starting....");
            serverSocket = new ServerSocket(2525);//создание сокета сервера для //заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
            System.out.println("connection established....");
            //создание потока ввода soos = new
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//создание потока вывода
            String clientMessageRecieved;
            int []num = new int[7];
            for(int i=0; i<7; i++){
                clientMessageRecieved = (String)sois.readObject();
                num[i] = Integer.parseInt(clientMessageRecieved.trim());
                System.out.println(num[i]);
            }
            data []sp=new data[7];
            sp[0]=new data("Петров",1);
            sp[1]=new data("Иванов",2);
            sp[2]=new data("Сидаров",3);
            sp[3]=new data("Николаев",4);
            sp[4]=new data("Кузнецов",5);
            sp[5]=new data("Марков",6);
            sp[6]=new data("Семянин",7);


            int max=0;
            int maxn=-1;
            for(int i =0; i<num.length; i++) {
                if(num[i]>max){
                    maxn=i;
                    max=num[i];
                }
            }
            soos.writeObject(maxn+1);
            soos.writeObject(sp[maxn].getSurname());
            num[maxn]=0;
            max=0;
            maxn=-1;
            for(int i =0; i<num.length; i++) {
                if(num[i]>max){
                    maxn=i;
                    max=num[i];
                }
            }
            soos.writeObject(maxn+1);
            soos.writeObject(sp[maxn].getSurname());
            num[maxn]=0;
            max=0;
            maxn=-1;
            for(int i =0; i<num.length; i++) {
                if(num[i]>max){
                    maxn=i;
                    max=num[i];
                }
            }
            soos.writeObject(maxn+1);
            soos.writeObject(sp[maxn].getSurname());

        }catch(Exception e) { }
        finally {
            try {
                sois.close();//закрытие потока ввода
                soos.close();//закрытие потока вывода
                clientAccepted.close();//закрытие сокета, выделенного для клиента
                serverSocket.close();//закрытие сокета сервера

            } catch(Exception e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }
    }
}

