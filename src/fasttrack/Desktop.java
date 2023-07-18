/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fasttrack;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Paledi.Egnitius
 */
public class Desktop extends javax.swing.JFrame {

    Connection conn = null;

    public Desktop() {

        initComponents();

        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String user = "root";
            String pword = "12345";

            conn = DriverManager.getConnection(url, user, pword);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
        }

        displayImageOnButton(jButton3, 1);
        displayImageOnButton(jButton4, 2);
        displayImageOnButton(jButton5, 3);
        displayImageOnButton(jButton2, 5);
        displayImageOnButton(jButton6, 6);
        displayImageOnButton(jButton7, 4);
        displayImageOnButton(jButton8,8);
        displayImageOnButton(jButton9, 7);
        displayImageOnButton(jButton10,12);
        displayImageOnButton(jButton11, 10);
        displayImageOnButton(jButton12, 9);
        displayImageOnButton(jButton13, 11);
        
    }

    public void addtable(int itemID, String Item, int Qty, Double Price) {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        Vector v = new Vector();

        v.add(itemID);
        v.add(Item);
        v.add(Qty);
        v.add(Price);

        dt.addRow(v);
    }

    public void addtables(int itemID, String Item, int Qty, Double Price) {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        Double totalPrice = Price * Qty;

        // Check if the item already exists in the table
        for (int row = 0; row < dt.getRowCount(); row++) {
            String itemName = (String) dt.getValueAt(row, 1);
            if (Item.equals(itemName)) {
                dt.removeRow(row);
                break;
            }
        }

        Vector<Object> rowData = new Vector<>();
        rowData.add(itemID);
        rowData.add(Item);
        rowData.add(Qty);
        rowData.add(df.format(totalPrice));

        dt.addRow(rowData);
    }

    public void cal() {

        int numOfRow = jTable1.getRowCount();
        Double tot = 0.0;

        for (int i = 0; i < numOfRow; i++) {

            Double value = Double.valueOf(jTable1.getValueAt(i, 3).toString());
            tot += value;

        }

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        total.setText(String.valueOf(df.format(tot)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        change = new java.awt.Label();
        total = new java.awt.Label();
        btnPay = new java.awt.Button();
        btnPrint = new java.awt.Button();
        cash = new java.awt.TextField();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl8 = new javax.swing.JLabel();
        lbl9 = new javax.swing.JLabel();
        lbl10 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblA1 = new javax.swing.JLabel();
        lblA2 = new javax.swing.JLabel();
        lblA3 = new javax.swing.JLabel();
        lblA4 = new javax.swing.JLabel();
        lblA5 = new javax.swing.JLabel();
        lblA6 = new javax.swing.JLabel();
        lblA7 = new javax.swing.JLabel();
        lblA8 = new javax.swing.JLabel();
        lblA9 = new javax.swing.JLabel();
        lblA10 = new javax.swing.JLabel();
        lblA11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        printScreen = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FastTrack");
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        label1.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        label1.setText("Change:");

        label2.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        label2.setText("Total:");

        label3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        label3.setText("Cash:");

        change.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        change.setText("00");

        total.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        total.setText("00");

        btnPay.setBackground(new java.awt.Color(0, 102, 102));
        btnPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPay.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setLabel("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(0, 102, 102));
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setLabel("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        cash.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(165, 165, 165)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel5.setText("1 kg Apples");

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel6.setText("R 25.00");

        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel7.setText("1 kg Bananas");

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel8.setText("R 30.00");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setText("1 kg Pears");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setText("R 20.00");

        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel9.setText("Watermelon");

        jLabel10.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel10.setText("R 20.00");

        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel11.setText("R 20.00");

        jLabel12.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel12.setText("1 kg Grapes");

        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel13.setText("1 kg Beetroot");

        jLabel14.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel14.setText("R 25.00");

        jLabel15.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel15.setText("Cabbage");

        jLabel16.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel16.setText("R 50.00");

        jLabel17.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel17.setText("1 kg Carrots");

        jLabel18.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel18.setText("R 15.00");

        jLabel19.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel19.setText("1 kg Mangos");

        jLabel20.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel20.setText("R 35.00");

        jLabel21.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel21.setText("Pumpkin");

        jLabel22.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel22.setText("R 35.00");

        jLabel23.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel23.setText("Potatoes");

        jLabel24.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel24.setText("R 60.00");

        jLabel25.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel25.setText("1 kg Onions");

        jLabel26.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel26.setText("R 15.00");

        lbl2.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl2.setText("0");

        lbl1.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl1.setText("0");

        lbl3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl3.setText("0");

        lbl4.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl4.setText("0");

        lbl5.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl5.setText("0");

        lbl6.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl6.setText("0");

        lbl7.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl7.setText("0");

        lbl8.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl8.setText("0");

        lbl9.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl9.setText("0");

        lbl10.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl10.setText("0");

        lbl11.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl11.setText("0");

        lbl12.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        lbl12.setText("0");

        lblA.setForeground(new java.awt.Color(0, 102, 102));
        lblA.setText("0");

        lblA1.setForeground(new java.awt.Color(0, 102, 102));
        lblA1.setText("0");

        lblA2.setForeground(new java.awt.Color(0, 102, 102));
        lblA2.setText("0");

        lblA3.setForeground(new java.awt.Color(0, 102, 102));
        lblA3.setText("0");

        lblA4.setForeground(new java.awt.Color(0, 102, 102));
        lblA4.setText("0");

        lblA5.setForeground(new java.awt.Color(0, 102, 102));
        lblA5.setText("0");

        lblA6.setForeground(new java.awt.Color(0, 102, 102));
        lblA6.setText("0");

        lblA7.setForeground(new java.awt.Color(0, 102, 102));
        lblA7.setText("0");

        lblA8.setForeground(new java.awt.Color(0, 102, 102));
        lblA8.setText("0");

        lblA9.setForeground(new java.awt.Color(0, 102, 102));
        lblA9.setText("0");

        lblA10.setForeground(new java.awt.Color(0, 102, 102));
        lblA10.setText("0");

        lblA11.setForeground(new java.awt.Color(0, 102, 102));
        lblA11.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblA4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 2, Short.MAX_VALUE)
                                        .addComponent(lbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblA8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblA9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblA5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(lblA7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(289, 289, 289)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblA10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblA11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17)
                                        .addComponent(lbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblA6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lblA2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(163, 163, 163)
                                                .addComponent(lblA3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(5, 5, 5))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblA1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblA1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblA2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblA3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblA6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblA7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblA5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblA4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblA10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblA8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblA9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblA11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "itemID", "Item", "Qty", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        printScreen.setColumns(20);
        printScreen.setRows(5);
        jScrollPane2.setViewportView(printScreen);

        btnDelete.setBackground(new java.awt.Color(0, 102, 102));
        btnDelete.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateQuantityLabel(int itemID, JLabel label) {
        try {
            String query = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement pet = conn.prepareStatement(query);
            pet.setInt(1, itemID);
            ResultSet resultSet = pet.executeQuery();

            if (resultSet.next()) {
                int quantity = resultSet.getInt("quantity");
                label.setText(String.valueOf(quantity));
            } else {
                label.setText("No data found");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // BTN CODE
        int itemID = 1; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(1, lbl1);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA.getText());
        ++i;
        lblA.setText(String.valueOf(i));
        addtables(itemID, "Apples", i, 25.00);
        cal();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // BTN CODE
        int itemID = 3; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(3, lbl3);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA2.getText());
        ++i;
        lblA2.setText(String.valueOf(i));
        addtables(itemID, "Pears", i, 20.00);
        cal();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // BTN CODE
        int itemID = 2; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(2, lbl2);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA1.getText());
        ++i;
        lblA1.setText(String.valueOf(i));
        addtables(itemID, "Bananas", i, 30.00);
        cal();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BTN CODE
        int itemID = 4; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(4, lbl4);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA3.getText());
        ++i;
        lblA3.setText(String.valueOf(i));
        addtables(itemID, "Watermelon", i, 20.00);
        cal();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // BTN CODE
        int itemID = 11; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(11, lbl12);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA10.getText());
        ++i;
        lblA10.setText(String.valueOf(i));
        addtables(itemID, "Potatoes", i, 60.00);
        cal();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // BTN CODE
        int itemID = 6; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(6, lbl5);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA5.getText());
        ++i;
        lblA5.setText(String.valueOf(i));
        addtables(itemID, "Grapes", i, 50.00);
        cal();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // BTN CODE
        int itemID = 5; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(5, lbl6);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA4.getText());
        ++i;
        lblA4.setText(String.valueOf(i));
        addtables(itemID, "Mangos", i, 35.00);
        cal();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // BTN CODE
        int itemID = 7; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(7, lbl8);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA6.getText());
        ++i;
        lblA6.setText(String.valueOf(i));
        addtables(itemID, "Cabbage", i, 25.00);
        cal();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // BTN CODE
        int itemID = 8; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(8, lbl7);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA7.getText());
        ++i;
        lblA7.setText(String.valueOf(i));
        addtables(itemID, "Carrots", i, 15.00);
        cal();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // BTN CODE
        int itemID = 9; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(9, lbl10);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA8.getText());
        ++i;
        lblA8.setText(String.valueOf(i));
        addtables(itemID, "Beetroot", i, 20.00);
        cal();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // BTN CODE
        int itemID = 10; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(10, lbl9);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA9.getText());
        ++i;
        lblA9.setText(String.valueOf(i));
        addtables(itemID, "Pumpkin", i, 35.00);
        cal();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // BTN CODE
        int itemID = 12; // Replace with the actual item ID you want to update
        int currentQuantity = 0;

        try {
            String getCurrentQuantityQuery = "SELECT quantity FROM stock WHERE itemID = ?";
            PreparedStatement getCurrentQuantityStmt = conn.prepareStatement(getCurrentQuantityQuery);
            getCurrentQuantityStmt.setInt(1, itemID);
            ResultSet currentQuantityResult = getCurrentQuantityStmt.executeQuery();

            if (currentQuantityResult.next()) {
                currentQuantity = currentQuantityResult.getInt("quantity");
            } else {
                System.out.println("No data found for itemID: " + itemID);
                return;
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
            return;
        }

        int newQuantity = currentQuantity - 1;

        try {
            String updateQuery = "UPDATE stock SET quantity = ? WHERE itemID = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, itemID);
            int rowsAffected = updateStmt.executeUpdate();

            updateQuantityLabel(12, lbl11);

            if (rowsAffected > 0) {
                System.out.println("Quantity updated successfully.");
            } else {
                System.out.println("No rows updated.");
            }
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }

        int i = Integer.parseInt(lblA11.getText());
        ++i;
        lblA11.setText(String.valueOf(i));
        addtables(itemID, "Onions", i, 15.00);
        cal();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void displayImageOnButton(JButton button, int itemID) {
        try {
            String query = "SELECT productImg FROM stock WHERE itemID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, itemID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                byte[] imageData = resultSet.getBytes("productImg");
                if (imageData != null) {
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageData);
                    BufferedImage image = ImageIO.read(inputStream);

                    // Create an ImageIcon from the BufferedImage
                    ImageIcon icon = new ImageIcon(image);

                    // Set the ImageIcon as the icon for the button
                    button.setIcon(icon);
                } else {
                    System.out.println("No image found for itemID: " + itemID);
                }
            } else {
                System.out.println("No data found for itemID: " + itemID);
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error retrieving image: " + e.getMessage());
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // delete some iteam
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();

        //remove product
        int rw = jTable1.getSelectedRow();
        dt.removeRow(rw);

        //remove Qty Lable
        System.out.println(r);
        switch (r) {

            case "1":
                lbl1.setText("0");
                break;

            case "2":
                lbl2.setText("0");
                break;

            case "3":
                lbl3.setText("0");
                break;

            case "4":
                lbl4.setText("0");
                break;

            case "5":
                lbl5.setText("0");
                break;

            case "6":
                lbl6.setText("0");

            case "7":
                lbl7.setText("0");
                break;

            case "8":
                lbl8.setText("0");
                break;

            case "9":
                lbl9.setText("0");
                break;

            case "10":
                lbl10.setText("0");
                break;

            case "11":
                lbl11.setText("0");
                break;

            case "12":
                lbl12.setText("0");
                break;
            default:
                System.out.println("over");
        }

        cal(); // after iteam delete calculate total
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // pat btn
        Double tot = Double.valueOf(total.getText());
        Double paid = Double.valueOf(cash.getText());
        Double balance = paid - tot;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        change.setText(String.valueOf(df.format(balance)));
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
// bill print
        try {
            printScreen.setText("\tFastTrack\n");
            printScreen.setText(printScreen.getText() + "\t19AM\n");
            printScreen.setText(printScreen.getText() + " \tBraamFontain\n");
            printScreen.setText(printScreen.getText() + "\t010 1111 234\n");
            printScreen.setText(printScreen.getText() + "--------------------------------------------------------------\n");
            printScreen.setText(printScreen.getText() + "   Item  \tQuantity  \tPrice" + "\n");
            printScreen.setText(printScreen.getText() + "--------------------------------------------------------------\n");

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            //printScreen.setText(printScreen.getText() + "  ");
            //Getting table product details
            for (int a = 0; a < jTable1.getRowCount(); a++) {
                String name = df.getValueAt(a, 1).toString();
                String quantity = df.getValueAt(a, 2).toString();
                String price = df.getValueAt(a, 3).toString();

                //String totalPrice =price = price * quantity;
                printScreen.setText(printScreen.getText() + "  " + name + "\t" + quantity + "\t" + "R " + price + "\n");
            }

            printScreen.setText(printScreen.getText() + "--------------------------------------------------------------\n");
            printScreen.setText(printScreen.getText() + "Sub Total : " + "\t\tR " + total.getText() + "\n");
            printScreen.setText(printScreen.getText() + "Cash  :" + "\t\tR " + cash.getText() + "\n");
            printScreen.setText(printScreen.getText() + "Change :" + "\t\tR " + change.getText() + "\n");
            printScreen.setText(printScreen.getText() + "--------------------------------------------------------------");
            printScreen.setText(printScreen.getText() + "\n          Cashier: #Codebreakers " + formattedDate + "\n");
            printScreen.setText(printScreen.getText() + "**************************************************************");
            printScreen.setText(printScreen.getText() + "\n          Thanks For Shopping With Us...!!\n");
            printScreen.setText(printScreen.getText() + "**************************************************************");

            printScreen.print(); //print

        } catch (Exception e) {
        }
    }

    private void jButton12ActionPerformed() {

    }//GEN-LAST:event_btnPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Desktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Desktop().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private java.awt.Button btnPay;
    private java.awt.Button btnPrint;
    private java.awt.TextField cash;
    private java.awt.Label change;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl10;
    private javax.swing.JLabel lbl11;
    private javax.swing.JLabel lbl12;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lbl9;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblA1;
    private javax.swing.JLabel lblA10;
    private javax.swing.JLabel lblA11;
    private javax.swing.JLabel lblA2;
    private javax.swing.JLabel lblA3;
    private javax.swing.JLabel lblA4;
    private javax.swing.JLabel lblA5;
    private javax.swing.JLabel lblA6;
    private javax.swing.JLabel lblA7;
    private javax.swing.JLabel lblA8;
    private javax.swing.JLabel lblA9;
    private javax.swing.JTextArea printScreen;
    private java.awt.Label total;
    // End of variables declaration//GEN-END:variables
}
