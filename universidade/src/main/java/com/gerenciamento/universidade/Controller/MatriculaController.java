package com.gerenciamento.universidade.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gerenciamento.universidade.DTOs.MatriculaRequestDTO;
import com.gerenciamento.universidade.DTOs.MatriculaResponseDTO;
import com.gerenciamento.universidade.Service.MatriculaServiceImplemente;

// controlador do fluxo de servicos para a entidade "matricula"
@RestController
// raiz da requisicao feita por um usuario sobre a entidade "matricula"
@RequestMapping("/universidade/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImplemente matriculaServiceImplemente;

    // faz uma requisicao ao sistema para matricular um novo aluno
    @PostMapping("/matricularAluno")
    public ResponseEntity<Object> matricularAluno(@RequestBody MatriculaRequestDTO matriculaDTO) {
        matriculaServiceImplemente.matricularAluno(matriculaDTO.getIdAluno(), matriculaDTO.getIdTurma(),
                matriculaDTO.getCurso());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // faz uma requisicao ao sistema para consultar todas as matriculas existentes
     @GetMapping("/consultarTodasAsMatriculas")
    public ResponseEntity<List<MatriculaResponseDTO>> consultarTodasAsMatriculas() {
        List<MatriculaResponseDTO> matriculas = matriculaServiceImplemente.consultarTodasAsMatriculas();
        return ResponseEntity.ok().body(matriculas);
    }

    // faz uma requisicao ao sistema para consultar uma matriccula especifica por "id"
    @GetMapping("/consultarMatricula/{id}")
    public ResponseEntity<MatriculaResponseDTO> consultarMatriculaPorId(@PathVariable Long id) {
        MatriculaResponseDTO matricula = matriculaServiceImplemente.consultarById(id);
        return ResponseEntity.ok().body(matricula);
    }

    // faz uma requisicao ao sistema para deletar uma matricula especifica pro "id"
    @DeleteMapping("/deletarMatricula/{id}")
    public ResponseEntity<Object> deletarMatricula(@PathVariable Long id) {
        matriculaServiceImplemente.deletarMatricula(id);
        return ResponseEntity.ok().build();
    }
}