package mf.ibm.restapi.model;

import javax.persistence.*;

@Entity
@Table(name = "current_stock")
public class Stock {
    private int id;
    private String title;

    public Stock() {
    }

    public Stock(String title) {
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
