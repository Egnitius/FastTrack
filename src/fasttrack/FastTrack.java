/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fasttrack;

import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Paledi.Egnitius
 */
public class FastTrack extends javax.swing.JFrame {

    Connection conn = null;

    /**
     * Creates new form FastTrack
     * @param connection
     */
    public FastTrack(Connection connection) {
        initComponents();

        this.conn = connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String user = "root";
            String pword = "12345";

            conn = DriverManager.getConnection(url, user, pword);
        } catch (SQLException ex) {
            System.out.println("Error connecting to the database: " + ex.getMessage());
            // You can display an error message dialog here using JOptionPane.showMessageDialog or log the error.
        } catch (ClassNotFoundException ex) {
            System.out.println("Database driver not found: " + ex.getMessage());
            // You can display an error message dialog here using JOptionPane.showMessageDialog or log the error.
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        txtEmployeeId = new java.awt.TextField();
        label1 = new java.awt.Label();
        jPin = new javax.swing.JPasswordField();
        btnLogin = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FastTrack");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        label2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(102, 102, 102));
        label2.setText("Employee ID");

        txtEmployeeId.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        txtEmployeeId.setForeground(new java.awt.Color(102, 102, 102));

        label1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(102, 102, 102));
        label1.setText("Pin");

        jPin.setBackground(new java.awt.Color(255, 255, 255));
        jPin.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jPin.setForeground(new java.awt.Color(102, 102, 102));

        btnLogin.setBackground(new java.awt.Color(0, 102, 102));
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setLabel("Login");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("LOGIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FastTrack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Connection connection = null;
            FastTrack fast = new FastTrack(connection);
            fast.setVisible(true);

            // Event handling for the "Login" button
            fast.btnLogin.addActionListener((ActionEvent e) -> {
                // Get the entered employee ID and PIN
                String employeeID = fast.txtEmployeeId.getText();
                String employeePass = new String(fast.jPin.getPassword());
                // Perform login authentication logic
                if (authenticateUser(fast.conn, employeeID, employeePass)) {
                    // Successful login
                    System.out.println("Login successful!");

                    // Store the entered employeeID in the class-level variable
                    employeeId = employeeID;

                    // Determine the user's role based on the employeeID (you need to implement this logic)
                    userRole = FastTrack.determineUserRole(employeeID);

                    // Open the appropriate frame based on the user's role
                    if ("cashier".equals(userRole)) {
                        Desktop cashierFrame = new Desktop();
                        cashierFrame.setVisible(true);
                    } else if ("manager".equals(userRole)) {
                        admin managerFrame = new admin();
                        managerFrame.setVisible(true);
                    }
                    fast.dispose();
                } else {
                    // Failed login
                    System.out.println("Login failed!");
                    // TODO: Add code to display an error message or perform other actions
                }

            });
        });
    }

    private static boolean authenticateUser(Connection conn, String employeeID, String employeePass) {
        // TODO: Implement your authentication logic here
        // Example: Check the employee ID and PIN against a database or predefined values

        // Create a database connection and query the employee table
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isAuthenticated = false;

        try {
            // Prepare the SQL statement to query the employee table
            String query = "SELECT * FROM tblemployees WHERE EmployeeID = ? AND employeePass = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, employeeID);
            stmt.setString(2, employeePass);

            // Execute the query
            rs = stmt.executeQuery();

            // Check if a row is returned
            if (rs.next()) {
                // Authentication successful
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        
        }

        return isAuthenticated;
    }

    private static String employeeId;
    private static String userRole;

    private static String determineUserRole(String employeeID) {
        // TODO: Implement the logic to determine the user's role based on the employeeID
        // Example: You can query the database to get the role of the employee
        // For demonstration purposes, we'll use a simple approach:
        if ("admin".equals(employeeID)) { // Assuming "12345" is the employeeID of the manager
            return "manager";
        } else {
            return "cashier";
        }
    }

    // Getter method for employeeId
    public String getEmployeeId() {
        return employeeId;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPin;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField txtEmployeeId;
    // End of variables declaration//GEN-END:variables

}
