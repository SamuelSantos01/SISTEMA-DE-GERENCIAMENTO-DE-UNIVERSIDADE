package com.gerenciamento.universidade.DTOs;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TurmaDTO {
    Long idProfessor;
    String curso;
}
