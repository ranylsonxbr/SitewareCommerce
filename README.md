# Siteware - Sistema de Gerenciamento de Produtos e Carrinhos

## 📋 Descrição

O Siteware é uma aplicação Spring Boot desenvolvida em Java 17 que oferece um sistema completo de gerenciamento de produtos e carrinhos de compras. A aplicação implementa uma arquitetura de domínio limpo (Clean Architecture) com separação clara entre camadas de apresentação, aplicação, domínio e infraestrutura.

## 🏗️ Arquitetura

O projeto segue os princípios da Clean Architecture com as seguintes camadas:

- **API Layer**: Controllers e interfaces REST
- **Application Layer**: Services e casos de uso
- **Domain Layer**: Entidades de negócio e regras
- **Infrastructure Layer**: Repositórios e acesso a dados

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **SpringDoc OpenAPI (Swagger)**
- **Docker Compose**

## 📁 Estrutura do Projeto

```
src/main/java/br/com/siteware/app/
├── Carrinho/                    # Módulo de Carrinhos
│   ├── application/
│   │   ├── api/                # Controllers e interfaces REST
│   │   └── service/            # Services de aplicação
│   ├── domain/                 # Entidades de domínio
│   └── infra/                  # Repositórios
├── Produto/                    # Módulo de Produtos
│   ├── application/
│   │   ├── api/                # Controllers e interfaces REST
│   │   └── service/            # Services de aplicação
│   ├── domain/                 # Entidades de domínio
│   └── infra/                  # Repositórios
├── ProdutoCarrinho/            # Entidade de relacionamento
├── Handler/                    # Tratamento de exceções
└── SitewareApplication.java    # Classe principal
```

## 🎯 Funcionalidades

### Módulo de Produtos

- ✅ Criar produto
- ✅ Listar todos os produtos
- ✅ Buscar produto por ID
- ✅ Alterar produto
- ✅ Deletar produto

### Módulo de Carrinhos

- ✅ Criar carrinho
- ✅ Adicionar produto ao carrinho
- ✅ Consultar carrinho
- ✅ Alterar produtos do carrinho
- ✅ Remover produto do carrinho

### Sistema de Promoções

O sistema suporta três tipos de promoções:
- **NENHUMA_PROMOCAO**: Sem desconto
- **LEVE_2_PAGUE_1**: Leve 2 e pague 1
- **TRES_POR_DEZ**: 3 produtos por R$ 10,00

## 🛠️ Configuração e Execução

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Docker e Docker Compose
- PostgreSQL

### 1. Clone o repositório

```bash
git clone <url-do-repositorio>
cd Siteware
```

### 2. Configure o banco de dados

O projeto inclui um `docker-compose.yml` para facilitar a configuração do PostgreSQL:

```bash
docker-compose up -d postgres
```

### 3. Configure as variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto:

```env
DATABASE_URL=jdbc:postgresql://localhost:5434/postgres
DB_USERNAME=postgres
DB_PASSWORD=postgres
LOG_LEVEL=DEBUG
```

### 4. Execute a aplicação

```bash
# Usando Maven
./mvnw spring-boot:run

# Ou usando Maven wrapper
mvn spring-boot:run
```

### 5. Acesse a aplicação

- **Aplicação**: http://localhost:8080/siteware
- **Swagger UI**: http://localhost:8080/siteware/swagger-ui

## 📚 API Endpoints

### Produtos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/v1/produto/cria-produto` | Criar novo produto |
| GET | `/v1/produto/busca-todos-produtos` | Listar todos os produtos |
| GET | `/v1/produto/{idProduto}` | Buscar produto por ID |
| PATCH | `/v1/produto/{idProduto}` | Alterar produto |
| DELETE | `/v1/produto/{idProduto}` | Deletar produto |

### Carrinhos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/v1/carrinho` | Criar novo carrinho |
| POST | `/v1/carrinho/{idCarrinho}/produto` | Adicionar produto ao carrinho |
| GET | `/v1/carrinho/{idCarrinho}/produto` | Consultar carrinho |
| PATCH | `/v1/carrinho/{idCarrinho}/produto/{idProdutoCarrinho}` | Alterar produto no carrinho |
| PATCH | `/v1/carrinho/{idCarrinho}/produto/remove/{idProduto}` | Remover produto do carrinho |

## 🗄️ Modelo de Dados

### Entidades Principais

#### Produto
- `idProduto` (Long): Identificador único
- `nome` (String): Nome do produto
- `preco` (BigDecimal): Preço unitário
- `promocoes` (Promocoes): Tipo de promoção aplicável

#### Carrinho
- `id` (Long): Identificador único
- `produtos` (List<ProdutoCarrinho>): Lista de produtos no carrinho
- `dataHoraAbertura` (LocalDateTime): Data/hora de criação
- `dataHoraDaUltimaAlteracao` (LocalDateTime): Última modificação

#### ProdutoCarrinho
- `idProdutoCarrinho` (Long): Identificador único
- `carrinho` (Carrinho): Carrinho associado
- `produto` (Produto): Produto associado
- `nome` (String): Nome do produto
- `promocao` (Promocoes): Promoção aplicada
- `quantidade` (BigDecimal): Quantidade
- `precoUnitario` (BigDecimal): Preço unitário
- `precoTotalBruto` (BigDecimal): Preço total

## 🔧 Configurações

### application.yml

```yaml
server:
  servlet:
    context-path: /siteware

springdoc:
  swagger-ui:
    path: /swagger-ui

spring:
  datasource:
    url: ${DATABASE_URL:jdbc:postgresql://localhost:5432/postgres}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
  jpa:
    hibernate:
      ddl-auto: update
```

## 👥 Autores

- Ranylson Santos Alves
