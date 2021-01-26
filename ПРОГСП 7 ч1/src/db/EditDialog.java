package db;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.text.SimpleDateFormat;

public class EditDialog extends javax.swing.JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField ID_tf;
    private JTextField Surname_tf;
    private JTextField Subdivision_tf;
    private JTextField Birth_tf;
    private JTextField Name_tf;
    private JTextField Position_tf;
    private JTextField Address_tf;
    private JTextField Gen_tf;
    private JTextField Secondname_tf;
    private JLabel ID_m;
    private JLabel Surname_m;
    private JLabel Name_m;
    private JLabel Secondname_m;
    private JLabel Gen_m;
    private JLabel Birth_m;
    private JLabel Address_m;
    private JLabel Position_m;
    private JLabel Subdivision_m;
    private JLabel flag;
    boolean idf = false;
    boolean surnf = false;
    boolean namef = false;
    boolean secondnf = false;
    boolean genf = false;
    boolean birthf = false;
    boolean addrf = false;
    boolean posf = false;
    boolean subdf = false;

    public EditDialog(Frame parent, boolean modal) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        flag.setVisible(false);

        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });
        ID_tf.getDocument().addDocumentListener(listener_id);
        Surname_tf.getDocument().addDocumentListener(listener_surname);
        Name_tf.getDocument().addDocumentListener(listener_name);
        Secondname_tf.getDocument().addDocumentListener(listener_secondname);
        Gen_tf.getDocument().addDocumentListener(listener_gen);
        Birth_tf.getDocument().addDocumentListener(listener_date);
        Address_tf.getDocument().addDocumentListener(listener_address);
        Position_tf.getDocument().addDocumentListener(listener_pos);
        Subdivision_tf.getDocument().addDocumentListener(listener_subdiv);
    }
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(idf==true || namef==true||surnf==true||secondnf==true||genf==true||birthf==true||addrf==true||posf==true||subdf==true) {
            flag.setText("ok");
            this.setVisible(false);
        }
    }
    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        if(idf==true || namef==true||surnf==true||secondnf==true||genf==true||birthf==true||addrf==true||posf==true||subdf==true) {
            flag.setText("сancel");
            this.setVisible(false);
        }
    }
    public String getID_tf() {
        return ID_tf.getText();
    }
    public String getAddress_tf() {
        return Address_tf.getText();
    }

    public String getBirth_tf() {
        return Birth_tf.getText();
    }

    public String getGen_tf() {
        return Gen_tf.getText();
    }

    public String getPosition_tf() {
        return Position_tf.getText();
    }

    public String getSecondname_tf() {
        return Secondname_tf.getText();
    }

    public String getSubdivision_tf() {
        return Subdivision_tf.getText();
    }

    public String getName_tf() {
        return Name_tf.getText();
    }

    public String getSurname_tf() {
        return Surname_tf.getText();
    }
    public void setID_tf(String id_tf) {
        this.ID_tf.setText(id_tf);
    }
    public void setAddress_tf(String address_tf) {
        this.Address_tf.setText(address_tf);
    }

    public void setBirth_tf(String birth_tf) {
        this.Birth_tf.setText(birth_tf);
    }

    public void setGen_tf(String gen_tf) {
        this.Gen_tf.setText(gen_tf);
    }

    public void setName_tf(String name_tf) {
        this.Name_tf.setText(name_tf);
    }

    public void setPosition_tf(String position_tf) {
        this.Position_tf.setText(position_tf);
    }

    public void setSecondname_tf(String secondname_tf) {
        this.Secondname_tf.setText(secondname_tf);
    }

    public void setSubdivision_tf(String subdivision_tf) {
        this.Subdivision_tf.setText(subdivision_tf);
    }

    public void setSurname_tf(String surname_tf) {
        this.Surname_tf.setText(surname_tf);
    }
    public String getFlag(){
        return flag.getText();
    }
    DocumentListener listener_id = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            try{
                int x = Integer.parseInt(ID_tf.getText().trim());
                ID_m.setVisible(false);
                idf = true;
            }catch (NumberFormatException ev){
                ID_m.setText("Поле должно содержать только цифры");
                ID_m.setVisible(true);
                idf = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try{
                int x = Integer.parseInt(ID_tf.getText().trim());
                ID_m.setVisible(false);
                idf = true;
            }catch (NumberFormatException ev){
                if(ID_tf.getText().trim().equals("")) {
                    ID_m.setText("Поле не должно быть пустым");
                }
                else {
                    ID_m.setText("Поле должно содержать только цифры");
                }
                ID_m.setVisible(true);
                idf = false;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_gen = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if(Gen_tf.getText().trim().equals("m")||Gen_tf.getText().trim().equals("wm")||Gen_tf.getText().trim().equals("мж")||Gen_tf.getText().trim().equals("ж")){
                Gen_m.setVisible(false);
                genf = true;
            }
            else {
                Gen_m.setText("Поле должно содержать 'мж', 'ж', 'm', 'wm'");
                Gen_m.setVisible(true);
                genf = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if(Gen_tf.getText().trim().equals("")) {
                Gen_m.setText("Поле не должно быть пустым");
                Gen_m.setVisible(true);
                genf = false;
            }
            else if(Gen_tf.getText().trim().equals("m")||Gen_tf.getText().trim().equals("wm")||Gen_tf.getText().trim().equals("мж")||Gen_tf.getText().trim().equals("ж")){
                Gen_m.setVisible(false);
                genf =true;
            }
            else {
                Gen_m.setText("Поле должно содержать 'мж', 'ж', 'm', 'wm'");
                Gen_m.setVisible(true);
                genf = false;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_surname = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String surname = Surname_tf.getText().trim();
            if(surname.matches("[a-zA-zа-яА-Я]+")==false){
                Surname_m.setText("Поле должно содержать только буквы");
                Surname_m.setVisible(true);
                surnf = false;
            }
            else {
                Surname_m.setVisible(false);
                surnf = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String surname = Surname_tf.getText().trim();
            if(Surname_tf.getText().trim().equals("")) {
                Surname_m.setText("Поле не должно быть пустым");
                Surname_m.setVisible(true);
                surnf = false;
            }
            else if(surname.matches("[a-zA-zа-яА-Я]+")==false){
                Surname_m.setText("Поле должно содержать только буквы");
                Surname_m.setVisible(true);
                surnf = false;
            }
            else {
                Surname_m.setVisible(false);
                surnf = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_name = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String name = Name_tf.getText().trim();
            if(name.matches("[a-zA-zа-яА-Я]+")==false){
                Name_m.setText("Поле должно содержать только буквы");
                Name_m.setVisible(true);
                namef = false;
            }
            else {
                Name_m.setVisible(false);
                namef = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String name = Name_tf.getText().trim();
            if(Name_tf.getText().trim().equals("")) {
                Name_m.setText("Поле не должно быть пустым");
                Name_m.setVisible(true);
                namef = false;
            }
            else if(name.matches("[a-zA-zа-яА-Я]+")==false){
                Name_m.setText("Поле должно содержать только буквы");
                Name_m.setVisible(true);
                namef = false;
            }
            else  {
                Name_m.setVisible(false);
                namef = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_secondname = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String secondname = Secondname_tf.getText().trim();
            if(secondname.matches("[a-zA-zа-яА-Я]+")==false){
                Secondname_m.setText("Поле должно содержать только буквы");
                Secondname_m.setVisible(true);
                secondnf = false;
            }
            else {
                Secondname_m.setVisible(false);
                secondnf = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String secondname = Secondname_tf.getText().trim();
            if(Secondname_tf.getText().trim().equals("")) {
                Secondname_m.setText("Поле не должно быть пустым");
                Secondname_m.setVisible(true);
                secondnf = false;
            }
            else if(secondname.matches("[a-zA-zа-яА-Я]+")==false){
                Secondname_m.setText("Поле должно содержать только буквы");
                Secondname_m.setVisible(true);
                secondnf = false;
            }
            else {
                Secondname_m.setVisible(false);
                secondnf = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_address = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if(Address_tf.getText().trim().equals("")) {
                Address_m.setText("Поле не должно быть пустым");
                Address_m.setVisible(true);
                addrf = false;
            }
            else {
                Address_m.setVisible(false);
                addrf = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if(Address_tf.getText().trim().equals("")) {
                Address_m.setText("Поле не должно быть пустым");
                Address_m.setVisible(true);
                addrf = false;
            }
            else  {
                Address_m.setVisible(false);
                addrf = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_pos = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String pos = Position_tf.getText().trim();
            if(pos.matches("[a-zA-zа-яА-Я]+")==false){
                Position_m.setText("Поле должно содержать только буквы");
                Position_m.setVisible(true);
                posf = false;
            }
            else {
                Position_m.setVisible(false);
                posf = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            String pos = Position_tf.getText().trim();
            if(Position_tf.getText().trim().equals("")) {
                Position_m.setText("Поле не должно быть пустым");
                Position_m.setVisible(true);
                posf = false;
            }
            else if(pos.matches("[a-zA-zа-яА-Я]+")==false){
                Position_m.setText("Поле должно содержать только буквы");
                Position_m.setVisible(true);
                posf = false;
            }
            else {
                Position_m.setVisible(false);
                posf = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_subdiv = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            if(Subdivision_tf.getText().trim().equals("")) {
                Subdivision_m.setText("Поле не должно быть пустым");
                Subdivision_m.setVisible(true);
                subdf = false;
            }
            else {
                Subdivision_m.setVisible(false);
                subdf = true;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if(Subdivision_tf.getText().trim().equals("")) {
                Subdivision_m.setText("Поле не должно быть пустым");
                Subdivision_m.setVisible(true);
                subdf = false;
            }
            else {
                Subdivision_m.setVisible(false);
                subdf = true;
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    DocumentListener listener_date = new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);
            try{
                //Date d = new SimpleDateFormat("dd.MM.YYYY").parse(Birth_tf.getText().trim());
                formatter.parse(Birth_tf.getText().trim());
                Birth_m.setVisible(false);
                birthf = true;

                String str1 = Birth_tf.getText().trim();
                String str = str1.replace("."," ");
                String [] date = str.split(" ");

                if(date.length>3){
                    Birth_m.setText("Поле дожно иметь вид 'день.месяц.год'");
                    Birth_m.setVisible(true);
                    birthf = false;
                }
                else{
                    int day = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    if(check_date(day, month, year)==false){
                        Birth_m.setVisible(true);
                        birthf = false;
                    }
                    else {
                        Birth_m.setVisible(false);
                        birthf = true;
                    }
                }
            }catch (Exception ex){
                Birth_m.setText("Дата введена неправильно");
                Birth_m.setVisible(true);
                birthf = false;
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if (Birth_tf.getText().trim().equals("")) {
                Birth_m.setText("Поле не должно быть пустым");
                Birth_m.setVisible(true);
                birthf = false;
            } else {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                formatter.setLenient(false);
                try {
                    //Date d = new SimpleDateFormat("dd.MM.YYYY").parse(Birth_tf.getText().trim());
                    formatter.parse(Birth_tf.getText().trim());
                    //Birth_m.setVisible(false);

                    String str1 = Birth_tf.getText().trim();
                    String str = str1.replace(".", " ");
                    String[] date = str.split(" ");

                    if (date.length > 3) {
                        Birth_m.setText("Поле дожно иметь вид 'день.месяц.год'");
                        Birth_m.setVisible(true);
                        birthf = false;
                    } else {
                        int day = Integer.parseInt(date[0]);
                        int month = Integer.parseInt(date[1]);
                        int year = Integer.parseInt(date[2]);
                        if (check_date(day, month, year) == false) {
                            Birth_m.setVisible(true);
                            birthf = false;
                        } else {
                            Birth_m.setVisible(false);
                            birthf = true;
                        }
                    }
                }catch(Exception ex){
                    Birth_m.setText("Дата введена неправильно");
                    Birth_m.setVisible(true);
                    birthf = false;
                }
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
        }
    };
    boolean check_date(int day, int month, int year)
    {
        if (year > 2002 || year < 1960)
        {
            Birth_m.setText("Год введен неверно");
            return false;
        }
        if (month == 2) {
            if (year % 4 == 0 && day > 29)
            {
                Birth_m.setText("В феврале не может быть больше 29 дней! Год високосный");
                return false;
            }
            else if (year % 4 != 0 && day > 28)
            {
                Birth_m.setText("В феврале не может быть больше 28 дней, год не високосный!");
                return false;
            }
        }
        return true;
    }
}
