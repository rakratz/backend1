package br.edu.ipog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ipog.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    // Aqui você pode adicionar consultas personalizadas, se necessário
    // Por exemplo, se desejar buscar agendas por algum critério específico
    // Basta criar métodos na interface e o Spring Data JPA fornecerá a implementação

    // Exemplo de consulta personalizada para buscar agendas por algum critério
    // List<Agenda> findByCampoPersonalizado(String campo);
}
