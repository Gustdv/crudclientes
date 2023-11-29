package com.luisgustav.crudclientes.controllers;

import com.luisgustav.crudclientes.dto.ClienteDTO;
import com.luisgustav.crudclientes.repositories.ClientRepository;
import com.luisgustav.crudclientes.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClienteController {

    //Injecao de dependencias

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}") //busca por id
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        ClienteDTO dto = clienteService.findById(id);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping
    public  ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) { //busca por paginacao
        Page<ClienteDTO> dto = clienteService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ClienteDTO insert(@Valid @RequestBody ClienteDTO dto) { //inserir novo cliente
        return  clienteService.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) { //Atualizando o cliente
        dto = clienteService.update(id,dto);
        return ResponseEntity.ok(dto);
    }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) { //delete de um cliente
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
   }


}
