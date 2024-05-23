package com.padoca.padaria.dto;

import com.padoca.padaria.entities.Fornecedor;

public class FornecedorDto {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cidade;
    private String estado;

    public FornecedorDto(Long id, String nome, String endereco, String telefone, String email, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.estado = estado;
    }

    public FornecedorDto(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
        this.endereco = fornecedor.getEndereco();
        this.telefone = fornecedor.getTelefone();
        this.email = fornecedor.getEmail();
        this.cidade = fornecedor.getCidade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
