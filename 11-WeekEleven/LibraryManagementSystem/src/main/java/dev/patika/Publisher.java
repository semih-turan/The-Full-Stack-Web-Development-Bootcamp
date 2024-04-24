package dev.patika;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="publisher_id", columnDefinition = "serial")
    private long id;

    @Column(name="publisher_name", nullable = false)
    private String name;

    @Column(name="publisher_establish_year", nullable = false)
    private int establishmentYear;

    @Column(name="publisher_address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Publisher() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishmentYear() {
        return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
        this.establishmentYear = establishmentYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
