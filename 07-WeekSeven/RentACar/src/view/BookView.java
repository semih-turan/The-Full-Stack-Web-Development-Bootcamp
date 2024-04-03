package view;

import business.BookManager;
import core.Helper;
import entity.Book;
import entity.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Represents the view for booking a car
public class BookView extends Layout {
    private JPanel container;
    private JLabel lbl_car_info;
    private JTextField fld_book_name;
    private JTextField fld_book_idno;
    private JTextField fld_book_mpno;
    private JTextField fld_book_mail;
    private JTextField fld_book_strt_date;
    private JTextField fld_book_fnsh_date;
    private JTextField fld_book_prc;
    private JTextArea txta_book_note;
    private JButton btn_book_save;
    private Car car;
    private BookManager bookManager;

    // Constructor for BookView
    public BookView(Car selectedCar, String strt_date, String fnsh_date) {
        // Initialize selected car and book manager
        this.car = selectedCar;
        this.bookManager = new BookManager();

        // Add container to the JFrame
        this.add(container);

        // Initialize GUI and set dimensions
        guiInitialize(300, 600);

        // Set car information label
        lbl_car_info.setText("Vehicle: " +
                this.car.getPlate() + " / " +
                this.car.getModel().getBrand().getName() + " / " +
                this.car.getModel().getName());

        // Set default values for start and finish dates
        this.fld_book_strt_date.setText(strt_date);
        this.fld_book_fnsh_date.setText(fnsh_date);

        // Test data for fields
        this.fld_book_name.setText("Süleyman KAYIR");
        this.fld_book_idno.setText("12345678911");
        this.fld_book_mail.setText("test@patika.dev");
        this.fld_book_mpno.setText("05501234567");
        this.fld_book_prc.setText("2350");
        this.txta_book_note.setText("A note is left here");

        // Action listener for save button
        btn_book_save.addActionListener(e -> {
            // Check if required fields are empty
            JTextField[] checkFieldList = {
                    this.fld_book_name,
                    this.fld_book_mail,
                    this.fld_book_prc,
                    this.fld_book_mpno,
                    this.fld_book_idno,
                    this.fld_book_strt_date,
                    this.fld_book_fnsh_date
            };

            // If any required field is empty, show a message
            if (Helper.isFieldListEmpty(checkFieldList)) {
                Helper.showMessage("Please fill in all fields.");
            } else {
                // Create a new Book instance and populate its fields
                Book book = new Book();
                book.setbCase("done");
                book.setCar_id(this.car.getId());
                book.setName(this.fld_book_name.getText());
                book.setStrt_date(LocalDate.parse(strt_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setFnsh_date(LocalDate.parse(fnsh_date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                book.setIdno(this.fld_book_idno.getText());
                book.setMpno(this.fld_book_mpno.getText());
                book.setMail(this.fld_book_mail.getText());
                book.setNote(this.txta_book_note.getText());
                book.setPrc(Integer.parseInt(this.fld_book_prc.getText()));

                // Save the book entry to the database
                if (this.bookManager.save(book)) {
                    Helper.showMessage("Booking completed successfully.");
                    dispose();
                } else {
                    Helper.showMessage("An error occurred while saving.");
                }
            }
        });
    }
}
