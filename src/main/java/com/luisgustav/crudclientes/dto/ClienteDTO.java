package com.luisgustav.crudclientes.dto;

import com.luisgustav.crudclientes.entities.Cliente;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClienteDTO {

    //Atributos

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String name;
    @Size(min = 11, max = 11)
    @Column(unique = true)
    private String cpf;
    @Positive(message = "Deve ser positivo")
    private Double income;
    @PastOrPresent(message = "A data deve ser no passado ou presente")
    private LocalDate birthDate;
    private Integer children;

    //Construtor


    public ClienteDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClienteDTO(Cliente client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }
    //Getters


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
