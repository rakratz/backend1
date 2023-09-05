package br.edu.ipog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ipog.exception.BusinessException;
import br.edu.ipog.model.Paciente;
import br.edu.ipog.repository.PacienteRepository;



@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;

	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	@Transactional
	public Paciente salvarPaciente(Paciente paciente) {

		// Há fazer (TODO) = Validação de CPF único
		
		boolean cpfEncontrado = false;
		
		Optional<Paciente> pesquisaPaciente = pacienteRepository.findByCpf(paciente.getCpf());
		
		if (pesquisaPaciente.isPresent()) {
			if (!pesquisaPaciente.get().getId().equals(paciente.getId())) {
				// Se isso acontecer o CPF já existe no BD
				cpfEncontrado = true;
			}
		}

		if (cpfEncontrado) {
			 throw new BusinessException("CPF já cadastrado!");
		}
	

		return pacienteRepository.save(paciente);
	}

	public List<Paciente> listarPacientes() {
		return pacienteRepository.findAll();
	}

	public Optional<Paciente> buscarPacientePorId(Long id) {
		return pacienteRepository.findById(id);
	}

	@Transactional
	public void deletarPaciente(Long id) {
		pacienteRepository.deleteById(id);
	}
}
