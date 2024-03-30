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
    private Long alunoId; // Alterado para armazenar apenas o ID do aluno
    private Long turmaId; // Alterado para armazenar apenas o ID da turma
}
