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
public class AlunoResponseDTO {
    private String nome;
    private String sobreNome;
    private List<MatriculaDTO> matriculas;
}