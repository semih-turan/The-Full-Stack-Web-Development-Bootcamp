package view;

import business.BrandManager;
import entity.Brand;
import entity.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_brand;
    private JScrollPane scrl_brand;
    private JTable tbl_brand;
    private User user;
    private DefaultTableModel tmdl_brand = new DefaultTableModel(); // You need to be able to operate on tables.
    private BrandManager brandManager;
    private JPopupMenu brandMenu; // Right-click menu in tables
    public AdminView(User user){
        this.brandManager = new BrandManager();
        this.add(container);
        this.guiInitilaze(1000,500);
        this.user = user;
        if(this.user == null){
            dispose();
        }

        this.lbl_welcome.setText("Welcome " + this.user.getUsername());

        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Brand> brandArrayList = brandManager.findAll();
        tmdl_brand.setColumnIdentifiers(col_brand);

        for(Brand brand: brandArrayList){
            Object[] obj = {brand.getId(),brand.getName()};
            tmdl_brand.addRow(obj);
        }

        tbl_brand.setModel(tmdl_brand);
        tbl_brand.getTableHeader().setReorderingAllowed(false); // Turns off column relocation in a table
        tbl_brand.setEnabled(false); // Turns off editing when double-clicking on the table

        // Shows the line where the mouse clicked
        this.tbl_brand.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               int selected_row = tbl_brand.rowAtPoint(e.getPoint());
               tbl_brand.setRowSelectionInterval(selected_row,selected_row);
            }
        });


        // Pop-up menu
        this.brandMenu = new JPopupMenu();
        this.brandMenu.add("New").addActionListener(e ->{
            System.out.println("New button click!");
        });
        this.brandMenu.add("Update");
        this.brandMenu.add("Delete");
        // Integrate pop-up menu into tables
        this.tbl_brand.setComponentPopupMenu(brandMenu);
    }

}
