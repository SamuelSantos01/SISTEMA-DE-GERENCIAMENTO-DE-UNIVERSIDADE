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
public class TurmaResponseDTO {
    private Long id;
    private String curso;
    private List<Long> professorIds; 
    private List<Long> matriculaIds; 
}