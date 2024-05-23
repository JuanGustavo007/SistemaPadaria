package com.padoca.padaria.Repository;

import com.padoca.padaria.dto.ClientDto;
import com.padoca.padaria.entities.Client;

import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT obj from Client obj")
    Page<Client> findAllPages(Pageable pageable);

    @Query("SELECT obj from Client obj where UPPER(obj.name) like CONCAT(UPPER(:nome) , '%')")
    List<ClientDto> findAllByNome(String nome);

    @Query("SELECT obj from Client obj where UPPER(obj.phone) like CONCAT(UPPER(:phone) , '%')")
    List<ClientDto> findAllByPhone(String phone);

    @Query("SELECT obj from Client obj where obj.birthdate = :aniversario")
    List<ClientDto> findAllByAniversario(LocalDate aniversario);
}
