package com.padoca.padaria.Services;

import com.padoca.padaria.Repository.ClientRepository;
import com.padoca.padaria.dto.ClientDto;
import com.padoca.padaria.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ClientDto findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException( "Cliente não encontrado no banco de informações!!!"));
        return new ClientDto(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAllPages(pageable);
        return result.map(client -> new ClientDto(client));
    }


    @Transactional(readOnly = true)
    public List<ClientDto> findAllNome(String nome) {
        List<ClientDto> result = clientRepository.findAllByNome(nome);
        return result;
    }


    @Transactional(readOnly = true)
    public List<ClientDto> findAllPhone(String phone) {
        List<ClientDto> result = clientRepository.findAllByPhone(phone);
        return result;
    }

    @Transactional(readOnly = true)
    public List<ClientDto> findAllAniversario(LocalDate aniversario) {
        List<ClientDto> result =  clientRepository.findAllByAniversario(aniversario);
        return result;
    }

    //metodos de insert, att e delete
    @Transactional
    public ClientDto addClient(ClientDto clientDto) {
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setBirthdate(clientDto.getBirthdate());
        client.setPassword(clientDto.getPassword());
        client = clientRepository.save(client);
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        Client client = clientRepository.getReferenceById(id);

        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setEmail(clientDto.getEmail());
        client.setBirthdate(clientDto.getBirthdate());
        client.setPassword(clientDto.getPassword());

        client = clientRepository.save(client);
        return new ClientDto(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
