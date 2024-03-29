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

import com.gerenciamento.universidade.DTOs.MatriculaDTO;
import com.gerenciamento.universidade.Entidades.Matricula;
import com.gerenciamento.universidade.Service.MatriculaServiceImplemente;

@RestController
@RequestMapping("/universidade/matricula")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImplemente matriculaServiceImplemente;

    @PostMapping("/matricularAluno")
    public ResponseEntity<Object> matricularAluno(@RequestBody MatriculaDTO matriculaDTO) {
        matriculaServiceImplemente.matricularAluno(matriculaDTO.getIdAluno(), matriculaDTO.getIdTurma(),
                matriculaDTO.getCurso());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/consultarTodasAsMatriculas")
    public ResponseEntity<List<Matricula>> consultarTodasAsMatriculas() {
        List<Matricula> matriculas = matriculaServiceImplemente.consultarTodasAsMatriculas();
        return ResponseEntity.ok().body(matriculas);
    }

    @GetMapping("/consultarMatricula/{id}")
    public ResponseEntity<Matricula> consultarMatriculaPorId(@PathVariable Long id) {
        Matricula matricula = matriculaServiceImplemente.consultarById(id);
        return ResponseEntity.ok().body(matricula);
    }

    @DeleteMapping("/deletarMatricula/{id}")
    public ResponseEntity<Object> deletarMatricula(@PathVariable Long id) {
        matriculaServiceImplemente.deletarMatricula(id);
        return ResponseEntity.ok().build();
    }
}
