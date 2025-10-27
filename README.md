Projeto Dispositivo IoT API - Desafio de testes automatizados
Este projeto é uma API RESTful simples desenvolvida com Spring Boot, focada no gerenciamento de dispositivos IoT. O projeto também serve como laboratório para demonstrar a implementação de validação de dados (Bean Validation) com mensagens de erro customizadas e a automação de testes de integração e contrato (Cucumber + RestAssured).

Tecnologias Utilizadas
Linguagem: Java 17+

Framework: Spring Boot 3.2.4

API Web: Spring Web

Validação: Spring Boot Starter Validation (Hibernate Validator / Jakarta Validation)

Desenvolvimento: Lombok (para getters/setters)

Testes de Integração e Contrato:

Cucumber (Gherkin)

RestAssured

RestAssured JSON Schema Validator

Estrutura do Projeto
O projeto segue a estrutura padrão do Spring Boot e contém os seguintes componentes focados na solução:

DispositivoIOT.java: O modelo de dados, onde a validação é aplicada (necessário corrigir o @NonNull para @NotBlank).

ValidationExceptionHandler.java: Classe anotada com @RestControllerAdvice que intercepta erros de validação (MethodArgumentNotValidException) e retorna as mensagens de erro customizadas no formato JSON.

MensagemDeErro.java: O modelo customizado usado para formatar as mensagens de erro na resposta (campo e mensagem).

ConsultaDispositivoSteps.java / CadastroDispositivoSteps.java: Classes que contêm os Step Definitions do Cucumber para testes de API.

src/test/resources/schemas/: Diretório onde reside o Schema JSON (contrato dispositivo com sucesso.json) para a validação de contrato.

Como Executar
Pré-requisitos
Java Development Kit (JDK) 17+

Maven