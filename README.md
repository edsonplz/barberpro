# ✂️ BarberPro API

O **BarberPro** é a espinha dorsal de um sistema de agendamentos que conecta **clientes** a **barbeiros**.  
A API foi construída para ser **robusta**, **segura** e **escalável**, gerenciando toda a lógica de negócio, desde o cadastro de usuários até a avaliação dos serviços prestados.

---

## 🚀 Funcionalidades

- 🔐 **Autenticação Segura**  
  Implementa um fluxo de autenticação via **JWT (JSON Web Tokens)**, separando as rotas públicas das rotas que exigem login.

- 👤 **Gestão de Perfis**  
  Permite o cadastro e gerenciamento de **Clientes** e **Barbeiros**, cada um com suas permissões e dados específicos.

- 🗓️ **Agendamento Inteligente**  
  O sistema permite criar agendamentos e valida ativamente **conflitos de horário**, garantindo que um barbeiro não tenha dois clientes ao mesmo tempo.

- ⭐ **Sistema de Feedback**  
  Após um serviço concluído, clientes podem deixar uma **avaliação (nota e comentário)**, e o sistema recalcula automaticamente a **média de satisfação do barbeiro**.

- ✂️ **Catálogo de Serviços**  
  Administradores podem **gerenciar (CRUD)** todos os serviços que a barbearia oferece, como cortes, barbas e tratamentos.

- 📄 **Documentação Dinâmica**  
  Toda a API é documentada com **Swagger**, criando uma interface interativa para explorar e testar cada endpoint.

---

## 🛠️ Stack Tecnológica

| Categoria          | Tecnologia                               |
|--------------------|------------------------------------------|
| **Linguagem & Core** | Java 21 & Spring Boot 3.3.3             |
| **Banco de Dados** | PostgreSQL (orquestrado com Docker)      |
| **Segurança**      | Spring Security, JWT & BCryptPasswordEncoder |
| **Acesso a Dados** | Spring Data JPA & Hibernate              |
| **Validação**      | Jakarta Bean Validation                  |
| **Documentação**   | Springdoc OpenAPI (Swagger UI)           |
| **Build & Pacotes**| Maven                                    |

---

## ⚡ Rodando o Projeto Localmente

### ✅ Pré-requisitos

- JDK 21+
- Docker & Docker Compose

---

### 1. Preparar o Ambiente

Clone este repositório para a sua máquina:

```bash
git clone https://github.com/edsonplz/barberpro.git
cd barberpro
```

---

### 2. Subir o Banco de Dados

Use o Docker Compose para iniciar o contêiner do **PostgreSQL**.  
O arquivo `docker-compose.yml` já contém todas as senhas e configurações.

```bash
docker-compose up -d
```

O banco estará acessível em: **localhost:5432**

---

### 3. Executar a API

Com o banco rodando, inicie a aplicação Spring Boot:

```bash
mvn spring-boot:run
```

A API estará disponível em:  
👉 **http://localhost:8080**

---

## 📖 Explorando os Endpoints

A melhor forma de interagir com a **BarberPro API** é através da documentação do **Swagger**.  
Nela, você pode ver todos os **endpoints**, **DTOs** e executar **requisições de teste**.

▶️ Acesse em:  
👉 **http://localhost:8080/swagger-ui/index.html**

---

## 📜 Licença

Este projeto é de uso acadêmico/profissional.  
Sinta-se à vontade para contribuir e sugerir melhorias. 🚀