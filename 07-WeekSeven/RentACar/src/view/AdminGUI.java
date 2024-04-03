package view;

import business.BrandManager;
import business.ModelManager;
import core.ComboItem;
import core.Helper;
import entity.Brand;
import entity.Model;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

// Represents the graphical user interface for the admin functionality
public class AdminGUI extends Layout {
    private JPanel container;
    private JLabel label_welcome;
    private JTabbedPane panel_model;
    private JButton button_logout;
    private JPanel panel_brand;
    private JScrollPane scroll_brand;
    private JTable table_brand;
    private JScrollPane scroll_model;
    private JTable table_model;
    private JComboBox<ComboItem> cmb_s_model_brand;
    private JComboBox<Model.Type> cmb_s_model_type;
    private JComboBox<Model.Fuel> cmb_s_model_fuel;
    private JComboBox<Model.Gear> cmb_s_model_gear;
    private JButton btn_search_model;
    private JButton button_cancel_model;
    private User user;
    private DefaultTableModel tableModel_brand;
    private DefaultTableModel tableModel_model;
    private BrandManager brandManager;
    private ModelManager modelManager;
    private JPopupMenu brand_menu;
    private JPopupMenu model_menu;
    private Object[] col_model;

    // Constructor for AdminGUI
    public AdminGUI(User user) {
        // Initialize table models and managers
        this.tableModel_brand = new DefaultTableModel();
        this.tableModel_model = new DefaultTableModel();
        this.brandManager = new BrandManager();
        this.modelManager = new ModelManager();

        // Add container to the JFrame
        this.add(container);

        // Set the user and initialize GUI
        this.user = user;
        this.guiInitialize(1000, 500);

        // Dispose the window if user is null
        if (this.user == null) {
            dispose();
        }

        // Set welcome label text
        this.label_welcome.setText(" Welcome " + this.user.getUsername());

        // Load brand table and components
        loadBrandTable();
        loadBrandComponent();

        // Load model table, components, and filter options
        loadModelTable(null);
        loadModelComponent();
        loadModelFilter();
    }

    // Method to load components related to model functionality
    private void loadModelComponent() {
        // Enable row selection in model table
        tableRowSelect(this.table_model);

        // Initialize pop-up menu for model actions
        this.model_menu = new JPopupMenu();

        // Add action listeners for New, Update, and Delete actions in model menu
        this.model_menu.add("New").addActionListener(e -> {
            ModelGUI modelGUI = new ModelGUI(new Model());
            modelGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });

        this.model_menu.add("Update").addActionListener(e -> {
            int selectModelId = getTableSelectedRow(table_model, 0);
            ModelGUI modelGUI = new ModelGUI(modelManager.getById(selectModelId));
            modelGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadModelTable(null);
                }
            });
        });

        this.model_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectModelId = getTableSelectedRow(table_model, 0);
                if (modelManager.delete(selectModelId)) {
                    Helper.showMessage("Succeed !");
                    loadModelTable(null);
                } else {
                    Helper.showMessage("Error !");
                }
            }
        });

        // Set model menu for model table
        this.table_model.setComponentPopupMenu(this.model_menu);

        // Add action listener for search button
        this.btn_search_model.addActionListener(e -> {
            ComboItem selectedBrand = (ComboItem) this.cmb_s_model_brand.getSelectedItem();
            int brandId = 0;
            if (selectedBrand != null) {
                brandId = selectedBrand.getKey();
            }
            ArrayList<Model> modelListBySearch = this.modelManager.searchForTable(
                    brandId,
                    (Model.Fuel) cmb_s_model_fuel.getSelectedItem(),
                    (Model.Type) cmb_s_model_type.getSelectedItem(),
                    (Model.Gear) cmb_s_model_gear.getSelectedItem()
            );

            ArrayList<Object[]> modelRowListBySearch = this.modelManager.getForTable(this.col_model.length, modelListBySearch);
            loadModelTable(modelRowListBySearch);
        });

        // Add action listener for cancel button
        this.button_cancel_model.addActionListener(e -> {
            this.cmb_s_model_type.setSelectedItem(null);
            this.cmb_s_model_gear.setSelectedItem(null);
            this.cmb_s_model_fuel.setSelectedItem(null);
            this.cmb_s_model_brand.setSelectedItem(null);
            loadModelTable(null);
        });
    }

    // Method to load model table with provided data
    public void loadModelTable(ArrayList<Object[]> modelList) {
        this.col_model = new Object[]{"Model ID", "Brand", "Name", "Type", "Year", "Fuel", "Gear"};
        if (modelList == null) {
            modelList = this.modelManager.getForTable(this.col_model.length, this.modelManager.findAll());
        }
        createTable(tableModel_model, this.table_model, col_model, modelList);
    }

    // Method to load brand table
    public void loadBrandTable() {
        Object[] column_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandList = this.brandManager.getForTable(column_brand.length);
        this.createTable(this.tableModel_brand, this.table_brand, column_brand, brandList);
    }

    // Method to load components related to brand functionality
    public void loadBrandComponent() {
        // Enable row selection in brand table
        tableRowSelect(this.table_brand);

        // Initialize pop-up menu for brand actions
        this.brand_menu = new JPopupMenu();

        // Add action listeners for New, Update, and Delete actions in brand menu
        this.brand_menu.add("New").addActionListener(e -> {
            BrandGUI brandGUI = new BrandGUI(null);
            brandGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                }
            });
        });

        this.brand_menu.add("Update").addActionListener(e -> {
            int selectBrandId = getTableSelectedRow(table_brand, 0);
            BrandGUI brandGUI = new BrandGUI(brandManager.getById(selectBrandId));
            brandGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                }
            });
        });

        this.brand_menu.add("Delete").addActionListener(e -> {
            if (Helper.confirm("sure")) {
                int selectBrandId = getTableSelectedRow(table_brand, 0);
                if (brandManager.delete(selectBrandId)) {
                    Helper.showMessage("Succeed !");
                    loadBrandTable();
                    loadModelTable(null);
                    loadModelFilterBrand();
                } else {
                    Helper.showMessage("Error !");
                }
            }
        });

        // Set brand menu for brand table
        this.table_brand.setComponentPopupMenu(this.brand_menu);
    }

    // Method to load model filter options
    public void loadModelFilter() {
        this.cmb_s_model_type.setModel(new DefaultComboBoxModel<>(Model.Type.values()));
        this.cmb_s_model_type.setSelectedItem(null);
        this.cmb_s_model_gear.setModel(new DefaultComboBoxModel<>(Model.Gear.values()));
        this.cmb_s_model_gear.setSelectedItem(null);
        this.cmb_s_model_fuel.setModel(new DefaultComboBoxModel<>(Model.Fuel.values()));
        this.cmb_s_model_fuel.setSelectedItem(null);
        loadModelFilterBrand();
    }

    // Method to load brand filter options for model
    public void loadModelFilterBrand() {
        this.cmb_s_model_brand.removeAllItems();
        for (Brand obj : brandManager.findAll()) {
            this.cmb_s_model_brand.addItem(new ComboItem(obj.getId(), obj.getName()));
        }
        this.cmb_s_model_brand.setSelectedItem(null);
    }
}
