package com.geiswinkler.yasl.entities;

import com.geiswinkler.yasl.common.EntityBase;

import javax.persistence.*;

/**
 * Entity for Entry - ShoppingList Entry
 * Created by mike on 05.02.2015.
 */
@Entity
@Table(name = "YASL_ENTRY")
public class Entry extends EntityBase {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "entry_seq", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entry_seq")
    @Column(name = "EN_ID")
    private Long id;

    @Column(name = "EN_QTY", nullable = false)
    private int quantity;

    @Column(name = "EN_NAME", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EN_LI_ID")
    ShoppingList list;

    @Column(name = "EN_PRICE")
    private double price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShoppingList getList() {
        return list;
    }

    public void setList(ShoppingList list) {
        this.list = list;
    }
}
