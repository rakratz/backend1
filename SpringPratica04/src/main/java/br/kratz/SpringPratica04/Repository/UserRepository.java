package br.kratz.SpringPratica04.Repository;

import org.springframework.data.jpa.repository.JpaRepository; // Importação da interface JpaRepository.

import br.kratz.SpringPratica04.Model.User.User; // Importação da entidade User.

public interface UserRepository extends JpaRepository<User, Long> {
    // A interface UserRepository estende a JpaRepository, que fornece métodos para operações de CRUD.

    // Esta interface é parametrizada com dois tipos: User (a entidade) e Long (o tipo da chave primária).

    // O Spring Data JPA gera automaticamente implementações dos métodos CRUD e de consulta
    // com base nos métodos definidos nesta interface.

    // A interface UserRepository herda métodos como save, findById, findAll, delete, etc.

    // Não é necessário fornecer uma implementação para esses métodos; o Spring Data JPA
    // cuida da implementação com base na assinatura do método.

    // Isso permite a realização de operações de banco de dados relacionadas ao usuário (User)
    // de forma simples e eficiente sem a necessidade de escrever consultas SQL manualmente.

    // Por exemplo, você pode usar métodos como save para persistir novos usuários no banco de dados
    // ou métodos personalizados de consulta para recuperar usuários com base em critérios específicos.

    // Essa interface é usada para injetar o UserRepository em serviços ou controladores,
    // permitindo a interação com o banco de dados de maneira eficiente.
}
