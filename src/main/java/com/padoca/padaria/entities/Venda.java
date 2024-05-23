package com.padoca.padaria.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FormaPagamento formaPagamento;


    @OneToOne
    @MapsId
    private Order order;

    public Venda(Long id, FormaPagamento formaPagamento) {
        this.id = id;
        this.formaPagamento = formaPagamento;
    }

    public Venda(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
