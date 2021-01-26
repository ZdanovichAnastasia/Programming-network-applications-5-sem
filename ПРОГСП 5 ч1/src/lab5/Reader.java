package lab5;
import java.awt.event.*;
import javax.swing.*;

public class Reader extends JFrame {
    int fl = 0;
    JList list1, list2, list3, list4;
    JButton button, del, but;
    JCheckBox flag1, flag2;
    String[] myList1 = {"Некрасова Ирина", "Лепель Андрей", "Иванов Николай", "Руденко Екатерина", "Некрасов Павел", "Мирницкая Анастасия"};
    String[] myList2 = {};

    public Reader(String str) {
        super(str);
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        button = new JButton("Обновить список");
        button.setSize(200, 30);
        button.setLocation(150, 400);
        but = new JButton("Перенести");
        but.setSize(200, 30);
        but.setLocation(300, 400);

        del = new JButton("Очистить второй список");
        del.setSize(100, 30);
        del.setLocation(10, 400);

        list1 = new JList(myList1);
        list1.setSize(230, 110);
        list1.setLocation(10, 10);
        list2 = new JList(myList2);
        list2.setSize(230, 110);
        list2.setLocation(260, 10);
        list3 = new JList(myList1);
        list3.setSize(230, 110);
        list3.setLocation(10, 10);
        list4 = new JList(myList2);
        list4.setSize(230, 110);
        list4.setLocation(260, 10);

        flag1 = new JCheckBox("1 list");
        flag1.setSize(100, 30);
        flag1.setLocation(530, 30);
        flag2 = new JCheckBox("2 list");
        flag2.setSize(100, 30);
        flag2.setLocation(530, 70);
        add(list1);
        list1.setVisible(false);
        add(list2);
        add(list3);
        add(list4);
        list4.setVisible(false);
        add(flag1);
        add(flag2);
        add(del);
        add(button);
        add(but);
        button.addActionListener(new ButtonActionListener());
        del.addActionListener(new DelActionListener());
        flag1.addActionListener(new FlagActionListener());
        flag2.addActionListener(new FlagActionListener());
        but.addActionListener(new ButActionListener());
        list3.addMouseListener(new ButtonActionLisener());
    }

    public class FlagActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DefaultListModel lm = new DefaultListModel();
            for (int i = 0; i < list1.getModel().getSize(); i++) {
                lm.add(i, list1.getModel().getElementAt(i));
            }
            System.out.println("num"+lm.getSize());
            list1.setModel(new DefaultListModel());
            DefaultListModel lm1 = (DefaultListModel) list1.getModel();
            list2.setModel(new DefaultListModel());
            DefaultListModel lm2 = (DefaultListModel) list2.getModel();
            for (int i = 0; i < lm.getSize(); i++) {
                lm1.add(i, lm.getElementAt(i));
            }
            if (e.getSource() == flag1) {
                fl++;
                if (fl % 2 != 0) {
                    int k = 0;
                    for (int i = 1; i <= lm1.getSize(); i++) {
                        if (i == k + 1) {
                            lm1.remove(i - 1);
                            k = i;
                        }
                    }
                }
            } else if (e.getSource() == flag2) {
                int k = 0;
                for (int i = 1; i <= lm1.getSize(); i++) {
                    if (i % 2 == 0) {
                        lm2.add(k, lm1.getElementAt(i - 1));
                        k++;
                    }
                }
            }
        }
    }

    public class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                list1.setModel(new DefaultListModel());
                DefaultListModel lm1 = (DefaultListModel) list1.getModel();
                for (int i = 0; i < myList1.length; i++) {
                    lm1.add(i, myList1[i]);
                }
            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                list2.setModel(new DefaultListModel());
                DefaultListModel lm2 = (DefaultListModel) list2.getModel();
            }
        }
    }

    public class ButActionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == but) {
                list4.setVisible(true);
                list2.setVisible(false);
            }
        }
    }

    public class ButtonActionLisener implements MouseListener {
        //  Если пользователь нажал и отпустил одну из кнопок, вызывается метод mouseClicked.
        public void mouseClicked(MouseEvent e) {
            list2.setVisible(true);
            list4.setVisible(false);
            list3 =  (JList) e.getSource();
            Object[] text;
            int [] sel;
            sel = list3.getSelectedIndices();
            //System.out.println("num"+sel.length);
            int k=0;
            list4.setModel(new DefaultListModel());
            DefaultListModel lm2 = (DefaultListModel) list4.getModel();
            for(int i=0; i<list3.getModel().getSize(); i++)
            {
                for(int j=0; j<sel.length; j++){
                    if(i==sel[j]){
                        lm2.add(k,list3.getModel().getElementAt(i));
                        k++;
                    }
                }
            }
        }
        // mouseEntered - данный метод будет вызываться системой у слушателя каждый раз, когда курсор мыши будет оказываться над компонентом.
        public void mouseEntered(MouseEvent e) {
        }
        // mouseExited – данный метод срабатывает, когда убираем курсор мыши с компонента.
        public void mouseExited(MouseEvent e) {
        }
        // Навели на компонент, зажали кнопку — система вызвала mousePressed.
        public void mousePressed(MouseEvent e) {
        }
        // Отпускаем кнопку — система вызвала mouseReleased.
        public void mouseReleased(MouseEvent e) {
        }
    }
}