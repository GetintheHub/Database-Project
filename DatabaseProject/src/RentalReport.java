import javax.swing.*;
import java.util.Map;

public class RentalReport {

    // Generate a report 
    public static void generateReport(JFrame frame) {
        // Fetch all rentals 
        Map<String, Rental> rentals = DatabaseHelper.getRentals();

        // Display rentals in a message box
        StringBuilder report = new StringBuilder();
        for (Rental rental : rentals.values()) {
            report.append(rental.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, report.toString(), "Rental Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
