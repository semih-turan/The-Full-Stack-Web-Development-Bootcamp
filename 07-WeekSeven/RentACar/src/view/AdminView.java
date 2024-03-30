package view;

import business.BrandManager;
import core.Helper;
import entity.Brand;
import entity.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        loadBrandTable();
        loadBrandComponent();
        // Integrate pop-up menu into tables
        this.tbl_brand.setComponentPopupMenu(brandMenu);
    }

    public void loadBrandTable(){
        Object[] col_brand = {"Brand ID", "Brand Name"};
        ArrayList<Object[]> brandArrayList = brandManager.getForTable(col_brand.length);
        this.tmdl_brand.setColumnIdentifiers(col_brand);
        this.createTable(this.tmdl_brand,this.tbl_brand,col_brand,brandArrayList);
    }

    public void loadBrandComponent(){
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
            BrandView brandView = new BrandView(null);
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Update").addActionListener(e ->{
            int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
            BrandView brandView = new BrandView(this.brandManager.getById(selectBrandId));
            brandView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadBrandTable();
                }
            });
        });
        this.brandMenu.add("Delete").addActionListener(e->{
            if(Helper.confirm("sure")){
                int selectBrandId = this.getTableSelectedRow(tbl_brand,0);
                if(this.brandManager.delete(selectBrandId)){
                    Helper.showMessage("done");
                    System.out.println(selectBrandId);
                    loadBrandTable();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }
}
