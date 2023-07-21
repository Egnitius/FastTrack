/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fasttrack;

import java.awt.Frame;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Capaciti
 */
public class admin extends javax.swing.JFrame {

    private JTable table;

    private void setTableModel(DefaultTableModel tableModel) {
        jTable1.setModel(tableModel);
    }

    public admin() {
        initComponents();
        populateTable();
    }

    private void populateTable() {
        try {
            // Code to populate jTable1 from the database
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/fasttrack";
        String userid = "root";
        String password = "12345";
        String sql = "SELECT * FROM stock";

        try (Connection connection = DriverManager.getConnection(url, userid, password); Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            // Get column names excluding the column you want to exclude (for example, "itemID")
            ArrayList<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= columns; i++) {
                String columnName = md.getColumnName(i);
                if (!columnName.equals("productImg")) {
                    columnNames.add(columnName);
                }
            }

            // Get row data excluding the column you want to exclude
            ArrayList<ArrayList<Object>> data = new ArrayList<>();
            while (rs.next()) {
                ArrayList<Object> row = new ArrayList<>();
                for (int i = 1; i <= columns; i++) {
                    String columnName = md.getColumnName(i);
                    if (!columnName.equals("productImg")) {
                        row.add(rs.getObject(i));
                    }
                }
                data.add(row);
            }

            // Convert ArrayList<ArrayList<Object>> to a 2D array
            Object[][] dataArray = new Object[data.size()][];
            for (int i = 0; i < data.size(); i++) {
                ArrayList<Object> row = data.get(i);
                dataArray[i] = row.toArray(Object[]::new);
            }

            // Create a DefaultTableModel and set the data and column names
            DefaultTableModel tableModel = new DefaultTableModel(dataArray, columnNames.toArray());

            // Set the table model for jTable1
            jTable1.setModel(tableModel);

            helperFunction();
            System.out.println("Table populated successfully.");

        } catch (SQLException e) {
            System.err.println("Error while populating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void refreshTableData() {
        // Simply call the method to populate the table again
        populateTable();
    }

    public void removeSelectedRowFromTable() {
        // Get the selected row index
        int selectedRowIndex = jTable1.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex >= 0) {
            // Get the table's model
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            int columnIndex = 0;

            // Get the value of the first column (assuming it holds the primary key or identifier for the row)
            Object selectedItem = model.getValueAt(selectedRowIndex, columnIndex); // columnIndex for the item column

            // Remove the row from the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String userid = "root";
            String password = "12345";
            String deleteSql = "DELETE FROM stock WHERE itemID = ?"; // Use the correct column name for the primary key

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(deleteSql)) {

                // Set the value for the first parameter (itemID column) in the prepared statement
                if (selectedItem instanceof Integer integer) {
                    pstmt.setInt(1, integer);
                } else {
                    // Handle other data types if needed
                    // For example, if the itemID column is of type Long, you can use:
                    // pstmt.setLong(1, (Long) selectedItem);
                }

                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error while deleting row from the database: " + e.getMessage());
                e.printStackTrace();
            }

            // Remove the selected row from the model
            model.removeRow(selectedRowIndex);
        } else {
            // Display a message if no row is selected
            JOptionPane.showMessageDialog(null, "Please select a row to remove.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        products = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        qtyinput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        unitpriceinput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        addinenvtorybtn = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtbnAdd = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblTotalQty = new javax.swing.JLabel();
        lblTotalQty1 = new javax.swing.JLabel();
        jbtnRegEm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Product : ");

        products.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apples", "Bananas", "Pears", "Watermelon", "Mangos", "Grapes", "Cabbage", "Carrots", "Beetroot", "Potatoes", "Onions" }));
        products.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Qty :");

        qtyinput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        qtyinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyinputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unit Price :");

        unitpriceinput.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        unitpriceinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitpriceinputActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fast Track Inventory");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(products, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(qtyinput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitpriceinput, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(qtyinput, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(unitpriceinput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        addinenvtorybtn.setBackground(new java.awt.Color(0, 102, 102));
        addinenvtorybtn.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        addinenvtorybtn.setForeground(new java.awt.Color(255, 255, 255));
        addinenvtorybtn.setText("Update Inventory");
        addinenvtorybtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addinenvtorybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addinenvtorybtnActionPerformed(evt);
            }
        });

