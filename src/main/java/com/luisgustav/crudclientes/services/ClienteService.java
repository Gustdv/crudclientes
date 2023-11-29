package com.luisgustav.crudclientes.services;

import com.luisgustav.crudclientes.dto.ClienteDTO;
import com.luisgustav.crudclientes.entities.Cliente;
import com.luisgustav.crudclientes.repositories.ClientRepository;
import com.luisgustav.crudclientes.services.exceptions.DatabaseException;
import com.luisgustav.crudclientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClienteService {

    //Injecao de dependencia

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true) //buscando os clientes por id
    public ClienteDTO findById(Long id) {
       Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
       return new ClienteDTO(cliente);
    }

    @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable) { //buscar todos os clientes
        Page<Cliente> result = repository.findAll(pageable);
        return  result.map(x -> new ClienteDTO(x));
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto) { //inserir um novo cliente
        Cliente client = new Cliente();
        copyDtoCliente(dto, client);
        client = repository.save(client);

        return new ClienteDTO(client);
    }

    @Transactional
    public  ClienteDTO update(Long id, ClienteDTO dto) {
       try {
           Cliente client = repository.getReferenceById(id);
           copyDtoCliente(dto,client);
           client = repository.save(client);
           return new ClienteDTO(client);
       }catch (EntityNotFoundException e) {
           throw  new ResourceNotFoundException("Dados inválidos");
       }

    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Id não encontrado");
        }
        Cliente client = new Cliente();
        repository.deleteById(id);
    }


    private void copyDtoCliente(ClienteDTO dto, Cliente client) {
        client.setName(dto.getName());
        client.setCpf(dto.getCpf());
        client.setChildren(dto.getChildren());
        client.setIncome(dto.getIncome());
        client.setBirthDate(dto.getBirthDate());

    }
}
