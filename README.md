# Projeto de Automação de Testes de API com RestAssured

Este é um projeto de estudo para a criação de um framework de automação de testes de API, utilizando a API pública [ReqRes](https://reqres.in/) como alvo.

O objetivo é demonstrar as melhores práticas na escrita de testes de API com Java, cobrindo as principais operações CRUD e preparando o projeto para ser executado em um ambiente de Integração Contínua com Jenkins.

---

### 🛠️ Tecnologias Utilizadas

* **Java 21:** Linguagem de programação base.
* **Maven:** Ferramenta de gerenciamento de dependências e build do projeto.
* **RestAssured 5:** Biblioteca principal para fazer as requisições e asserções nas APIs REST.
* **JUnit 5:** Framework para escrever e executar os testes.
* **Hamcrest:** Biblioteca de "matchers" para criar asserções mais legíveis e flexíveis.

---

### 📋 Pré-requisitos

Antes de executar o projeto, garanta que você tem os seguintes softwares instalados e configurados no seu sistema:

1.  **JDK 21 (ou superior):** A variável de ambiente `JAVA_HOME` deve estar configurada.
2.  **Apache Maven:** O Maven deve estar configurado no `Path` do seu sistema.
    * Você pode verificar ambas as instalações rodando `java -version` e `mvn -v` no seu terminal.

---

### 🚀 Como Executar os Testes

1.  Clone este repositório para a sua máquina local:
    ```bash
    git clone [https://github.com/seu-usuario/api-reqres-tests.git](https://github.com/seu-usuario/api-reqres-tests.git)
    ```

2.  Navegue até a pasta raiz do projeto pelo terminal:
    ```bash
    cd api-reqres-tests
    ```

3.  Execute o comando do Maven para rodar a suíte de testes completa:
    ```bash
    mvn test
    ```

Após a execução, os relatórios dos testes serão gerados na pasta `target/surefire-reports`.

---