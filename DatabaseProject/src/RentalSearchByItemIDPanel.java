import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Arrays;

public class RentalSearchByItemIDPanel extends JPanel {

    private JTextField userIdField;
    private JTextField itemIdField;
    private JTextField dueInDaysField;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JTable rentalTable;
    private DefaultTableModel tableModel;

    public RentalSearchByItemIDPanel() {
        setLayout(new BorderLayout());

        JPanel filterPanel = new JPanel(new FlowLayout());

        userIdField = new JTextField(10);
        itemIdField = new JTextField(10);
        dueInDaysField = new JTextField(5);
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete Selected");
        updateButton = new JButton("Update Selected");

        filterPanel.add(new JLabel("User ID:"));
        filterPanel.add(userIdField);
        filterPanel.add(new JLabel("Item ID:"));
        filterPanel.add(itemIdField);
        filterPanel.add(new JLabel("Due in ≤ days:"));
        filterPanel.add(dueInDaysField);
        filterPanel.add(searchButton);
        filterPanel.add(deleteButton);
        filterPanel.add(updateButton);

        String[] columns = {"Item Name", "Start Date", "End Date", "Username", "Renter ID", "Pickup Date"};
        tableModel = new DefaultTableModel(columns, 0);
        rentalTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(rentalTable);

        add(filterPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userId = userIdField.getText().trim();
                String itemId = itemIdField.getText().trim();
                String dueDays = dueInDaysField.getText().trim();

                tableModel.setRowCount(0);

                try {
                    // Replace this section with real database query logic using the input fields
                    // Use userId, itemId, and dueDays to filter database results

                    // Placeholder dummy data for testing layout
                    List<Object[]> results = Arrays.asList(
                        new Object[]{"Book A", "2024-01-01", "2024-01-05", "jdoe", "0001", "2024-01-02"},
                        new Object[]{"Book B", "2024-01-03", "2024-01-08", "asmith", "0002", "2024-01-03"}
                    );

                    for (Object[] row : results) {
                        tableModel.addRow(row);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RentalSearchByItemIDPanel.this, "Error loading rentals: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = rentalTable.getSelectedRow();
                if (selectedRow >= 0) {
                    //  Replace with actual database delete logic using the row data
                    tableModel.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(RentalSearchByItemIDPanel.this, "Rental deleted (placeholder action).", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(RentalSearchByItemIDPanel.this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = rentalTable.getSelectedRow();
                if (selectedRow >= 0) {
                    JTextField itemNameField = new JTextField((String) tableModel.getValueAt(selectedRow, 0));
                    JTextField startDateField = new JTextField((String) tableModel.getValueAt(selectedRow, 1));
                    JTextField endDateField = new JTextField((String) tableModel.getValueAt(selectedRow, 2));
                    JTextField usernameField = new JTextField((String) tableModel.getValueAt(selectedRow, 3));
                    JTextField renterIdField = new JTextField((String) tableModel.getValueAt(selectedRow, 4));
                    JTextField pickupDateField = new JTextField((String) tableModel.getValueAt(selectedRow, 5));

                    JPanel updatePanel = new JPanel(new GridLayout(0, 2));
                    updatePanel.add(new JLabel("Item Name:"));
                    updatePanel.add(itemNameField);
                    updatePanel.add(new JLabel("Start Date:"));
                    updatePanel.add(startDateField);
                    updatePanel.add(new JLabel("End Date:"));
                    updatePanel.add(endDateField);
                    updatePanel.add(new JLabel("Username:"));
                    updatePanel.add(usernameField);
                    updatePanel.add(new JLabel("Renter ID:"));
                    updatePanel.add(renterIdField);
                    updatePanel.add(new JLabel("Pickup Date:"));
                    updatePanel.add(pickupDateField);

                    int result = JOptionPane.showConfirmDialog(RentalSearchByItemIDPanel.this, updatePanel, "Update Rental", JOptionPane.OK_CANCEL_OPTION);

                    if (result == JOptionPane.OK_OPTION) {
                        // Replace with actual database update logic
                        tableModel.setValueAt(itemNameField.getText(), selectedRow, 0);
                        tableModel.setValueAt(startDateField.getText(), selectedRow, 1);
                        tableModel.setValueAt(endDateField.getText(), selectedRow, 2);
                        tableModel.setValueAt(usernameField.getText(), selectedRow, 3);
                        tableModel.setValueAt(renterIdField.getText(), selectedRow, 4);
                        tableModel.setValueAt(pickupDateField.getText(), selectedRow, 5);
                        JOptionPane.showMessageDialog(RentalSearchByItemIDPanel.this, "Rental updated (placeholder action).", "Updated", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(RentalSearchByItemIDPanel.this, "Please select a row to update.", "No Selection", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
