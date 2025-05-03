import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainDashboard {

    public static void showDashboard(JFrame frame) {
        //Dashboard Setup
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

        //Top Navigation Bar Setup
        JPanel topNavPanel = new JPanel();
        topNavPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
        topNavPanel.setBackground(new Color(50, 50, 50));  
        topNavPanel.setPreferredSize(new Dimension(800, 60));

    
        JButton addRentalButton = new JButton("Add Rental");
        JButton manageUsersButton = new JButton("Manage Users");

        setButtonStyle(addRentalButton);
        setButtonStyle(manageUsersButton);

        topNavPanel.add(addRentalButton);
        topNavPanel.add(manageUsersButton);

        JPanel mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new CardLayout());  

        // Rental Page
        JPanel addRentalPanel = new JPanel();
        addRentalPanel.setLayout(new GridLayout(4, 2, 10, 10)); 

        JLabel itemNameLabel = new JLabel("Item Name:");
        JTextField itemNameField = new JTextField(20);

        JLabel startDateLabel = new JLabel("Rental Start Date:");
        JTextField startDateField = new JTextField(20);

        JLabel endDateLabel = new JLabel("Rental End Date:");
        JTextField endDateField = new JTextField(20);

        JButton submitRentalButton = new JButton("Submit Rental");
        submitRentalButton.setBackground(new Color(0, 123, 255)); 
        submitRentalButton.setForeground(Color.WHITE); 

        addRentalPanel.add(itemNameLabel);
        addRentalPanel.add(itemNameField);
        addRentalPanel.add(startDateLabel);
        addRentalPanel.add(startDateField);
        addRentalPanel.add(endDateLabel);
        addRentalPanel.add(endDateField);
        addRentalPanel.add(submitRentalButton);

        // ActionListener for Submit Rental
        submitRentalButton.addActionListener(e -> {
            // Get the input values from the form
            String itemName = itemNameField.getText();
            String startDate = startDateField.getText();
            String endDate = endDateField.getText();

            // Simulates adding rental to the database (placeholder)
            Rental rental = new Rental(itemName, startDate, endDate, "Electric Boogalo");

            // Add rental to placeholder for database
            DatabaseHelper.addRental(rental);

            JOptionPane.showMessageDialog(frame, "Rental Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // Manage Users Page
        JPanel manageUsersPanel = new JPanel();
        manageUsersPanel.setLayout(new GridLayout(4, 1, 10, 20));

        JButton addUserButton = new JButton("Add User");
        JButton deleteUserButton = new JButton("Delete User");
        JButton viewUsersButton = new JButton("View Users");

     
        setButtonStyle(addUserButton);
        setButtonStyle(deleteUserButton);
        setButtonStyle(viewUsersButton);

        manageUsersPanel.add(addUserButton);
        manageUsersPanel.add(deleteUserButton);
        manageUsersPanel.add(viewUsersButton);

        //ActionListener for Manage Users Buttons
        addUserButton.addActionListener(e -> {
            // Simulates adding a new user 
            String newUser = JOptionPane.showInputDialog(frame, "Enter username:");
            DatabaseHelper.validateUser(newUser, "dummyPassword"); // (Placeholder)
            JOptionPane.showMessageDialog(frame, "User Added: " + newUser, "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        deleteUserButton.addActionListener(e -> {
            // Simulates deleting a user (placeholder )
            String userToDelete = JOptionPane.showInputDialog(frame, "Enter username to delete:");
            JOptionPane.showMessageDialog(frame, "User Deleted: " + userToDelete, "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        viewUsersButton.addActionListener(e -> {
            // Simulates viewing users (placeholder )
            JOptionPane.showMessageDialog(frame, "View Users functionality", "Info", JOptionPane.INFORMATION_MESSAGE);
        });

       
        mainContentPanel.add(addRentalPanel, "Add Rental");
        mainContentPanel.add(manageUsersPanel, "Manage Users");

        // ActionListeners for Navigation Buttons
        addRentalButton.addActionListener(e -> switchPage(mainContentPanel, "Add Rental"));
        manageUsersButton.addActionListener(e -> switchPage(mainContentPanel, "Manage Users"));

        // Add Components to the Frame
        frame.add(topNavPanel, BorderLayout.NORTH); 
        frame.add(mainContentPanel, BorderLayout.CENTER);  

        frame.setVisible(true);
    }

   
    private static void setButtonStyle(JButton button) {
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private static void switchPage(JPanel panel, String pageName) {
        CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, pageName);  
    }
}
