import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    public static void main(String[] args) {
        // JFrame
        JFrame frame = new JFrame("Multimedia Center Database");
        frame.setSize(400, 200);  // Set initial size of window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // layout 
        frame.setLayout(new BorderLayout());

        // Creates the message and button for the login prompt
        JLabel welcomeLabel = new JLabel("Multimedia Center Database", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.setBackground(new Color(0, 123, 255)); 
        loginButton.setForeground(Color.WHITE);

        // welcome label and login button
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(welcomeLabel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);

        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();  

                // JLabel
                JLabel usernameLabel = new JLabel("Username:");
                JLabel passwordLabel = new JLabel("Password:");

                // Create text fields for username and password input
                JTextField usernameField = new JTextField(20);
                JPasswordField passwordField = new JPasswordField(20);

                //JTextField
                JButton submitLoginButton = new JButton("Submit");
                submitLoginButton.setPreferredSize(new Dimension(120, 40));
                submitLoginButton.setBackground(new Color(0, 123, 255));  // Blue button
                submitLoginButton.setForeground(Color.WHITE);  // White text

                //Frame Additions 
                JPanel loginPanel = new JPanel();
                loginPanel.setLayout(new GridLayout(3, 2, 10, 10));  // GridLayout for neat alignment
                loginPanel.add(usernameLabel);
                loginPanel.add(usernameField);
                loginPanel.add(passwordLabel);
                loginPanel.add(passwordField);
                loginPanel.add(submitLoginButton);
                
                submitLoginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String usernameInput = usernameField.getText();
                        String passwordInput = new String(passwordField.getPassword());  // Convert password to string

                        if (usernameInput.equals("Electric Boogalo") && passwordInput.equals("COSC 457")) {
                            JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Invalid Username or Password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                frame.add(loginPanel);
                frame.revalidate();  //
                frame.repaint();    
            }
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}
