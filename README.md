<div align="center">

# 💈 BarberPro API

### API RESTful para Gerenciamento de Barbearias

Sistema back-end desenvolvido para automatizar e gerenciar as operações de uma barbearia, incluindo agendamentos, clientes, barbeiros e serviços.

<br>

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

</div>

---

# 📖 Sobre o projeto

O **BarberPro API** é um sistema robusto de back-end criado para facilitar a gestão de barbearias. A aplicação fornece endpoints seguros para gerenciar o catálogo de serviços, cadastrar clientes e barbeiros, além de controlar a agenda de horários e permitir avaliações.

Construído com **Java e Spring Boot**, o projeto implementa as melhores práticas de desenvolvimento, incluindo autenticação via JWT, arquitetura em camadas e documentação automatizada da API.

---

# ✨ Funcionalidades

- **Autenticação e Autorização:** Login seguro com JWT (JSON Web Token) e controle de acessos (Filtros de Token e Security Config).
- **Gestão de Usuários:** CRUD de Clientes e Barbeiros com distinção de perfis.
- **Catálogo de Serviços:** Gerenciamento dos serviços oferecidos (cortes, barba, etc).
- **Agendamentos:** Controle completo de marcação de horários entre clientes e barbeiros, manipulando o status do agendamento.
- **Sistema de Avaliações:** Permite que clientes avaliem os serviços prestados.
- **Documentação:** API documentada com Swagger/OpenAPI.
- **Containerização:** Ambiente pré-configurado com Docker Compose.
- **Tratamento de Erros:** Padronização de respostas de erro utilizando `GlobalExceptionHandler`.

---

# 🛠️ Tecnologias

## Back-End
- Java
- Spring Boot
- Spring Security (Autenticação JWT)
- Spring Data JPA
- Maven

## Ferramentas e Boas Práticas
- Swagger / OpenAPI (Documentação)
- Docker & Docker Compose
- Padrão DTO (Data Transfer Object)
- Tratamento global de exceções

---

# 📂 Estrutura do Projeto

O projeto segue a arquitetura padrão MVC/Camadas do Spring:

```text
 ├── src/main/java/com/barberpro/dsc/
 │   ├── config/         # Configurações de Segurança (JWT, Filtros) e Swagger
 │   ├── controllers/    # Endpoints da API (Agendamento, Autenticação, etc.)
 │   ├── dto/            # Objetos de Transferência de Dados (Request/Response)
 │   ├── models/         # Entidades de Domínio (Agendamento, Barbeiro, Cliente...)
 │   ├── repositories/   # Interfaces de acesso ao BD (Spring Data JPA)
 │   └── services/       # Lógica de negócios, autenticação e validações
 ├── docker-compose.yml  # Configuração de containers (Banco de dados)
 ├── pom.xml             # Dependências do Maven
 └── README.md
```

---

# 🚀 Como executar

### Pré-requisitos
- Java 11 ou superior
- Maven
- Docker (Opcional, mas recomendado para levantar o banco de dados)

```bash
# Clonar o projeto
git clone https://github.com/edsonplz/barberpro.git

# Entrar na pasta do projeto
cd barberpro

# Subir os containers do Docker (Banco de Dados)
docker-compose up -d

# Instalar dependências e rodar a aplicação
./mvnw spring-boot:run
```

A documentação do Swagger geralmente fica disponível em `http://localhost:8080/swagger-ui.html` após a execução do projeto.

---

# 👨‍💻 Autor

## João Edson

Desenvolvedor Front-End | React • TypeScript • Spring Boot

[LinkedIn](https://www.linkedin.com/in/jo%C3%A3o-edson-b88018333/)

[Portfólio](https://portfolio-edson.onrender.com/)

---

⭐ Se este projeto foi útil, deixe uma estrela no repositório.
