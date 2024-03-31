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

// controlador do fluxo de servicos para a entidade "turma"
@RestController
// raiz da requisicao feita por um usuario sobre a entidade "turma"
@RequestMapping("/universidade/turma")
public class TurmaController {

    @Autowired
    private TurmaServiceImplemente turmaServiceImplemente;

    // faz uma requisicao ao sistema para cadastrar uma nova turma
    @PostMapping("/cadastrarTurma")
    public ResponseEntity<Turma> cadastrarTurma(@RequestBody TurmaRequestDTO turmaDTO) {
        Turma turmaCadastrada = turmaServiceImplemente.cadastrarTurma(turmaDTO.getIdProfessor(), turmaDTO.getCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaCadastrada);
    }

    // faz uma requisicao ao sistema para deletar uma turma especifica por "id"
    @DeleteMapping("/deletarTurma/{id}")
    public ResponseEntity<Void> deletarTurma(@PathVariable Long id) {
        turmaServiceImplemente.deletarturma(id);
        return ResponseEntity.noContent().build();
    }

    // faz uma requisicao ao sistema para consultar todas as turmas
    @GetMapping("/consultarTodasAsTurmas")
    public ResponseEntity<List<TurmaResponseDTO>> consultarTodasAsTurmas() {
        List<TurmaResponseDTO> turmasDTO = turmaServiceImplemente.consultarTodasAsTurmas();
        return ResponseEntity.ok().body(turmasDTO);
    }

    // faz uma requisicao ao sistema  para consultar uma turma especifica por "id"
    @GetMapping("/consultarTurmaPorId/{id}")
    public ResponseEntity<TurmaResponseDTO> consultarTurmaPorId(@PathVariable Long id) {
        TurmaResponseDTO turmaDTO = turmaServiceImplemente.consultarById(id);
        return ResponseEntity.ok().body(turmaDTO);
    }
}
