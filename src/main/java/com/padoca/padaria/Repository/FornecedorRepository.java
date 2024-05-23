package com.padoca.padaria.Repository;

import com.padoca.padaria.dto.FornecedorDto;
import com.padoca.padaria.entities.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query("SELECT obj from Fornecedor obj")
    Page<FornecedorDto> findAllFornecedores(Pageable pageable);

    @Query("SELECT obj from Fornecedor obj where UPPER(obj.nome) like  CONCAT(UPPER(:nome) , '%') ")
    List<FornecedorDto> findAllByNome(String nome);


    @Query("SELECT obj from Fornecedor obj where UPPER(obj.cidade) like CONCAT(UPPER(:cidade), '%' ) ")
    List<FornecedorDto> findAllByCity(String cidade);

    @Query("SELECT obj from Fornecedor obj where UPPER(obj.estado) like CONCAT(UPPER(:estado), '%' ) ")
    List<FornecedorDto> findAllByEstado(String estado);
}
