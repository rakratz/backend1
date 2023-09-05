package br.edu.ipog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ipog.model.Agenda;
import br.edu.ipog.service.AgendaService;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping
    public ResponseEntity<Agenda> criarAgenda(@RequestBody Agenda agenda) {
        Agenda novaAgenda = agendaService.criarAgenda(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAgenda);
    }

    @GetMapping
    public ResponseEntity<List<Agenda>> listarAgendas() {
        List<Agenda> agendas = agendaService.listarAgendas();
        return ResponseEntity.status(HttpStatus.OK).body(agendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> recuperarAgenda(@PathVariable Long id) {
        Agenda agenda = agendaService.recuperarAgenda(id);
        if (agenda != null) {
            return ResponseEntity.status(HttpStatus.OK).body(agenda);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizarAgenda(@PathVariable Long id, @RequestBody Agenda agenda) {
        Agenda agendaAtualizada = agendaService.atualizarAgenda(id, agenda);
        if (agendaAtualizada != null) {
            return ResponseEntity.status(HttpStatus.OK).body(agendaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgenda(@PathVariable Long id) {
        boolean sucesso = agendaService.excluirAgenda(id);
        if (sucesso) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
