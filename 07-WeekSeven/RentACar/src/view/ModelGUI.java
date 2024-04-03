package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;

import javax.swing.*;

// Represents the graphical user interface for creating or updating a model
public class ModelGUI extends Layout {
    private JPanel container;
    private JLabel label_heading;
    private JComboBox<ComboItem> combo_model_brand;
    private JLabel label_brand;
    private JTextField field_model_name;
    private JLabel label_model_year;
    private JLabel label_model_name;
    private JTextField field_model_year;
    private JLabel label_model_type;
    private JComboBox<Model.Type> combo_model_type;
    private JLabel label_model_fuel;
    private JComboBox<Model.Fuel> combo_model_fuel;
    private JLabel label_model_gear;
    private JComboBox<Model.Gear> combo_model_gear;
    private JButton button_model_save;
    private final Model model;
    private ModelManager modelManager;
    private BrandManager brandManager;

    // Constructor for ModelGUI
    public ModelGUI(Model model) {
        // Initialize GUI components
        this.add(container);
        this.model = model;
        this.modelManager = new ModelManager();
        this.brandManager = new BrandManager();
        this.guiInitialize(350, 450);

        // Populate combo box with brand names
        for (Brand brand : this.brandManager.findAll()) {
            this.combo_model_brand.addItem(new ComboItem(brand.getId(), brand.getName()));
        }

        // Populate combo boxes with enum values
        this.combo_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.combo_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.combo_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));

        // If the model is being updated, pre-fill the fields with its current values
        if (this.model.getId() != 0) {
            this.field_model_year.setText(this.model.getYear());
            this.field_model_name.setText(this.model.getName());
            this.combo_model_fuel.getModel().setSelectedItem(this.model.getFuel());
            this.combo_model_gear.getModel().setSelectedItem(this.model.getGear());
            this.combo_model_type.getModel().setSelectedItem(this.model.getType());
            ComboItem defaultBrand = new ComboItem(this.model.getBrand().getId(), this.model.getBrand().getName());
            this.combo_model_brand.getModel().setSelectedItem(defaultBrand);
        }

        // Action listener for save button
        this.button_model_save.addActionListener(e -> {
            // Check if any required fields are empty
            if (Helper.isFieldListEmpty(new JTextField[]{this.field_model_name, this.field_model_year})){
                Helper.showMessage("Fill in all fields.");
            } else {
                boolean result ;
                ComboItem selectedItem = (ComboItem) combo_model_brand.getSelectedItem();

                // Set model properties based on user input
                this.model.setYear(field_model_year.getText());
                this.model.setName(field_model_name.getText());
                assert selectedItem != null;
                this.model.setBrand_id(selectedItem.getKey());
                this.model.setType((Model.Type) combo_model_type.getSelectedItem());
                this.model.setFuel((Model.Fuel) combo_model_fuel.getSelectedItem());
                this.model.setGear((Model.Gear) combo_model_gear.getSelectedItem());

                // Check if the model is being updated or created
                if (this.model.getId() != 0) {
                    result = this.modelManager.update(this.model);
                    if (result) {
                        Helper.showMessage("Update Successful!");
                        dispose(); // Close the window after successful update
                    } else {
                        Helper.showMessage("Error occurred during update.");
                    }
                } else {
                    result = this.modelManager.save(this.model);
                    if (result) {
                        Helper.showMessage("Transaction Succeed !");
                        dispose(); // Close the window after successful transaction
                    } else {
                        Helper.showMessage("Error.");
                    }
                }
            }
        });
    }
}
