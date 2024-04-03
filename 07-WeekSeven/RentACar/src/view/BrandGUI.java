package view;

import business.BrandManager;
import core.Helper;
import entity.Brand;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the graphical user interface for Brand operations
public class BrandGUI extends Layout {
    private JPanel container;
    private JLabel label_brand;
    private JLabel label_brand_name;
    private JTextField field_brand_name;
    private JButton button_brand_save;
    private Brand brand;
    private BrandManager brandManager;

    // Constructor for BrandGUI
    public BrandGUI(Brand brand) {
        // Initialize BrandManager and Brand instances
        this.brandManager = new BrandManager();
        this.brand = brand;

        // Add container to the JFrame
        this.add(container);

        // Initialize GUI and set dimensions
        this.guiInitialize(300, 300);

        // Populate text field if brand is not null
        if (brand != null) {
            field_brand_name.setText(brand.getName());
        }

        // Action listener for save button
        button_brand_save.addActionListener(e -> {
            // Check if brand name field is empty
            if (Helper.isFieldEmpty(this.field_brand_name)) {
                Helper.showMessage("Please fill in all fields.");
            } else {
                boolean result;

                // Save or update brand based on whether brand is null or not
                if (this.brand == null) {
                    // If brand is null, save a new brand
                    result = this.brandManager.save(new Brand(field_brand_name.getText()));
                } else {
                    // If brand is not null, update the existing brand
                    this.brand.setName(field_brand_name.getText());
                    result = this.brandManager.update(this.brand);
                }

                // Show appropriate message based on operation result
                if (result) {
                    Helper.showMessage("Transaction successful.");
                    dispose(); // Close the window after successful operation
                } else {
                    Helper.showMessage("Error occurred during the operation.");
                }
            }
        });
    }
}
