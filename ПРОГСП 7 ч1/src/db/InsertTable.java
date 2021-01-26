package db;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertTable extends javax.swing.JFrame {
    private DbConnection mdbc;
    private java.sql.Statement stmt;
    private EditDialog dlg;

    private JPanel contentPane;
    private JTextField ID_tf;
    private JTextField Surname_tf;
    private JTextField Position_tf;
    private JTextField Name_tf;
    private JTextField Address_tf;
    private JTextField Birth_tf;
    private JTextField Gen_tf;
    private JTextField Secondname_tf;
    private JTextField Subdividsion_tf;
    private JTable table1;
    private JButton deleteButton;
    private JButton addButton;
    private JButton editButton;
    private JButton clearButton;
    private JScrollPane Scroll;
    private JLabel CommentLabel;
    private JLabel ID_m;
    private JLabel Surname_m;
    private JLabel Name_m;
    private JLabel Secondname_m;
    private JLabel Gen_m;
    private JLabel Birth_m;
    private JLabel Address_m;
    private JLabel Position_m;
    private JLabel Subdivision_m;
    boolean idf = false;
    boolean surnf = false;
    boolean namef = false;
    boolean secondnf = false;
    boolean genf = false;
    boolean birthf = false;
    boolean addrf = false;
    boolean posf = false;
    boolean subdf = false;

    public InsertTable() {
        dlg = new EditDialog(this, true);
        setContentPane(contentPane);
        try {
            mdbc = new DbConnection();
            mdbc.init();
            Connection conn = mdbc.getMyConnection();
            stmt = conn.createStatement();
        } catch (Exception e) {
            initComponents();
        }
        //addButton.setEnabled(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        CommentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CommentLabel.setText("Заполните все поля корректно");
        ResultSet rs = getResultFrom();
        table1.setModel(new EmloyeesTable(rs));
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        table1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TableComponentShown(evt);
            }
        });
        Scroll.setViewportView(table1);

        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
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
        Subdividsion_tf.getDocument().addDocumentListener(listener_subdiv);

    }

    private void update(){
        ID_tf.setText("");
        Surname_tf.setText("");
        Position_tf.setText("");
        Name_tf.setText("");
        Address_tf.setText("");
        Birth_tf.setText("");
        Gen_tf.setText("");
        Secondname_tf.setText("");
        Subdividsion_tf.setText("");
        ResultSet rs = getResultFrom();
        table1.setModel(new EmloyeesTable(rs));
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        ID_tf = new javax.swing.JTextField();
        Surname_tf = new javax.swing.JTextField();
        Position_tf = new javax.swing.JTextField();
        Name_tf = new javax.swing.JTextField();
        Address_tf = new javax.swing.JTextField();
        //Birth_tf = new javax.swing.JTextField();
        Gen_tf = new javax.swing.JTextField();
        Secondname_tf = new javax.swing.JTextField();
        Subdividsion_tf = new javax.swing.JTextField();
        table1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        CommentLabel = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });
        CommentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CommentLabel.setText("Заполните все поля корректно");
        ResultSet rs = getResultFrom();
        table1.setModel(new EmloyeesTable(rs));
        table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mdbc.close(rs);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        table1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TableComponentShown(evt);
            }
        });
        Scroll.setViewportView(table1);

        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

    }

    public String quotate(String content) {
        return " ' " + content + " ' ";
    }

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String ID = ID_tf.getText();
        String Surname = Surname_tf.getText();
        String Name = Name_tf.getText();
        String Secondname = Secondname_tf.getText();
        String Gen = Gen_tf.getText();
        String Birth = Birth_tf.getText();
        String Address = Address_tf.getText();
        String Position = Position_tf.getText();
        String Subdividsion = Subdividsion_tf.getText();
        if(ID.equals("")) ID_m.setText("Поле не должно быть пустым");
        if(Surname.equals("")) Surname_m.setText("Поле не должно быть пустым");
        if(Name.equals("")) Name_m.setText("Поле не должно быть пустым");
        if(Secondname.equals("")) Secondname_m.setText("Поле не должно быть пустым");
        if(Gen.equals("")) Gen_m.setText("Поле не должно быть пустым");
        if(Birth.equals("")) Birth_m.setText("Поле не должно быть пустым");
        if(Address.equals("")) Address_m.setText("Поле не должно быть пустым");
        if(Position.equals("")) Position_m.setText("Поле не должно быть пустым");
        if(Subdividsion.equals("")) Subdivision_m.setText("Поле не должно быть пустым");
        else if(idf==true || namef==true||surnf==true||secondnf==true||genf==true||birthf==true||addrf==true||posf==true||subdf==true) {
           // addButton.setEnabled(true);
            String insertStr = "";
            try {
                insertStr = "INSERT INTO employee VALUES ("
                        + quotate(ID) + ","
                        + quotate(Surname) + ","
                        + quotate(Name) + ","
                        + quotate(Secondname) + ","
                        + quotate(Gen) + ","
                        + quotate(Birth) + ","
                        + quotate(Address) + ","
                        + quotate(Position) + ","
                        + quotate(Subdividsion) + ")";
                System.out.println("1 " + insertStr);
                int done = stmt.executeUpdate(insertStr);
                System.out.println("2 " + insertStr);
                CommentLabel.setText("Данные добавлены");
                //initComponents();
                update();
            } catch (Exception e) {
                CommentLabel.setText("Ошибка добавления данных");
            }
        }
    }

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        try {
            ID_tf.setText("");
            Surname_tf.setText("");
            Position_tf.setText("");
            Name_tf.setText("");
            Address_tf.setText("");
            Birth_tf.setText("");
            Gen_tf.setText("");
            Secondname_tf.setText("");
            Subdividsion_tf.setText("");
        }catch (Exception ex){}
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        try {
            mdbc.close(stmt.getResultSet());
            mdbc.destroy();
        } catch (SQLException ex) {
        }
    }

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        dlg.setTitle("Редактирование");
        dlg.pack();
        dlg.setLocationRelativeTo(null);
        //dlg.setVisible(true);
        dlg.setID_tf((String) table1.getValueAt(table1.getSelectedRow(), 0));
        dlg.setSurname_tf((String) table1.getValueAt(table1.getSelectedRow(), 1));
        dlg.setName_tf((String) table1.getValueAt(table1.getSelectedRow(), 2));
        dlg.setSecondname_tf((String) table1.getValueAt(table1.getSelectedRow(), 3));
        dlg.setGen_tf((String) table1.getValueAt(table1.getSelectedRow(), 4));
        dlg.setBirth_tf((String) table1.getValueAt(table1.getSelectedRow(), 5));
        dlg.setAddress_tf((String) table1.getValueAt(table1.getSelectedRow(), 6));
        dlg.setPosition_tf((String) table1.getValueAt(table1.getSelectedRow(), 7));
        dlg.setSubdivision_tf((String) table1.getValueAt(table1.getSelectedRow(), 8));
        dlg.setVisible(true);
        if(dlg.getFlag().equals("ok")){
        try {
            String insertStr = "UPDATE employee SET idEmployee="
                    + quotate(dlg.getID_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Id "+insertStr);
            int done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET surname="
                    + quotate(dlg.getSurname_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Surname "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET name="
                    + quotate(dlg.getName_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Name "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET secondname ="
                    + quotate(dlg.getSecondname_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Secondname "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET gen="
                    + quotate(dlg.getGen_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Gen "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET birth="
                    + quotate(dlg.getBirth_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Birth "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET address="
                    + quotate(dlg.getAddress_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("Address "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET position="
                    + quotate(dlg.getPosition_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("position "+insertStr);
            done = stmt.executeUpdate(insertStr);
            insertStr = "UPDATE employee SET subdivision="
                    + quotate(dlg.getSubdivision_tf()) + "WHERE idEmployee =" + (String) table1.getValueAt(table1.getSelectedRow(), 0);
            System.out.println("subdivision "+insertStr);
            done = stmt.executeUpdate(insertStr);
            //getContentPane().removeAll();
            //initComponents();
            update();
            CommentLabel.setText("Данные отредактированы");
        } catch (Exception e) {
            CommentLabel.setText("Ошибка редактирования данных");
        }}
        else 
        {
            CommentLabel.setText("Ошибка редактирования данных ");
        }
    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        String ID = (String) table1.getValueAt(table1.getSelectedRow(), 0);
        String insertStr = "";
        try {
            insertStr = "DELETE FROM employee WHERE idEmployee=" + ID;
            int done = stmt.executeUpdate(insertStr);
            CommentLabel.setText("Данные удалены");
            //getContentPane().removeAll();
            //initComponents();
            update();
        } catch (Exception e) {
            CommentLabel.setText("Ошибка удаления данных");
        }
    }

    private void TableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_CarTableComponentShown
        // TODO add your handling code here:
    }

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarTableMouseClicked
        if (table1.getSelectedRowCount() > 0) {
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
        } else {
            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
        // TODO add your handling code here:
    }

    public ResultSet getResultFrom() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM employee");
        } catch (SQLException e) {
        }
        return rs;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
            if(Subdividsion_tf.getText().trim().equals("")) {
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
            if(Subdividsion_tf.getText().trim().equals("")) {
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

