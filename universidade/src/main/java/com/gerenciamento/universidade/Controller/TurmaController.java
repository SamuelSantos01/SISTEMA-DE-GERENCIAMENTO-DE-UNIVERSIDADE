package com.gerenciamento.universidade.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gerenciamento.universidade.DTOs.TurmaRequestDTO;
import com.gerenciamento.universidade.DTOs.TurmaResponseDTO;
import com.gerenciamento.universidade.Entidades.Turma;
import com.gerenciamento.universidade.Service.TurmaServiceImplemente;
import java.util.List;

@RestController
@RequestMapping("/universidade/turma")
public class TurmaController {

    @Autowired
    private TurmaServiceImplemente turmaServiceImplemente;

    @PostMapping("/cadastrarTurma")
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody TurmaRequestDTO turmaDTO) {
        Turma turmaCadastrada = turmaServiceImplemente.cadastrarTurma(turmaDTO.getIdProfessor(), turmaDTO.getCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaCadastrada);
    }

    @DeleteMapping("/deletarTurma/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        turmaServiceImplemente.deletarturma(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultarTodasAsTurmas")
    public ResponseEntity<List<TurmaResponseDTO>> consultarTodasAsTurmas() {
        List<TurmaResponseDTO> turmasDTO = turmaServiceImplemente.consultarTodasAsTurmas();
        return ResponseEntity.ok().body(turmasDTO);
    }

    @GetMapping("/consultarTurmaPorId/{id}")
    public ResponseEntity<TurmaResponseDTO> consultarTurmaPorId(@PathVariable Long id) {
        TurmaResponseDTO turmaDTO = turmaServiceImplemente.consultarById(id);
        return ResponseEntity.ok().body(turmaDTO);
    }
}
