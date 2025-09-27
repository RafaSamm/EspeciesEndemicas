# 🌱 Especies Endêmicas API

API desenvolvida em **Spring Boot** para gerenciamento de espécies endêmicas, integrando dados de uma API externa (**Amazing Endemics Species - AES**) e oferecendo operações de CRUD para novas espécies.  

O projeto foi construído aplicando **boas práticas de Clean Code e SOLID**, além de contar com tratamento de exceções centralizado e sincronização de dados externos.

---

## 📌 Funcionalidades

- 🔄 **Sincronização de espécies** com a API externa (AES).  
- 🎲 **Busca de espécie aleatória** diretamente da API externa.  
- 📖 **Listagem de todas as espécies** cadastradas no banco de dados.  
- 🔍 **Busca por ID** de espécie.
- 🔍 **Busca/salva países** com a API externa (AES).
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
- **H2 Database** (por enquanto configurado)
- **Maven**

---

## ▶️ Como Executar

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

4. Ou acesse a API para testes já com deploy:
   ```
   https://especiesendemicas.onrender.com
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





