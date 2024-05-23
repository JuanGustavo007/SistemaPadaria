package com.padoca.padaria.Controllers;

import com.padoca.padaria.Services.ClientService;
import com.padoca.padaria.Services.FornecedorService;
import com.padoca.padaria.dto.ClientDto;
import com.padoca.padaria.dto.FornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDto> getFornecedorById(@PathVariable Long id) {
        FornecedorDto fornecedorDto = fornecedorService.findFornecedorById(id);
        return ResponseEntity.ok(fornecedorDto);
    }

    @GetMapping
    public ResponseEntity<Page<FornecedorDto>> getAllFornecedor(Pageable pageable) {
        Page<FornecedorDto> result = fornecedorService.findAllFornecedores(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/fornecedornome")
    public ResponseEntity<List<FornecedorDto>> getAllFornecedorNome(@RequestParam(name = "nome" , defaultValue = "") String nome) {
        List<FornecedorDto> result = fornecedorService.findAllByNome(nome);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/fornecedorescidade")
    public ResponseEntity<List<FornecedorDto>> getAllByCidade(@RequestParam(name = "cidade" , defaultValue = "") String cidade) {
        List<FornecedorDto> result = fornecedorService.findAllByCidade(cidade);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/fornecedorestado")
    public ResponseEntity<List<FornecedorDto>> getAllByEstado(@RequestParam(name = "estado" , defaultValue = "") String estado) {
        List<FornecedorDto> result = fornecedorService.findAllByEstado(estado);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<FornecedorDto> insertFornecedor(@RequestBody FornecedorDto fornecedor) {
        fornecedor = fornecedorService.addFornecedor(fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDto> updateFornecedor(@PathVariable Long id,@RequestBody FornecedorDto fornecedor) {
        fornecedor =  fornecedorService.updateFornecedor(id, fornecedor);
        return ResponseEntity.ok(fornecedor);
    }

    @DeleteMapping
    public ResponseEntity<FornecedorDto> deleteFornecedor(@PathVariable Long id) {
       fornecedorService.deleteFornecedor(id);
       return ResponseEntity.noContent().build();
    }

}
