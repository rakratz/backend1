package br.edu.ipog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ipog.model.Paciente;
import br.edu.ipog.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Endpoint para salvar um paciente existente (ou atualizar)
    @PostMapping
    public ResponseEntity<Paciente> salvarPaciente(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.salvarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente);
    }

    // Endpoint para listar todos os pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
    
    // Endpoint para listar paciente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
    	
        Optional<Paciente> encontradoPaciente = pacienteService.buscarPacientePorId(id);
        
        if (encontradoPaciente.isEmpty()) {
        	return ResponseEntity.notFound().build();
        } 
        
        return ResponseEntity.status(HttpStatus.OK).body(encontradoPaciente.get());
        
    }

    // Endpoint para alterar paciente
    @PutMapping
    public ResponseEntity<Paciente> alterarPaciente(@RequestBody Paciente paciente) {
    	
    	Paciente salvoPaciente = pacienteService.salvarPaciente(paciente);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(salvoPaciente);
 
    }
    
    // Endpoint para deletar paciente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
    	
    	pacienteService.deletarPaciente(id);
    	
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
 
    }

}
