package com.gerenciamento.universidade.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class ProfessorDTO {
    private Long id;
    private String nome;
    private String formacao;
}