/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fasttrack;

/**
 *
 * @author Paledi.Egnitius
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;

public class admin extends javax.swing.JFrame {

    Connection conn;

    public admin() throws ClassNotFoundException {
        initComponents();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String user = "root";
            String pword = "12345";

            conn = DriverManager.getConnection(url, user, pword);
        } catch (SQLException ex) {
            System.out.println("Error" + ex.getMessage());
        }

        // Inside the method where you create the JTable
// Inside the method where you create the JTable
        DefaultCellEditor cellEditor = new DefaultCellEditor(new JTextField());
        tblStock.getColumnModel().getColumn(1).setCellEditor(cellEditor); // Column "item"
        tblStock.getColumnModel().getColumn(2).setCellEditor(cellEditor); // Column "Qty"
        tblStock.getColumnModel().getColumn(3).setCellEditor(cellEditor); // Column "Price"
        tblStock.getColumnModel().getColumn(4).setCellEditor(cellEditor); // Column "TotalPrice"
        tblStock.setCellSelectionEnabled(true); // Allow selecting a single cell

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ItemID", "item", "Qty", "Price", "TotalPrice"
            }
        ));
        jScrollPane1.setViewportView(tblStock);

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
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

    public class StockTableModel extends AbstractTableModel {

        private final String[] columnNames = {"itemID", "item", "Qty", "Price", "TotalPrice"};
        private final List<Stock> data;

        public StockTableModel(List<Stock> data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
            Stock stock = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    stock.setItemID((int) value);
                    break;
                case 1:
                    stock.setItem((String) value);
                    break;
                case 2:
                    stock.setQuantity((int) value);
                    break;
                case 3:
                    stock.setPrice((double) value);
                    break;
                case 4:
                    stock.setTotalPrice((double) value);
                    break;
                // Handle other columns if needed
            }

            // Update the database with the new value
            updateDatabase(stock);

            // Notify the table that data has changed
            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Stock stock = data.get(rowIndex);

            return switch (columnIndex) {
                case 0 ->
                    stock.getItemID();
                case 1 ->
                    stock.getItem();
                case 2 ->
                    stock.getQuantity();
                case 3 ->
                    stock.getPrice();
                case 4 ->
                    stock.getTotalPrice();
                default ->
                    null;
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            // Return the class types of the columns for proper cell rendering/editing
            return switch (columnIndex) {
                case 0 ->
                    Integer.class;
                case 1, 2 ->
                    String.class;
                case 3, 4 ->
                    Double.class;
                default ->
                    Object.class;
            };
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            // Set the cells in columns 1, 2, 3, and 4 as editable
            return columnIndex >= 1 && columnIndex <= 4;
        }

        // Update the database with the modified stock data
        private void updateDatabase(Stock stock) {
            try {
                String sql = "UPDATE stock SET item = ?, quantity = ?, price = ?, TotalPrice = ? WHERE itemID = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                // Set the values for the prepared statement
                pstmt.setString(1, stock.getItem());
                pstmt.setInt(2, stock.getQuantity());
                pstmt.setDouble(3, stock.getPrice());
                pstmt.setDouble(4, stock.getTotalPrice());
                pstmt.setInt(5, stock.getItemID());

                // Execute the update statement
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Stock data updated successfully.");
                } else {
                    System.out.println("No rows updated.");
                }

                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public void clearData() {
            data.clear();
            fireTableDataChanged();
        }
    }


    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        List<Stock> stock = new ArrayList<>();

        try {
            String sql = "SELECT * FROM stock";
            PreparedStatement pet = conn.prepareStatement(sql);
            ResultSet rs = pet.executeQuery();

            while (rs.next()) {
                int itemID = rs.getInt("itemID");
                String item = rs.getString("item");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                double totalPrice = rs.getDouble("TotalPrice");

                Stock stocks = new Stock(itemID, price, quantity, item, totalPrice);
                stock.add(stocks);
            }

            StockTableModel model = new StockTableModel(stock);
            tblStock.setModel(model);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        StockTableModel model = (StockTableModel) tblStock.getModel();
        model.clearData();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new admin().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables
}
