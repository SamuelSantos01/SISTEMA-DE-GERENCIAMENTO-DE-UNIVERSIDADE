package com.gerenciamento.universidade.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponseDTO {
    private String nome;
    private String sobreNome;
    private String formacao;
    private List<Long> turmaIds; // Alterado para armazenar apenas IDs de turmas
}
