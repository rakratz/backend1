package br.edu.ipog.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ipog.model.Agenda;
import br.edu.ipog.repository.AgendaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;

    @Autowired
    public AgendaService(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    public Agenda criarAgenda(Agenda agenda) {
        // Implemente a lógica para criar uma nova agenda
        return agendaRepository.save(agenda);
    }

    public List<Agenda> listarAgendas() {
        // Implemente a lógica para listar todas as agendas
        return agendaRepository.findAll();
    }

    public Agenda recuperarAgenda(Long id) {
        // Implemente a lógica para recuperar uma agenda por ID
        Optional<Agenda> agendaOptional = agendaRepository.findById(id);
        return agendaOptional.orElse(null);
    }

    public Agenda atualizarAgenda(Long id, Agenda agenda) {
        // Implemente a lógica para atualizar uma agenda por ID
        Optional<Agenda> agendaExistente = agendaRepository.findById(id);
        
        if (agendaExistente.isPresent()) {
            // Atualize os campos da agendaExistente com os dados da agenda recebida
            Agenda agendaAtualizada = agendaExistente.get();
            agendaAtualizada.setDataHora(agenda.getDataHora());
            agendaAtualizada.setDescricao(agenda.getDescricao());
            agendaAtualizada.setDataCriacao(agenda.getDataCriacao());
            // Atualize outros campos conforme necessário

            return agendaRepository.save(agendaAtualizada);
        } else {
            return null; // Retorna null se a agenda não for encontrada
        }
    }

    public boolean excluirAgenda(Long id) {
        // Implemente a lógica para excluir uma agenda por ID
        if (agendaRepository.existsById(id)) {
            agendaRepository.deleteById(id);
            return true;
        } else {
            return false; // Retorna false se a agenda não for encontrada
        }
    }
}
