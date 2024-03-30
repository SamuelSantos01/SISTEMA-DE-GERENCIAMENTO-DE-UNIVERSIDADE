package com.gerenciamento.universidade.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Pessoa {
    @Column(name = "NOME")
    public String nome;
    @Column(name = "SOBRE_NOME")
    public String sobreNome;
    @Column(name = "TELEFONE")
    public String telefone;
    @Column(name = "EMAIL")
    public String email;
}