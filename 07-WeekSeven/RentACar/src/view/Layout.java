package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

// Class representing the GUI layout of the application
public class Layout extends JFrame {

    // Method to initialize the GUI layout
    public void guiInitialize(int width, int height) {
        // Set default close operation for the JFrame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Set title of the JFrame
        this.setTitle("Rent a Car");
        // Set size of the JFrame
        this.setSize(width, height);

        // Center the JFrame on the screen
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;
        this.setLocation(x, y);

        // Make the JFrame visible
        this.setVisible(true);
    }

    // Method to create a table with provided data
    public void createTable(DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows) {
        // Set column identifiers for the table
        model.setColumnIdentifiers(columns);
        // Set the model for the table
        table.setModel(model);
        // Disable column reordering
        table.getTableHeader().setReorderingAllowed(false);
        // Set maximum width for the first column
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        // Disable table editing
        table.setEnabled(false);

        // Clear existing rows in the table model
        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        // Add rows to the table model
        if (rows == null) {
            rows = new ArrayList<>();
        }
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    // Method to get the selected row of a table
    public int getTableSelectedRow(JTable table, int index) {
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(), index).toString());
    }

    // Method to handle row selection in a table
    public void tableRowSelect(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Get the selected row when the mouse is pressed
                int selected_row = table.rowAtPoint(e.getPoint());
                // Select the row
                table.setRowSelectionInterval(selected_row, selected_row);
            }
        });
    }
}
