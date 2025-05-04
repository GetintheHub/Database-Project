import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDashboard {

    public static void showDashboard(JFrame frame) {
        //Main Dashboard
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        JTabbedPane tabbedPane = new JTabbedPane();

        //Create the panels for each section
        JPanel addRentalPanel = createAddRentalPanel();
        JPanel viewRentalsPanel = createViewRentalsPanel();
        JPanel manageUsersPanel = createManageUsersPanel();

        tabbedPane.addTab("Add Rental", addRentalPanel);
        tabbedPane.addTab("View Rentals", viewRentalsPanel);
        tabbedPane.addTab("Manage Users", manageUsersPanel);

        frame.add(tabbedPane);

        frame.setVisible(true);
    }

    private static JPanel createAddRentalPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel itemNameLabel = new JLabel("Item Name:");
        JTextField itemNameField = new JTextField(20);

        JLabel startDateLabel = new JLabel("Rental Start Date:");
        JTextField startDateField = new JTextField(20);

        JLabel endDateLabel = new JLabel("Rental End Date:");
        JTextField endDateField = new JTextField(20);

        JButton submitButton = new JButton("Submit Rental");
        submitButton.setBackground(new Color(0, 123, 255)); 
        submitButton.setForeground(Color.WHITE); 

        panel.add(itemNameLabel);
        panel.add(itemNameField);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(endDateLabel);
        panel.add(endDateField);
        panel.add(submitButton);

        //ActionListener for Submit Rental Button
        submitButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();


            JOptionPane.showMessageDialog(panel, "Rental Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }

    private static JPanel createViewRentalsPanel() {
        JPanel panel = new JPanel();
        JButton viewRentalsButton = new JButton("Show All Rentals");

        viewRentalsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "Rental Report goes here", "Rental Report", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(viewRentalsButton);
        return panel;
    }

    private static JPanel createManageUsersPanel() {
        // Manage Users Panel
        JPanel panel = new JPanel();
        JButton addUserButton = new JButton("Add User");
        JButton deleteUserButton = new JButton("Delete User");
        JButton viewUsersButton = new JButton("View Users");

        addUserButton.addActionListener(e -> {
            String newUser = JOptionPane.showInputDialog(panel, "Enter username:");
            JOptionPane.showMessageDialog(panel, "User Added: " + newUser, "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        deleteUserButton.addActionListener(e -> {
            String userToDelete = JOptionPane.showInputDialog(panel, "Enter username to delete:");
            JOptionPane.showMessageDialog(panel, "User Deleted: " + userToDelete, "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        viewUsersButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel, "View Users functionality", "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(addUserButton);
        panel.add(deleteUserButton);
        panel.add(viewUsersButton);
        return panel;
    }
}
