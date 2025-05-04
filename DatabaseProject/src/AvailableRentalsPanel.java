import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class AvailableRentalsPanel extends JPanel {

    private JTable availableTable;
    private DefaultTableModel tableModel;
    private JButton RedoButton;

    public AvailableRentalsPanel() {
        setLayout(new BorderLayout());

        // Table setup
        String[] columns = {"Type", "Name", "ID", "Available"};
        tableModel = new DefaultTableModel(columns, 0);
        availableTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(availableTable);

        // Refresh button
        RedoButton = new JButton("Refresh List");
        RedoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadAvailableRentals();
            }
        });

        add(RedoButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        loadAvailableRentals(); // Load on init
    }

    private void loadAvailableRentals() {
        tableModel.setRowCount(0);

        try {
            //  Replace this section with a real database query using DatabaseHelper
  

            List<Object[]> dummyResults = new ArrayList<>();
            dummyResults.add(new Object[]{"Item", "Canon Camera", "101", "Yes"});
            dummyResults.add(new Object[]{"Service", "Studio Time", "202", "Yes"});

            for (Object[] row : dummyResults) {
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading available rentals: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
} 
