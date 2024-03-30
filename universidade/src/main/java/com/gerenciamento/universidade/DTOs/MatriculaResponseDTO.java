package com.gerenciamento.universidade.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaResponseDTO {
    private Long id;
    private String curso;
    private String nomeAluno;
    private Long alunoId;
    private Long turmaId;
}