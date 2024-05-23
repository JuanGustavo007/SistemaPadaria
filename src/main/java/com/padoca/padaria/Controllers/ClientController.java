package com.padoca.padaria.Controllers;

import com.padoca.padaria.Repository.ClientRepository;
import com.padoca.padaria.Services.ClientService;
import com.padoca.padaria.dto.ClientDto;
import com.padoca.padaria.entities.Client;
import com.padoca.padaria.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/{id}") // Busca por id
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        ClientDto clientDto = clientService.findById(id);
        return ResponseEntity.ok(clientDto);
    }


    @GetMapping(value = "/todosclientes") // Todos os clientes paginados
    public Page<ClientDto> getAllClients(Pageable pageable) {
        return clientService.findAll(pageable);
    }

    @GetMapping(value = "/pelonome") // busca pelo nome
    public ResponseEntity<List<ClientDto>> getAllByName(@RequestParam (name = "nome", defaultValue = "") String nome) {
        List<ClientDto> result = clientService.findAllNome(nome);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/pelotelefone") // busca pelo telefone
    public ResponseEntity<List<ClientDto>> getAllByTelefone(@RequestParam (name = "telefone", defaultValue = "") String phone) {
        List<ClientDto> result = clientService.findAllPhone(phone);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/aniversario/{aniversario}")
    public ResponseEntity<List<ClientDto>> getAllByAniversario(@PathVariable LocalDate aniversario) {
        List<ClientDto> result = clientService.findAllAniversario(aniversario);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        clientDto = clientService.addClient(clientDto);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        clientDto = clientService.updateClient(id, clientDto);
        return ResponseEntity.ok(clientDto);
    }

    @DeleteMapping
    public ResponseEntity<ClientDto> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
