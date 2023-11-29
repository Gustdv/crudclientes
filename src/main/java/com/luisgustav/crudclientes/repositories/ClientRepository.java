package com.luisgustav.crudclientes.repositories;

import com.luisgustav.crudclientes.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Cliente, Long> {
}
