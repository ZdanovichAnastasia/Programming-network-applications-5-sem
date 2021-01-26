package lab6;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DemoThread extends JFrame{
    //private BufferedImage buffImg1, buffImg2;
    private int topWidth = 350, topHeight = 200, topBankY = 45, topBankX=90,
            bottomWidth = 350,bottomHeight = 0, bottomBankY = 477, bottomBankX=90,
            snowflakeX = 252, snowflakeY = 200,
            width1 = 15, width2 = 13, width3 = 15,
            height1 = 200, height2 = 195, height3 = 180,
            snowflakeX1 = 245, snowflakeY1 = 200, snowflakeX2 = 256, snowflakeY2 = 200,
            snowflakeX3 = 249, snowflakeY3 = 200, snowflakeX4 = 264, snowflakeY4 = 200,
            snowflakeX5 = 268, snowflakeY5 = 200, snowflakeX6 = 260, snowflakeY6 = 200;
    private static Image background;
    private static Image sand;
    private static Image bottom;
    private static Image top;
    JButton bt;
    public DemoThread() {
        setTitle("Demo app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
// Background() -панель, для которой переопределен paintComponent с фоном


        bt = new JButton("Старт");
        setContentPane(new Background()); // панель устанавливается как contentPane в наследнике JFrame
        Container content = getContentPane(); //теперь все элементы интерфейса будут на этой панели.
        bt.setPreferredSize(new Dimension(100,70));
        bt.setBackground(Color.white);
        bt.setForeground(Color.BLACK);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bt.setVisible(true);
                Thread sandMove = new Thread(new SThread());
                sandMove.start();
                Thread sandMove1 = new Thread(new SandThread());
                sandMove1.start();
                //Thread endMove1 = new Thread(new EndThread());
                //endMove1.start();
            }
        }
        );
        content.add(bt);
        content.add(new Sandbank());
    }
    private static class Background extends JPanel{ // отрисовка нового фона
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            try {
                background = ImageIO.read(new File("background0.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(background,0,0,null);
        }
    }

    private class Sandbank extends JPanel{
        public Sandbank() {
            setOpaque(false);
            setPreferredSize(new Dimension(1000, 600));
            try {
                top = ImageIO.read(new File("Vector 1.png"));
                bottom= ImageIO.read(new File("bottom1.png"));
                sand = ImageIO.read(new File("Sand1.png"));
            }
            catch (IOException exc) {};
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.drawImage(top, topBankX, topBankY, topWidth, topHeight, this);
            graphics2D.drawImage(bottom, bottomBankX,bottomBankY, bottomWidth, bottomHeight, this);
            graphics2D.drawImage(sand,snowflakeX ,snowflakeY, width1, height1, this);
            graphics2D.drawImage(sand, snowflakeX1,snowflakeY1, width2, height1, this);
            graphics2D.drawImage(sand, snowflakeX2,snowflakeY2, width3, height2, this);
            graphics2D.drawImage(sand, snowflakeX3,snowflakeY3, width2, height2, this);
            graphics2D.drawImage(sand, snowflakeX4,snowflakeY4, width2, height3, this);
            graphics2D.drawImage(sand, snowflakeX5,snowflakeY5, width2, height3, this);
            graphics2D.drawImage(sand, snowflakeX6,snowflakeY6, width2, height3, this);

        }
    }
    public class SThread implements Runnable{
        @Override
        public void run() {
            while (topHeight > 170) {
                topHeight -= 2;
                topBankY+=2;
                topWidth-=2;
                topBankX+=1;
                bottomHeight+=2;
                bottomBankY-=2;
                repaint();
                try {
                    Thread.sleep(30);
                }
                catch (Exception exc) {};
            }
            while (topHeight > 75) {
                topHeight -= 2;
                topBankY+=2;
                topWidth-=6;
                topBankX+=3;
                bottomHeight+=2;
                bottomBankY-=2;
                repaint();
                try {
                    Thread.sleep(80);
                }
                catch (Exception exc) {};
            }
            while (topHeight > 0) {
                topHeight -= 2;
                topBankY+=2;
                bottomHeight+=1;
                bottomBankY-=1;
                repaint();
                try {
                    Thread.sleep(20);
                }
                catch (Exception exc) {};
            }
        }
    }
    public class SandThread implements Runnable{

        /*protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D)g;
            graphics2D.drawImage(sand,snowflakeX ,snowflakeY, width1, height1, this);
            graphics2D.drawImage(sand, snowflakeX1,snowflakeY1, width2, height1, this);
            graphics2D.drawImage(sand, snowflakeX2,snowflakeY2, width3, height2, this);
            graphics2D.drawImage(sand, snowflakeX3,snowflakeY3, width2, height2, this);
            graphics2D.drawImage(sand, snowflakeX4,snowflakeY4, width2, height3, this);
            graphics2D.drawImage(sand, snowflakeX5,snowflakeY5, width2, height3, this);
            graphics2D.drawImage(sand, snowflakeX6,snowflakeY6, width2, height3, this);
        }*/
        @Override
        public void run() {
            while (topHeight > 10) {
                snowflakeY = ThreadLocalRandom.current().nextInt(topHeight+30, bottomBankY);
                snowflakeY1 = ThreadLocalRandom.current().nextInt(topHeight+30, bottomBankY);
                snowflakeY2 = ThreadLocalRandom.current().nextInt(topHeight+40, bottomBankY);
                snowflakeY3 = ThreadLocalRandom.current().nextInt(topHeight+100, bottomBankY);
                snowflakeY4 = ThreadLocalRandom.current().nextInt(topHeight+100, bottomBankY);
                snowflakeY5 = ThreadLocalRandom.current().nextInt(topHeight+100, bottomBankY);
                snowflakeY6 = ThreadLocalRandom.current().nextInt(topHeight+100, bottomBankY);
                //topHeight -= 20;
                height1-=2;
                height2-=1;
                height3-=1;
                try {
                    Thread.sleep(100);
                }
                catch (Exception exc) {};
            }
            while (topHeight > 0) {
               width1=0;
               width2=0;
               width3=0;
                //topHeight -= 20;
                try {
                    Thread.sleep(20);
                }
                catch (Exception exc) {};
            }
        }
    }
    public class EndThread implements Runnable{
        @Override
        public void run() {
            while (topHeight > 0) {
                snowflakeY = 0;
                snowflakeY1 = 0;
                snowflakeY2 = 0;
                snowflakeY3 = 0;
                snowflakeY4 = 0;
                snowflakeY5 = 0;
                snowflakeY6 = 0;
                //topHeight -= 2;
                try {
                    Thread.sleep(10);
                }
                catch (Exception exc) {};
            }
        }
    }
}
