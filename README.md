# 🌱 Especies Endêmicas API

API desenvolvida em **Spring Boot** para gerenciamento de espécies endêmicas, integrando dados de uma API externa (**Amazing Endemics Species - AES**) e oferecendo operações de CRUD para novas espécies.  

O projeto foi construído aplicando **boas práticas de Clean Code e SOLID**, além de contar com tratamento de exceções centralizado e sincronização de dados externos.

---

## 📌 Funcionalidades

- 🔄 **Sincronização de espécies** com a API externa (AES).  
- 🎲 **Busca de espécie aleatória** diretamente da API externa.  
- 📖 **Listagem de todas as espécies** cadastradas no banco de dados.  
- 🔍 **Busca por ID** de espécie.
- 🔄 **Sincronização de países** com a API externa (AES).
- 📖 **Listagem de todos os países** cadastrados no banco de dados.
- 🔍 **Busca por ID** de país.  
- ➕ **Cadastro de novas espécies** no sistema. (em andamento) 
- ✏️ **Atualização de espécies** existentes. (em andamento) 
- ❌ **Exclusão de espécies** cadastradas. (em andamento)
- ⚠️ **Tratamento centralizado de exceções** com `@RestControllerAdvice`, retornando mensagens claras em JSON.  

---

## 🏗️ Estrutura do Projeto
```
src/main/java/br/com/rhssolutions/especiesAPI/
│
├── controller/ # Endpoints REST
├── doc/ # documentação da API
├── domain/ # Entidades do domínio
├── dto/ # Mapeamento entre entidades e DTOs
├── exception/ # Exceptions customizadas e handler global
├── repository/ # Repositórios JPA
├── service/ # Regras de negócio
│ ├── client/ # Cliente da API externa AES
│ └── impl/ # Implementações de serviços
└── EspeciesApiApplication.java
```

---

## ⚙️ Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Web**
- **Lombok**
- **MySQL8**
- **H2 Database** (para desenvolvimento local)
- **Maven**
- **Docker & Docker Compose**

---

## ▶️ Como Executar Localmente (sem Docker)

1. Clone este repositório:
   ```bash
   git clone https://github.com/RafaSamm/EspeciesEndemicas.git
   cd EspeciesEndemicas
   
2. Compile e rode o projeto:
   ```bash
   ./mvnw spring-boot:run

3. Acesse a API localmente em:
   ```bash
   http://localhost:8080
   
4. Acesse a API via host Docker:
   ```bash
   http://localhost:8081
   
5. Para testes com deploy remoto:
   ```
   https://especiesendemicas.onrender.com
   ```


## 🐳 Como Executar com Docker e Docker Compose
1. Certifique-se de ter Docker e Docker Compose instalados.
2. Build e start dos containers:
```
docker-compose up --build
```
3. Serviços disponíveis:

| Serviço     | URL       | Porta Host | Porta Container |
| ----------- | --------- | ---------- | --------------- |
| MySQL DB    | localhost | 3307       | 3306            |
| EspeciesAPI | localhost | 8081       | 8080            |


**Observação: Ao usar o host do container MySQL (mysqldb), configure o SPRING_DATASOURCE_URL no application-prod.properties como:**
```
spring.datasource.url=jdbc:mysql://mysqldb:3306/especies_db?useSSL=false&serverTimezone=UTC
```
   
 ## 📡 Endpoints Principais

🔄 Sincronizar espécies externas
  ```bash
    POST /especies/sincronizar
  ```
🎲 Buscar espécie aleatória
  ```bash
    POST /especies/busca
  ```
📖 Listar todas as espécies
  ```bash
    GET /especies/listar
  ```
🔍 Buscar espécie por ID
  ```
    GET /especies/{id}
  ```
🔄 Sincronizar países
  ```bash
    POST /paises/sincronizar
  ```
📖 Listar todos o países
  ```bash
    GET /paises/listar
  ```
🔍 Buscar país por ID
  ```
    GET /paises/buscar/{id}
  ```





