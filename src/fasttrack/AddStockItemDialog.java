/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fasttrack;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Paledi.Egnitius
 */
public class AddStockItemDialog extends JDialog {
    private JTextField itemIDTextField;
    private JTextField itemNameTextField;
    private JTextField quantityTextField;
    private JTextField priceTextField;

    public AddStockItemDialog(JFrame parentFrame) {
        super(parentFrame, "Add New Stock Item", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create and configure the dialog components
        JLabel itemIDLabel = new JLabel("Item ID:");
        JLabel itemNameLabel = new JLabel("Item Name:");
        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel priceLabel = new JLabel("Price:");

        itemIDTextField = new JTextField(10);
        itemNameTextField = new JTextField(20);
        quantityTextField = new JTextField(5);
        priceTextField = new JTextField(10);

        JButton addButton = new JButton("Add");
        addButton.addActionListener((ActionEvent e) -> {
            addNewItem();
        });

        // Layout the components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.add(itemIDLabel);
        inputPanel.add(itemIDTextField);
        inputPanel.add(itemNameLabel);
        inputPanel.add(itemNameTextField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityTextField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceTextField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parentFrame);
        setVisible(true);
    }

    private void addNewItem() {
        // Get the input data from the dialog
        int itemID = Integer.parseInt(itemIDTextField.getText());
        String item = itemNameTextField.getText();
        int quantity = Integer.parseInt(quantityTextField.getText());
        double price = Double.parseDouble(priceTextField.getText());
        double totalPrice = quantity * price;

        // Insert the new row into the database
        try {            
            String url = "jdbc:mysql://localhost:3306/fasttrack";
            String userid = "root";
            String password = "12345";
            String insertSql = "INSERT INTO stock (itemID, item, quantity, price) VALUES (?, ?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, userid, password);
                 PreparedStatement pstmt = connection.prepareStatement(insertSql)) {

                pstmt.setInt(1, itemID);
                pstmt.setString(2, item);
                pstmt.setInt(3, quantity);
                pstmt.setDouble(4, price);

                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.err.println("Error while inserting new row into the database: " + e.getMessage());
                e.printStackTrace();
            }
            

            // Notify the user that the item was added
            JOptionPane.showMessageDialog(this, "Item added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Close the dialog after the item is added
            dispose();
        } catch (NumberFormatException e) {
            // Handle the case where the user entered invalid input (e.g., non-numeric values)
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}