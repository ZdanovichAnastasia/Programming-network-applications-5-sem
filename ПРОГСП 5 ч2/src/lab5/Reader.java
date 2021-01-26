package lab5;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader extends JFrame {
    String text1;
    int k = 0, fl = 0, ch = 1;
    Object boxA, boxB, boxC;
    File file = new File("D://GUI.txt");
    static JLabel l1, l2, l3, l4, l5, fl1, fl2, fl3, fl4, fl5, fl6;
    JComboBox box_1, box_2, box_3;
    JRadioButton flag1, flag2;
    JCheckBox flag3;
    ButtonGroup bg;
    static JButton b, del;
    static JTextField text;
    static String[] box1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    static String[] box2 = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    static String[] box3 = {"APPLE", "HUAWEI", "SAMSUNG", "XIAOMI"};

    public Reader(String str) {
        super(str);
        setSize(600, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b = new JButton("Внесение в базу");
        del = new JButton("Очистить");
        text = new JTextField(9);
        l1 = new JLabel("Введите ваше имя");
        l2 = new JLabel("Ваш пол");
        l3 = new JLabel("Когда вы посещали выставку");
        l4 = new JLabel("Выберите бренд, который вам больше понравился");
        l5 = new JLabel("Посоветуете ли вы посетить выставку своим знакомым");

        fl1 = new JLabel("Поле не должно быть пустым");
        fl6 = new JLabel("Поле должно содержать только буквы");
        fl2 = new JLabel("Выберите пол");
        fl3 = new JLabel("Выберите день");
        fl4 = new JLabel("Выберите месяц");
        fl5 = new JLabel("Выберите бренд");


        box_1 = new JComboBox(box1);
        box_2 = new JComboBox<Object>(box2);
        box_3 = new JComboBox(box3);
        flag1 = new JRadioButton("Муж");
        flag2 = new JRadioButton("Жен");
        flag3 = new JCheckBox("Да");
        bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);
        setLayout(null);
        l1.setSize(200, 25);
        l1.setLocation(30, 20);
        l2.setSize(200, 25);
        l2.setLocation(30, 70);
        l3.setSize(200, 25);
        l3.setLocation(30, 120);
        l4.setSize(310, 25);
        l4.setLocation(30, 170);
        l5.setSize(330, 25);
        l5.setLocation(30, 220);

        fl1.setSize(320, 15);
        fl1.setLocation(250, 45);
        fl1.setForeground(Color.red);
        fl1.setVisible(false);
        fl6.setSize(320, 25);
        fl6.setLocation(250, 45);
        fl6.setForeground(Color.red);
        fl6.setVisible(false);
        fl2.setSize(200, 25);
        fl2.setLocation(250, 95);
        fl2.setForeground(Color.red);
        fl2.setVisible(false);
        fl3.setSize(100, 25);
        fl3.setLocation(250, 145);
        fl3.setForeground(Color.red);
        fl3.setVisible(false);
        fl4.setSize(200, 25);
        fl4.setLocation(350, 145);
        fl4.setForeground(Color.red);
        fl4.setVisible(false);
        fl5.setSize(200, 25);
        fl5.setLocation(410, 195);
        fl5.setForeground(Color.red);
        fl5.setVisible(false);

        b.setSize(200, 30);
        b.setLocation(150, 290);
        del.setSize(100, 30);
        del.setLocation(10, 290);

        text.setSize(320, 25);
        text.setLocation(250, 20);
        flag1.setSize(80, 25);
        flag1.setLocation(250, 70);
        flag1.setSelected(true);
        flag2.setSize(80, 25);
        flag2.setLocation(350, 70);
        box_1.setSize(40, 25);
        box_1.setLocation(250, 120);
        box_2.setSize(100, 25);
        box_2.setLocation(300, 120);
        box_3.setSize(130, 25);
        box_3.setLocation(410, 170);
        flag3.setSize(80, 25);
        flag3.setLocation(410, 220);

        add(b);
        add(del);
        add(text);
        add(l1);
        add(fl1);
        add(fl2);
        add(fl3);
        add(fl4);
        add(fl5);
        add(fl6);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);
        add(flag3);
        box_1.setSelectedItem(null);
        box_2.setSelectedItem(null);
        box_3.setSelectedItem(null);
        b.addActionListener(new ButtonActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        flag3.addActionListener(new FlActionListener());
        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());
        box_2.addActionListener(new BoxActionListener());
        box_3.addActionListener(new BoxActionListener());
        text.addKeyListener(new check());
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);
                try {

                    String text1 = text.getText();
                    Pattern p1 = Pattern.compile("\\d");
                    Matcher m1 = p1.matcher(text1);
                    Pattern p2 = Pattern.compile("\\W");
                    Matcher m2 = p2.matcher(text1);
                    if (text == null || text.getText() == null || text.getText().trim().length() == 0 || text1 == "") {
                        fl1.setVisible(true);
                    }
                    if (m1.find() == true || m2.find() == true) {
                        fl1.setVisible(false);
                        fl6.setVisible(true);
                    }
                    if (boxA == null) {
                        //fl6.setVisible(false);
                        //fl2.setVisible(false);
                        //fl1.setVisible(false);
                        fl3.setVisible(true);
                    }
                    if (boxB == null) {
                        //fl6.setVisible(false);
                        //fl2.setVisible(false);
                        //fl1.setVisible(false);
                        //fl3.setVisible(false);
                        fl4.setVisible(true);
                    }
                    if (boxC == null) {
                        //fl6.setVisible(false);
                        //fl2.setVisible(false);
                        //fl1.setVisible(false);
                        //fl3.setVisible(false);
                        //fl4.setVisible(false);
                        fl5.setVisible(true);
                    } else {
                        // load.setEnabled(true);
                        fl1.setVisible(false);
                        fl2.setVisible(false);
                        fl3.setVisible(false);
                        fl4.setVisible(false);
                        fl5.setVisible(false);
                        fl6.setVisible(false);
                        out.write(text1 + "\n");
                        if (k == 1)
                            out.write("Пол: жен. " + "\n");
                        else if (k == -1)
                            out.write("Пол: муж. " + "\n");
                        out.write(" (Дата посещения выставки:" + boxA + " " + boxB + ")" + "\n");
                        out.write("Бренд: " + boxC + "\n");
                        if (fl == 1)
                            out.write("Будут советывать выставку знвкомым. ");
                        else if (fl == -1)
                            out.write("Не будут советывать выставку знвкомым. ");
                    }
                } finally {
                    out.close();
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            if (e.getSource() == flag1) {
                k--;
            } else if (e.getSource() == flag2) {
                k++;
            }
        }
    }

    public class FlActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            fl = 0;
            if (e.getSource() == flag3) {
                if (ch % 2 != 0) {
                    fl++;
                } else fl--;
                ch++;
            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                text.setText(null);
                ch = 1;
                box_1.setSelectedItem(null);
                box_2.setSelectedItem(null);
                box_3.setSelectedItem(null);
                bg.clearSelection();
                flag3.setSelected(false);
            }
        }
    }

    public class BoxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == box_1) {
                boxA = box_1.getSelectedItem();
            }
            if (e.getSource() == box_2) {
                boxB = box_2.getSelectedItem();
            }
            if (e.getSource() == box_3) {
                boxC = box_3.getSelectedItem();
            }
        }
    }

    public class check implements KeyListener {
        public check() {
            super();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()!=0){
                fl1.setVisible(false);
                fl6.setVisible(false);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}