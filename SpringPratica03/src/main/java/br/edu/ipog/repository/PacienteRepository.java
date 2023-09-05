package br.edu.ipog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ipog.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
	
	Optional<Paciente> findByCpf(String cpf);
	
}
