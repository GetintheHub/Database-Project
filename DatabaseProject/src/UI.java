import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    public static void main(String[] args) {
        // JFrame
        JFrame frame = new JFrame("Multimedia Center Database");
        frame.setSize(400, 200);  // Larger window to allow space for navigation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        
        frame.setLayout(new BorderLayout());

        // Login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Multimedia Center Database", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        welcomeLabel.setPreferredSize(new Dimension(800, 60));
        welcomeLabel.setBackground(new Color(60, 60, 60));
        welcomeLabel.setForeground(Color.WHITE);
        loginPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Username and Password fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Smaller font for labels and fields
        Font smallFont = new Font("Arial", Font.PLAIN, 12);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(smallFont);
        JTextField usernameField = new JTextField(12);  
        usernameField.setFont(smallFont);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(smallFont);
        JPasswordField passwordField = new JPasswordField(12);  
        passwordField.setFont(smallFont);

        
        JButton submitButton = new JButton("Login");
        submitButton.setPreferredSize(new Dimension(100, 35));  //
        submitButton.setBackground(new Color(0, 123, 255)); 
        submitButton.setForeground(Color.WHITE);  
        submitButton.setFont(smallFont);  

        //Frame Additions 
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(submitButton);

        loginPanel.add(formPanel, BorderLayout.CENTER);

        //ActionListener for Login Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameInput = usernameField.getText();
                String passwordInput = new String(passwordField.getPassword());

                // Validate login credentials with placeholder for database
                if (DatabaseHelper.validateUser(usernameInput, passwordInput)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Transition to the main dashboard after login
                    frame.getContentPane().removeAll(); 
                    MainDashboard.showDashboard(frame); 
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setVisible(true); 
    }
}
