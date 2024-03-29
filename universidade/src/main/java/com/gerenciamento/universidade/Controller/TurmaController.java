package com.gerenciamento.universidade.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gerenciamento.universidade.DTOs.TurmaDTO;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Service.TurmaServiceImplemente;

import java.util.List;

@RestController
@RequestMapping("/universidade/turma")
public class TurmaController {

    @Autowired
    private TurmaServiceImplemente turmaServiceImplemente;

    @PostMapping("/cadastrarTurma")
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
        Turma turmaCadastrada = turmaServiceImplemente.cadastrarTurma(turmaDTO.getIdProfessor(), turmaDTO.getCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaCadastrada);
    }

    @DeleteMapping("/deletarTurma/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        turmaServiceImplemente.deletarturma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultarTodasAsTurmas")
    public ResponseEntity<List<Turma>> consultarTodasAsTurmas() {
        List<Turma> turmas = turmaServiceImplemente.consultarTodasAsTurmas();
        return ResponseEntity.ok().body(turmas);
    }

    @GetMapping("/consultarTurmaPorId/{id}")
    public ResponseEntity<Turma> consultarTurmaPorId(@PathVariable Long id) {
        Turma turma = turmaServiceImplemente.consultarById(id);
        return ResponseEntity.ok().body(turma);
    }
}
