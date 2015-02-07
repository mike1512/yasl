package com.geiswinkler.yasl.entities;

import com.geiswinkler.yasl.common.EntityBase;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity for ShoppingList
 * Created by mike on 05.02.2015.
 */
@Entity
@Table(name = "YASL_LIST")
public class ShoppingList extends EntityBase {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "list_seq", initialValue = 1, allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "list_seq")
    @Column(name = "LI_ID")
    private Long id;

    @Column(name = "LI_NAME")
    private String name;

    @Column(name = "LI_STATUS")
    private ShoppingListStatus status;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    List<Entry> entries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingListStatus getStatus() {
        return status;
    }

    public void setStatus(ShoppingListStatus status) {
        this.status = status;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries( List<Entry> entries ) {
        this.entries = entries;
    }
}
