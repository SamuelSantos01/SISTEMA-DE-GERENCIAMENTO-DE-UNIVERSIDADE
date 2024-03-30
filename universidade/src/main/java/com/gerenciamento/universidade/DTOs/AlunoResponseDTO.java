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
    private List<Long> matriculaIds; // Alterado para armazenar apenas IDs de matrículas
}
