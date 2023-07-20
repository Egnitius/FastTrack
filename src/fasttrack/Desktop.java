/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fasttrack;

import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
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
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
        displayImageOnButton(jButton2, 4);
        displayImageOnButton(jButton6, 5);
        displayImageOnButton(jButton7, 6);
        displayImageOnButton(jButton8, 7);
        displayImageOnButton(jButton9, 8);
        displayImageOnButton(jButton10, 9);
        displayImageOnButton(jButton11, 10);
        displayImageOnButton(jButton12, 11);
        displayImageOnButton(jButton13, 12);

        updateTotalPrice();

        updateQuantityLabel(1, lbl1);
        updateQuantityLabel(3, lbl3);
        updateQuantityLabel(2, lbl2);
        updateQuantityLabel(4, lbl4);
        updateQuantityLabel(11, lbl12);
        updateQuantityLabel(6, lbl5);
        updateQuantityLabel(5, lbl6);
        updateQuantityLabel(7, lbl8);
        updateQuantityLabel(8, lbl7);
        updateQuantityLabel(9, lbl10);
        updateQuantityLabel(10, lbl9);
        updateQuantityLabel(12, lbl11);
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

    private void updateTotalPrice() {
        try {
            String query = "SELECT itemID, price, quantity FROM stock";
            PreparedStatement pet = conn.prepareStatement(query);
            ResultSet resultSet = pet.executeQuery();

            while (resultSet.next()) {
                int itemID = resultSet.getInt("itemID");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                double totalPrice = quantity * price;

                // Update the TotalPrice column in the stock table
                String updateQuery = "UPDATE stock SET TotalPrice = ? WHERE itemID = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setDouble(1, totalPrice);
                updateStmt.setInt(2, itemID);
                updateStmt.executeUpdate();
            }

            System.out.println("TotalPrice updated successfully.");
        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
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
        jbtnExit = new javax.swing.JButton();
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
        btnDelete = new javax.swing.JButton();
        jbtnClear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtBarcode = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        printScreen = new javax.swing.JTextPane();
        jPanel5 = new javax.swing.JPanel();
        jbtn1 = new javax.swing.JButton();
        jbtn7 = new javax.swing.JButton();
        jbtn6 = new javax.swing.JButton();
        jbtn2 = new javax.swing.JButton();
        jbtn8 = new javax.swing.JButton();
        jbtn3 = new javax.swing.JButton();
        jbtn4 = new javax.swing.JButton();
        jbtn9 = new javax.swing.JButton();
        jbtn5 = new javax.swing.JButton();
        jbtnPeriod = new javax.swing.JButton();
        jbtnC = new javax.swing.JButton();
        jbtn0 = new javax.swing.JButton();

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

        jbtnExit.setBackground(new java.awt.Color(0, 102, 102));
        jbtnExit.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnExit.setForeground(new java.awt.Color(255, 255, 255));
        jbtnExit.setText("Exit");
        jbtnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jbtnClear.setBackground(new java.awt.Color(0, 102, 102));
        jbtnClear.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnClear.setForeground(new java.awt.Color(255, 255, 255));
        jbtnClear.setText("Clear");
        jbtnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });

        jtxtBarcode.setColumns(20);
        jtxtBarcode.setFont(new java.awt.Font("Code39", 0, 14)); // NOI18N
        jtxtBarcode.setLineWrap(true);
        jtxtBarcode.setRows(5);
        jScrollPane3.setViewportView(jtxtBarcode);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnClear))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        jScrollPane4.setViewportView(printScreen);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jbtn1.setBackground(new java.awt.Color(0, 102, 102));
        jbtn1.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn1.setForeground(new java.awt.Color(255, 255, 255));
        jbtn1.setText("1");
        jbtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });

        jbtn7.setBackground(new java.awt.Color(0, 102, 102));
        jbtn7.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn7.setForeground(new java.awt.Color(255, 255, 255));
        jbtn7.setText("7");
        jbtn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn7ActionPerformed(evt);
            }
        });

        jbtn6.setBackground(new java.awt.Color(0, 102, 102));
        jbtn6.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn6.setForeground(new java.awt.Color(255, 255, 255));
        jbtn6.setText("6");
        jbtn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn6ActionPerformed(evt);
            }
        });

        jbtn2.setBackground(new java.awt.Color(0, 102, 102));
        jbtn2.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn2.setForeground(new java.awt.Color(255, 255, 255));
        jbtn2.setText("2");
        jbtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn2ActionPerformed(evt);
            }
        });

        jbtn8.setBackground(new java.awt.Color(0, 102, 102));
        jbtn8.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn8.setForeground(new java.awt.Color(255, 255, 255));
        jbtn8.setText("8");
        jbtn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8ActionPerformed(evt);
            }
        });

        jbtn3.setBackground(new java.awt.Color(0, 102, 102));
        jbtn3.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn3.setForeground(new java.awt.Color(255, 255, 255));
        jbtn3.setText("3");
        jbtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });

        jbtn4.setBackground(new java.awt.Color(0, 102, 102));
        jbtn4.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn4.setForeground(new java.awt.Color(255, 255, 255));
        jbtn4.setText("4");
        jbtn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn4ActionPerformed(evt);
            }
        });

        jbtn9.setBackground(new java.awt.Color(0, 102, 102));
        jbtn9.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn9.setForeground(new java.awt.Color(255, 255, 255));
        jbtn9.setText("9");
        jbtn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn9ActionPerformed(evt);
            }
        });

        jbtn5.setBackground(new java.awt.Color(0, 102, 102));
        jbtn5.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn5.setForeground(new java.awt.Color(255, 255, 255));
        jbtn5.setText("5");
        jbtn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn5ActionPerformed(evt);
            }
        });

        jbtnPeriod.setBackground(new java.awt.Color(0, 102, 102));
        jbtnPeriod.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtnPeriod.setForeground(new java.awt.Color(255, 255, 255));
        jbtnPeriod.setText(".");
        jbtnPeriod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPeriodActionPerformed(evt);
            }
        });

        jbtnC.setBackground(new java.awt.Color(0, 102, 102));
        jbtnC.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtnC.setForeground(new java.awt.Color(255, 255, 255));
        jbtnC.setText("C");
        jbtnC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCActionPerformed(evt);
            }
        });

        jbtn0.setBackground(new java.awt.Color(0, 102, 102));
        jbtn0.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jbtn0.setForeground(new java.awt.Color(255, 255, 255));
        jbtn0.setText("0");
        jbtn0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnPeriod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Apples with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Apples *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Pears with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Pears *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Bananas with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Bananas *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Watermelon with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Watermelon *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Potatoes with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Potatoes *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Grapes with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Grapes *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Mangos with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Mangos *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Cabbage with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Cabbage *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Carrots with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Carrots *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Beetroot with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Beetroot *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Pumpkin with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Pumpkin *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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

        if (newQuantity <= 0) {
            // Show a pop-up message informing the cashier that the item needs to be restocked
            JOptionPane.showMessageDialog(this, "Onions with ID " + itemID + " needs to be restocked!", "Restock Item", JOptionPane.INFORMATION_MESSAGE);
        }

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

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        String Barcode;
        Barcode = String.format("Item Is Onions *%s*", formattedDate);
        jtxtBarcode.setText(Barcode);
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
        updateTotalPrice();
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = currentDate.format(formatter);

            String cashierName = "";
            // Get the logged-in employee ID
            FastTrack fasttrack = new FastTrack();
            String employeeId = fasttrack.getEmployeeId();
            System.out.println("Employee ID: " + employeeId);

            try {
                String query = "SELECT employeeName FROM tblemployees WHERE employeeID = ?";
                try (PreparedStatement stmt = conn.prepareStatement(query)) {
                    stmt.setString(1, employeeId);
                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            cashierName = rs.getString("employeeName");
                            System.out.println("Cashier Name: " + cashierName);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // bill print
            // Style the text in JTextPane
            StyledDocument doc = printScreen.getStyledDocument();

            // Define styles
            javax.swing.text.Style centerStyle = doc.addStyle("center", null);
            StyleConstants.setAlignment(centerStyle, StyleConstants.ALIGN_CENTER);
            StyleConstants.setFontSize(centerStyle, 16);

            javax.swing.text.Style headingStyle = doc.addStyle("heading", null);
            StyleConstants.setBold(headingStyle, true);
            StyleConstants.setFontSize(headingStyle, 18);

            javax.swing.text.Style underlineStyle = doc.addStyle("underline", null);
            StyleConstants.setUnderline(underlineStyle, true);

            javax.swing.text.Style boldStyle = doc.addStyle("bold", null);
            StyleConstants.setBold(boldStyle, true);

            try {
                // Clear the existing text in the JTextPane
                doc.remove(0, doc.getLength());
            } catch (BadLocationException ex) {
                Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Add styled text to the JTextPane
            doc.insertString(doc.getLength(), "FastTrack\n", centerStyle);
            doc.insertString(doc.getLength(), "19AM\n", centerStyle);
            doc.insertString(doc.getLength(), "BraamFontain\n", centerStyle);
            doc.insertString(doc.getLength(), "010 1111 234\n", centerStyle);
            doc.insertString(doc.getLength(), "--------------------------------------------------------------\n", null);
            doc.insertString(doc.getLength(), "Item\tQuantity\tPrice\n", boldStyle);
            doc.insertString(doc.getLength(), "--------------------------------------------------------------\n", null);
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            // Getting table product details
            for (int a = 0; a < jTable1.getRowCount(); a++) {
                String name = df.getValueAt(a, 1).toString();
                String quantity = df.getValueAt(a, 2).toString();
                String price = df.getValueAt(a, 3).toString();

                doc.insertString(doc.getLength(), name + "\t" + quantity + "\tR " + price + "\n", null);
            }
            doc.insertString(doc.getLength(), "--------------------------------------------------------------\n", null);
            doc.insertString(doc.getLength(), "Sub Total:\t\tR " + total.getText() + "\n", null);
            doc.insertString(doc.getLength(), "Cash:\t\tR " + cash.getText() + "\n", null);
            doc.insertString(doc.getLength(), "Change:\t\tR " + change.getText() + "\n", null);
            doc.insertString(doc.getLength(), "--------------------------------------------------------------\n", null);
            doc.insertString(doc.getLength(), "Cashier: ", boldStyle);
            doc.insertString(doc.getLength(), cashierName + "\tDate: ", null);
            doc.insertString(doc.getLength(), formattedDate + "\n", underlineStyle);
            doc.insertString(doc.getLength(), "**************************************************\n", null);
            doc.insertString(doc.getLength(), "Thanks For Shopping With Us...!!\n", centerStyle);
            doc.insertString(doc.getLength(), "**************************************************\n", null);

            // Print the content
            try {
                printScreen.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        } catch (BadLocationException ex) {
            Logger.getLogger(Desktop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jButton12ActionPerformed() {

    }//GEN-LAST:event_btnPrintActionPerformed

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        total.setText("00");
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn1.getText());
        } else {
            enterNumber = cash.getText() + jbtn1.getText();
            cash.setText(enterNumber);
        }

    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn2.getText());
        } else {
            enterNumber = cash.getText() + jbtn2.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn3.getText());
        } else {
            enterNumber = cash.getText() + jbtn3.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn4.getText());
        } else {
            enterNumber = cash.getText() + jbtn4.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn5.getText());
        } else {
            enterNumber = cash.getText() + jbtn5.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn6.getText());
        } else {
            enterNumber = cash.getText() + jbtn6.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn7.getText());
        } else {
            enterNumber = cash.getText() + jbtn7.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn8.getText());
        } else {
            enterNumber = cash.getText() + jbtn8.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn9.getText());
        } else {
            enterNumber = cash.getText() + jbtn9.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void jbtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn0ActionPerformed

        String enterNumber = cash.getText();

        if ("".equals(enterNumber)) {
            cash.setText(jbtn0.getText());
        } else {
            enterNumber = cash.getText() + jbtn0.getText();
            cash.setText(enterNumber);
        }
    }//GEN-LAST:event_jbtn0ActionPerformed

    private void jbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCActionPerformed

        cash.setText("");
        change.setText("00");
    }//GEN-LAST:event_jbtnCActionPerformed

    private void jbtnPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPeriodActionPerformed

        if (!cash.getText().contains(".")) {
            cash.setText(cash.getText() + jbtnPeriod.getText());
        }
    }//GEN-LAST:event_jbtnPeriodActionPerformed

    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed

        // Show a pop-up message
        int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?", "FastTrack",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            // Redirect to the login page
            FastTrack loginFrame = new FastTrack();
            loginFrame.setVisible(true);
            this.dispose(); // Close the current frame (FastTrack frame)
        }
    }//GEN-LAST:event_jbtnExitActionPerformed

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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtn0;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JButton jbtnC;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnPeriod;
    private javax.swing.JTextArea jtxtBarcode;
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
    private javax.swing.JTextPane printScreen;
    private java.awt.Label total;
    // End of variables declaration//GEN-END:variables
}
