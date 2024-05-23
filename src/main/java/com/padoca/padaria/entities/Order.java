package com.padoca.padaria.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedidos")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToOne(mappedBy = "order")
    private Venda venda;

    @ManyToMany(mappedBy = "orders")
    private Set<Produto> products = new HashSet<>();

    public Order(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }
}
