package server2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {
    public static double determinate(double x, double y,double z){
        double n=0;
        n=(Math.sqrt(8+z+Math.pow(Math.abs(x+y),2)))/(x*x+y*y+z*z)-Math.exp(Math.abs(x-y))*(Math.pow(Math.tan(z),2)+Math.pow(Math.abs(z),1/5));
        System.out.println("Результат:"+n);

        return n;
    }

    public static void toFile(double x, double y,double z,double n)   {
        try {
            File file = new File("file.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file,true);

            fileWriter.append("x:" + x + " y:" + y + " z:" + z + " Ответ:" + n + "\n");
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Данные записаны в файл:"+file.getName());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Сервер запущен, ожидание клиента...");
        String str="";
        double x,y,z,n;

        DatagramSocket socket=new DatagramSocket(8189);
        byte[]buf = new byte[256];

        while (true){
            DatagramPacket recvPacket=new DatagramPacket(buf,buf.length);
            socket.receive(recvPacket);
            String received = new String(recvPacket.getData(), 0, recvPacket.getLength());
            System.out.println("Пришло:"+received);


            String strs[]=received.split(" ");

            InetAddress address = recvPacket.getAddress();
            int port = recvPacket.getPort();

            x=Double.parseDouble(strs[0]);
            y=Double.parseDouble(strs[1]);
            z=Double.parseDouble(strs[2]);


            buf=(""+(n=determinate(x,y,z))).getBytes();

            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, address, port);
            socket.send(sendPacket);
            toFile(x,y,z,n);
        }
    }
}
