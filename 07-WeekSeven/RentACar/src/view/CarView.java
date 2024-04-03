package view;

import business.CarManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Car;
import entity.Model;

import javax.swing.*;

// Represents the graphical user interface for car operations
public class CarView extends Layout {
    private JPanel container;
    private JComboBox<ComboItem> cmb_model;
    private JComboBox<Car.Color> cmb_color;
    private JTextField fld_km;
    private JTextField fld_plate;
    private JButton btn_car_save;
    private Car car;
    private CarManager carManager;
    private ModelManager modelManager;

    // Constructor for CarView
    public CarView(Car car) {
        // Initialize CarManager, ModelManager, and Car instances
        this.car = car;
        this.carManager = new CarManager();
        this.modelManager = new ModelManager();

        // Add container to the JFrame
        this.add(container);

        // Initialize GUI and set dimensions
        this.guiInitialize(300, 400);

        // Populate combo boxes with model and color values
        this.cmb_color.setModel(new DefaultComboBoxModel<>(Car.Color.values()));
        for (Model model : this.modelManager.findAll()) {
            this.cmb_model.addItem(model.getComboItem());
        }

        // Populate fields if car object is not null
        if (this.car.getId() != 0) {
            ComboItem selectedItem = car.getModel().getComboItem();
            this.cmb_model.getModel().setSelectedItem(selectedItem);
            this.cmb_color.getModel().setSelectedItem(car.getColor());
            this.fld_plate.setText(car.getPlate());
            this.fld_km.setText(Integer.toString(car.getKm()));
        }

        // Action listener for save button
        this.btn_car_save.addActionListener(e -> {
            // Check if fields are empty
            if (Helper.isFieldListEmpty(new JTextField[]{this.fld_km, this.fld_plate})) {
                Helper.showMessage("Please fill in all fields.");
            } else {
                boolean result;
                ComboItem selectedModel = (ComboItem) this.cmb_model.getSelectedItem();

                // Set car properties
                this.car.setModel_id(selectedModel.getKey());
                this.car.setColor((Car.Color) this.cmb_color.getSelectedItem());
                this.car.setPlate(this.fld_plate.getText());
                this.car.setKm(Integer.parseInt(this.fld_km.getText()));

                // Save or update car based on car ID
                if (this.car.getId() != 0) {
                    result = this.carManager.update(this.car);
                } else {
                    result = this.carManager.save(this.car);
                }

                // Show appropriate message based on operation result
                if (result) {
                    Helper.showMessage("Operation successful.");
                    dispose(); // Close the window after successful operation
                } else {
                    Helper.showMessage("Error occurred during the operation.");
                }
            }
        });
    }
}