        remove.setBackground(new java.awt.Color(0, 102, 102));
        remove.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item", "Barcode ", "Qty", "Unit Price", "Total Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jtbnAdd.setBackground(new java.awt.Color(0, 102, 102));
        jtbnAdd.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jtbnAdd.setForeground(new java.awt.Color(255, 255, 255));
        jtbnAdd.setText("Add");
        jtbnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(remove)
                    .addComponent(addinenvtorybtn)
                    .addComponent(jtbnAdd))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(addinenvtorybtn)
                        .addGap(39, 39, 39)
                        .addComponent(remove)
                        .addGap(42, 42, 42)
                        .addComponent(jtbnAdd))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Qty :");

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Amount :");

        btnExit.setBackground(new java.awt.Color(0, 102, 102));
        btnExit.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblTotalQty.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblTotalQty.setText("00");

        lblTotalQty1.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        lblTotalQty1.setText("00");

        jbtnRegEm.setBackground(new java.awt.Color(0, 102, 102));
        jbtnRegEm.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jbtnRegEm.setForeground(new java.awt.Color(255, 255, 255));
        jbtnRegEm.setText("Register Employee");
        jbtnRegEm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnRegEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRegEmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblTotalQty)
                .addGap(113, 113, 113)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblTotalQty1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnRegEm)
                .addGap(18, 18, 18)
                .addComponent(btnExit)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(btnExit)
                    .addComponent(lblTotalQty)
                    .addComponent(lblTotalQty1)
                    .addComponent(jbtnRegEm))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void qtyinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyinputActionPerformed


    }//GEN-LAST:event_qtyinputActionPerformed

    private void unitpriceinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitpriceinputActionPerformed

    }//GEN-LAST:event_unitpriceinputActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        removeSelectedRowFromTable();
    }//GEN-LAST:event_removeActionPerformed

    private void addinenvtorybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addinenvtorybtnActionPerformed

        //int enterQty = Integer.parseInt(qtyinput.getText());
        //float enterPrice = Float.parseFloat(unitpriceinput.getText());
        //String selectedItem = (String) products.getSelectedItem();
        //float totPrice = enterQty * enterPrice;
        if (!unitpriceinput.getText().isEmpty() && !qtyinput.getText().isEmpty()) {

            int enterQty = Integer.parseInt(qtyinput.getText());
            float enterPrice = Float.parseFloat(unitpriceinput.getText());
            String selectedItem = (String) products.getSelectedItem();
            float totPrice = enterQty * enterPrice;

            // Update the quantity, price, and total price in the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String userid = "root";
            String password = "12345";
            String updateSql = "UPDATE stock SET quantity = quantity + ?, price = ?, TotalPrice = TotalPrice + ? WHERE item = ?";

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(updateSql)) {

                pstmt.setInt(1, enterQty);
                pstmt.setFloat(2, enterPrice);
                pstmt.setFloat(3, totPrice);
                pstmt.setString(4, selectedItem);
                pstmt.executeUpdate();

                // Show success message
                JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                refreshTableData();

            } catch (SQLException e) {
                System.err.println("Error while updating quantity in the database: " + e.getMessage());
                e.printStackTrace();
            }

        } else if (!qtyinput.getText().isEmpty()) {
            int enterQty = Integer.parseInt(qtyinput.getText());
            String selectedItem = (String) products.getSelectedItem();

            // Variables to store the fetched quantity and price from the database
            int currentQuantity = 0;
            float currentPrice = 0.0f;

            // Fetch the current quantity and price from the database
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String userid = "root";
            String password = "12345";
            String selectSql = "SELECT quantity, price FROM stock WHERE item = ?";

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(selectSql)) {

                pstmt.setString(1, selectedItem);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    currentQuantity = rs.getInt("quantity");
                    currentPrice = rs.getFloat("price");
                }

                rs.close();

            } catch (SQLException e) {
                System.err.println("Error while fetching quantity and price from the database: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println(currentQuantity);
            // Show success message
            JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Calculate the total price based on the fetched price and entered quantity
            float totPrice = currentPrice * (enterQty + currentQuantity);

            // Update the quantity and total price in the database
            String updateSql = "UPDATE stock SET quantity = quantity + ?, TotalPrice = ? WHERE item = ?";

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(updateSql)) {

                pstmt.setInt(1, enterQty);
                pstmt.setFloat(2, totPrice);
                pstmt.setString(3, selectedItem);
                pstmt.executeUpdate();

                refreshTableData();

            } catch (SQLException e) {
                System.err.println("Error while updating quantity in the database: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (!unitpriceinput.getText().isEmpty()) {

            float enterPrice = Float.parseFloat(unitpriceinput.getText());
            String selectedItem = (String) products.getSelectedItem();
            float totPrice = 0f;

            // Fetch the current quantity from the database
            int currentQuantity = 0;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String userid = "root";
            String password = "12345";
            String selectSql = "SELECT quantity FROM stock WHERE item = ?";

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(selectSql)) {

                pstmt.setString(1, selectedItem);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    currentQuantity = rs.getInt("quantity");
                }

                rs.close();

            } catch (SQLException e) {
                System.err.println("Error while fetching quantity from the database: " + e.getMessage());
                e.printStackTrace();
            }

            // Update the quantity, price, and total price in the database
            String updateSql = "UPDATE stock SET  price = ?, TotalPrice = ? WHERE item = ?";

            try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(updateSql)) {

                pstmt.setFloat(1, enterPrice);
                totPrice = currentQuantity * enterPrice;
                pstmt.setFloat(2, totPrice);
                pstmt.setString(3, selectedItem);
                pstmt.executeUpdate();
                
                // Show success message
                JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                refreshTableData();

            } catch (SQLException e) {
                System.err.println("Error while updating quantity in the database: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            // Show a validation message using JOptionPane.showMessageDialog
            JOptionPane.showMessageDialog(this, "Please enter quantity or unit price.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addinenvtorybtnActionPerformed

    public void helperFunction() {
        // Fetch the sum of quantity from the database
        int totalQuantity = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        String url = "jdbc:mysql://localhost:3306/fasttrack";
        String userid = "root";
        String password = "12345";
        String selectSql = "SELECT SUM(quantity) AS total FROM stock";

        try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(selectSql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                totalQuantity = rs.getInt("total");
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error while fetching total quantity from the database: " + e.getMessage());
            e.printStackTrace();
        }

        // Update the JTextField with the sum of quantity
        lblTotalQty.setText(String.valueOf(totalQuantity));
        // Fetch the sum of TotalPrice from the database
        float totalPriceSum = 0.0f;

        String selectSql2 = "SELECT SUM(TotalPrice) AS total FROM stock";

        try (Connection connection = DriverManager.getConnection(url, userid, password); PreparedStatement pstmt = connection.prepareStatement(selectSql2)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                totalPriceSum = rs.getFloat("total");
            }

            rs.close();

        } catch (SQLException e) {
            System.err.println("Error while fetching total TotalPrice from the database: " + e.getMessage());
            e.printStackTrace();
        }

        // Update the JTextField with the sum of TotalPrice
        lblTotalQty1.setText(String.valueOf(totalPriceSum));
    }
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // Show a pop-up message
        int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to exit?", "FastTrack",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {
            returnToLogin(); // Return to the login page
            this.dispose(); // Close the current frame (Desktop frame)
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void returnToLogin() {
        Connection conn = null;
        // Create a new instance of FastTrack using the existing connection
        FastTrack loginFrame = new FastTrack(conn);
        loginFrame.setVisible(true);
    }

    private void jtbnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnAddActionPerformed
        AddStockItemDialog addStock = new AddStockItemDialog(this);

        populateTable();
    }//GEN-LAST:event_jtbnAddActionPerformed

    private void productsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productsActionPerformed

    private void jbtnRegEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRegEmActionPerformed
        regEmplyee register = new regEmplyee();
        register.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jbtnRegEmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new admin().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addinenvtorybtn;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtnRegEm;
    private javax.swing.JButton jtbnAdd;
    private javax.swing.JLabel lblTotalQty;
    private javax.swing.JLabel lblTotalQty1;
    private javax.swing.JComboBox<String> products;
    private javax.swing.JTextField qtyinput;
    private javax.swing.JButton remove;
    private javax.swing.JTextField unitpriceinput;
    // End of variables declaration//GEN-END:variables
}
