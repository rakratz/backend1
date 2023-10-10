# Desafio Back-end Sistema de Pagrameento estilo PicPay

Aula de Desenvolvimento Backend 1 baseado eem um desafio de um processo seletivo de Desenvolveedor BackEnd.


# Entrega do Desafio:

- Crie um repositório no GitHub sem fazer qualquer menção ao PicPay.
- Faça seus commits no seu repositório.
- Envie o link do seu repositório para o email do recrutador responsável.
- Você poderá consultar o Google, Stack Overflow ou algum projeto particular em sua máquina.
- Dê uma olhada nos Materiais úteis.
- Confira o formato da entrevista.
- Não hesite em fazer perguntas aos recrutadores.
- Mantenha a calma e respire, lembre-se de que todos nós já passamos por essa etapa. Boa sorte! :)

[Corpo do Email]

Seu Nome: 

Nome do Recrutador: 

Link do Repositório: 

Link do LinkedIn: 

# Preparação para Avaliação e Code Review

Na data agendada pelo recrutador, assegure-se de que sua aplicação esteja rodando em sua máquina local, pronta para execução de testes e para a apresentação dos aspectos que você desenvolveu. Realizaremos uma revisão de código juntos, como se você já fizesse parte de nossa equipe ❤️. Esta é a oportunidade para você explicar sua visão, arquitetura e possíveis melhorias para o projeto.

# Descrição do Desafio

Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam transferências entre eles. Vamos nos atentar somente ao fluxo de transferência entre dois usuários.

Requisitos:

Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail.

* Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários.

* Lojistas só recebem transferências, não enviam dinheiro para ninguém.

* Validar se o usuário tem saldo antes da transferência.

* Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este mock para simular (https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6).

* A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o dinheiro deve voltar para a carteira do usuário que envia.

* No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este mock para simular o envio (http://o4d9z.mocklab.io/notify).

* Este serviço deve ser RESTFul.

# Payload
Faça uma proposta ❤️ de payload, se preferir, temos uma exemplo aqui:

POST /transaction
```
{
    "value" : 100.00,
    "payer" : 4,
    "payee" : 15
}
```
# O que será avaliado e valorizamos ❤️

* Documentação
* Se for para vaga sênior, foque bastante no desenho de arquitetura
* Código limpo e organizado (nomenclatura, etc)
* Conhecimento de padrões (PSRs, design patterns, SOLID)
* Ser consistente e saber argumentar suas escolhas
* Apresentar soluções que domina
* Modelagem de Dados
* Manutenibilidade do Código
* Tratamento de erros
* Cuidado com itens de segurança
* Arquitetura (estruturar o pensamento antes de escrever)
* Carinho em desacoplar componentes (outras camadas, service, repository)
* De acordo com os critérios acima, iremos avaliar seu teste para avançarmos para a entrevista técnica. Caso não tenha atingido aceitavelmente o que estamos propondo acima, não iremos prosseguir com o processo.

# O que NÃO será avaliado ⚠️
* Fluxo de cadastro de usuários e lojistas
* Frontend (só avaliaremos a (API Restful)[https://www.devmedia.com.br/rest-tutorial/28912])
* Autenticação

# O que será um Diferencial
* Uso de Docker
* Testes de integração
* Testes unitários
* Uso de Design Patterns
* Documentação
* Proposta de melhoria na arquitetura

# Fundamentação Teórica da Tecnologias utilizadas

**RESTful** (Representational State Transfer) é um estilo arquitetural amplamente utilizado na concepção de serviços da web e APIs (Interfaces de Programação de Aplicativos) que se baseia em princípios simples e intuitivos para criar sistemas web escaláveis e interoperáveis. Ele foi apresentado por Roy Fielding em sua tese de doutorado em 2000 e desempenhou um papel fundamental na evolução da web.

Aqui estão os principais princípios e conceitos que caracterizam uma arquitetura RESTful:

Recursos (Resources): Em uma arquitetura RESTful, tudo é tratado como um recurso. Um recurso pode ser qualquer coisa que tenha um identificador único, como um documento, imagem, objeto de banco de dados, ou até mesmo um serviço.

URI (Uniform Resource Identifier): Cada recurso é acessado por meio de um URI único, que atua como um identificador exclusivo para esse recurso. As URIs devem ser significativas e fáceis de entender.

Verbos HTTP: REST utiliza os métodos HTTP (GET, POST, PUT, DELETE, etc.) para realizar operações nos recursos. Por exemplo, o método GET é usado para recuperar informações sobre um recurso, enquanto o POST é usado para criar um novo recurso.

Representações: Os recursos podem ter várias representações, como JSON, XML, HTML, ou qualquer outro formato de dados. O cliente pode especificar o formato desejado por meio do cabeçalho Accept na solicitação HTTP.

Estado (Stateless): As solicitações HTTP em uma arquitetura RESTful são independentes umas das outras. O servidor não mantém informações de estado do cliente entre solicitações. Cada solicitação do cliente deve conter todas as informações necessárias para ser compreendida e processada pelo servidor.

Interconexão Cliente-Servidor: A arquitetura REST separa o cliente do servidor, permitindo que eles evoluam independentemente. Isso facilita a escalabilidade e a manutenção.

Sistema em Camadas: Uma arquitetura RESTful pode ser composta por várias camadas. Cada camada executa uma função específica e não precisa conhecer os detalhes das outras camadas.

Cache: O uso de cache é incentivado para melhorar o desempenho. As respostas do servidor podem ser marcadas como cacheáveis ou não-cacheáveis.

Interface Uniforme: A interface oferecida pela arquitetura REST deve ser consistente e uniforme, tornando mais fácil para os desenvolvedores entenderem e interagirem com os serviços.

Sistema em Estado de Representação (State of Representation): O cliente mantém o estado da aplicação, com a representação do recurso, e envia essas representações para o servidor quando necessário.

O RESTful é amplamente adotado na criação de APIs da web devido à sua simplicidade, escalabilidade e facilidade de uso. Ele fornece uma abordagem flexível para a construção de sistemas distribuídos e é a base para muitos serviços da web populares e aplicativos modernos.



