package com.empresa.DAO;

import java.util.List;



import com.empresa.model.Contato;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ContatoDAO {

    // Gerenciador de fábrica de entidades - cria EntityManagers
    private EntityManagerFactory entityManagerFactory;

    // Gerenciador de entidades - gerencia entidades persistentes
    private EntityManager entityManager;

    // Construtor que inicializa o EntityManager e o EntityManagerFactory
    public ContatoDAO() {
        // Cria a fábrica de EntityManager usando as configurações do persistence.xml
        entityManagerFactory = Persistence.createEntityManagerFactory("meuBanco");

        // Cria o EntityManager a partir da fábrica
        entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para fechar o EntityManager e o EntityManagerFactory
    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Método para adicionar um novo contato ao banco de dados
    public void adicionarContato(Contato contato) {
        // Inicia uma transação
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Persiste o contato no banco de dados
        entityManager.persist(contato);

        // Comita a transação
        transaction.commit();
    }

    // Método para buscar um contato por seu ID
    public Contato buscarContatoPorId(int id) {
        // Utiliza o método find do EntityManager para buscar um contato por seu ID
        return entityManager.find(Contato.class, id);
    }

    // Método para buscar todos os contatos no banco de dados
    public List<Contato> buscarTodosContatos() {
        // Cria uma consulta JPQL para selecionar todos os contatos
        TypedQuery<Contato> query = entityManager.createQuery("SELECT c FROM Contato c", Contato.class);

        // Executa a consulta e retorna a lista de contatos
        return query.getResultList();
    }

    // Método para atualizar as informações de um contato no banco de dados
    public void atualizarContato(Contato contato) {
        // Inicia uma transação
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Usa o método merge do EntityManager para atualizar o contato
        entityManager.merge(contato);

        // Comita a transação
        transaction.commit();
    }

    // Método para excluir um contato do banco de dados por seu ID
    public void excluirContato(int id) {
        // Inicia uma transação
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Busca o contato por seu ID
        Contato contato = entityManager.find(Contato.class, id);

        // Verifica se o contato existe antes de tentar removê-lo
        if (contato != null) {
            entityManager.remove(contato);
        }

        // Comita a transação
        transaction.commit();
    }
}
