import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;


public class UI {
    public static void main(String[] args) {
    
    
 
        
    
    //JFrame
        JFrame frame = new JFrame("Towson Media Center DB");
        frame.setSize(200, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
     //Layout
         frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
       
    //JLabel
     JLabel usernameLabel = new JLabel("Username");
     
     JLabel passwordLabel = new JLabel("Password");
     
        
        
     // JTextField
        JTextField username = new JTextField(10);
        JTextField password = new JTextField(10);
        
        
        
        
        //JButton
        
        JButton submitLogin = new JButton("Submit");
        submitLogin.addActionListener(e -> {
        
       String usernameLogin = username.getText();
       String passwordLogin = password.getText();
       
       if (usernameLogin == "Electric Boogalo" && passwordLogin == "COSC 457") {
       
       
       
       }
       
      
        });
       
        
        
      
        
     //Frame Additions 
        frame.add(usernameLabel);
        frame.add(username);
        frame.add(passwordLabel);
        frame.add(password);
        frame.add(submitLogin);
        
        
        
        
        frame.setVisible(true);

        
        
        
         
        
        
     
    }
}
