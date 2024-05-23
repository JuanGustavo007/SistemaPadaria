package com.padoca.padaria.Services;

import com.padoca.padaria.Repository.FornecedorRepository;
import com.padoca.padaria.dto.FornecedorDto;
import com.padoca.padaria.entities.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional(readOnly = true)
    public FornecedorDto findFornecedorById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o fornecedor no banco de informações!!!"));
        return new FornecedorDto(fornecedor);
    }

    @Transactional(readOnly = true)
    public Page<FornecedorDto> findAllFornecedores(Pageable pageable) {
        Page<FornecedorDto> fornecedores = fornecedorRepository.findAllFornecedores(pageable);
        return fornecedores;
    }

    @Transactional(readOnly = true)
    public List<FornecedorDto> findAllByNome(String nome) {
        List<FornecedorDto> fornecedores = fornecedorRepository.findAllByNome(nome);
        return fornecedores;
    }

    @Transactional(readOnly = true)
    public List<FornecedorDto> findAllByCidade(String cidade) {
        List<FornecedorDto> fornecedores = fornecedorRepository.findAllByCity(cidade);
        return fornecedores;
    }

    @Transactional(readOnly = true)
    public List<FornecedorDto> findAllByEstado(String estado) {
        List<FornecedorDto> fornecedorDtos = fornecedorRepository.findAllByEstado(estado);
        return fornecedorDtos;
    }

    // metodos insert, put e delete
    @Transactional
    public FornecedorDto addFornecedor(FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorDto.getNome());
        fornecedor.setCidade(fornecedorDto.getCidade());
        fornecedor.setEstado(fornecedorDto.getEstado());

        fornecedor = fornecedorRepository.save(fornecedor);
        return new FornecedorDto(fornecedor);
    }

    @Transactional
    public FornecedorDto updateFornecedor(Long id ,FornecedorDto fornecedorDto) {
        Fornecedor fornecedor = fornecedorRepository.getReferenceById(id);// Busca o id que vai ser trocado

        fornecedor.setNome(fornecedorDto.getNome()); // seta os valores
        fornecedor.setCidade(fornecedorDto.getCidade()); // seta os valores
        fornecedor.setEstado(fornecedorDto.getEstado()); // Seta os valores
        fornecedor.setEndereco(fornecedorDto.getEndereco()); // Seta os valores
        fornecedor.setEmail(fornecedorDto.getEmail()); // Seta os valores
        fornecedor.setTelefone(fornecedorDto.getTelefone()); // Seta os valores

        fornecedor = fornecedorRepository.save(fornecedor); // Salva no repository
        return new FornecedorDto(fornecedor); // Retorna para o controller
    }

    @Transactional
    public void deleteFornecedor(Long id) {
        Fornecedor fornecedor = fornecedorRepository.getReferenceById(id);
        fornecedorRepository.delete(fornecedor);
    }

}
