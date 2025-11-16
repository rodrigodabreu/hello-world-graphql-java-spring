# Hello World GraphQL Java Spring

Um projeto demo de **Forum** utilizando GraphQL com Spring Boot, que permite criar posts e comentários através de uma API GraphQL.

## 🚀 Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework principal
- **Spring GraphQL** - Implementação GraphQL para Spring
- **Spring Web** - Para servidor web
- **Gradle** - Gerenciador de dependências e build
- **GraphiQL** - Interface web para testar queries GraphQL

## 🏗️ Estrutura do Projeto

O projeto implementa um sistema simples de forum com:

- **Posts**: Conteúdo principal com ID e texto
- **Comments**: Comentários associados aos posts
- **Queries**: Busca de posts por ID
- **Mutations**: Criação de posts e comentários

## 📋 Pré-requisitos

- Java 17 ou superior
- Gradle (ou use o wrapper incluído)

## 🔧 Como Executar Localmente

### 1. Clone o repositório

```bash
git clone <url-do-repositório>
cd hello-world-graphql-java-spring
```

### 2. Execute o projeto

```bash
# Usando Gradle Wrapper (recomendado)
./gradlew bootRun

# Ou usando Gradle instalado globalmente
gradle bootRun
```

### 3. Acesse a aplicação

- **API GraphQL**: http://localhost:8080/graphql
- **GraphiQL Interface**: http://localhost:8080/graphiql

## 🔍 Como Usar a API GraphQL

### Acessando o GraphiQL

1. Abra seu navegador e vá para: http://localhost:8080/graphiql
2. Você verá uma interface interativa para testar suas queries

### Exemplos de Queries e Mutations

#### 1. Criar um Post

```graphql
mutation {
	createPost(content: "Meu primeiro post no forum!") {
		id
		content
		comments {
			id
			content
		}
	}
}
```

#### 2. Criar um Comentário

```graphql
mutation {
	createComment(postId: "1", content: "Excelente post!") {
		id
		content
		postId
	}
}
```

#### 3. Buscar um Post por ID

```graphql
query {
	postById(id: "1") {
		id
		content
		comments {
			id
			content
			postId
		}
	}
}
```

#### 4. Exemplo Completo: Criar Post e Comentário

```graphql
# Primeiro, crie um post
mutation CreatePost {
	createPost(content: "Discussão sobre GraphQL com Spring Boot") {
		id
		content
	}
}

# Depois, adicione um comentário (use o ID retornado do post)
mutation AddComment {
	createComment(postId: "1", content: "GraphQL é muito interessante!") {
		id
		content
		postId
	}
}

# Finalmente, busque o post com todos os comentários
query GetPostWithComments {
	postById(id: "1") {
		id
		content
		comments {
			id
			content
			postId
		}
	}
}
```

## 📚 Schema GraphQL

O schema define a estrutura da API:

```graphql
type Post {
	id: ID!
	content: String!
	comments: [Comment!]!
}

type Comment {
	id: ID!
	content: String!
	postId: ID!
}

type Query {
	postById(id: ID!): Post
}

type Mutation {
	createPost(content: String!): [Post]
	createComment(postId: ID!, content: String!): [Comment]
}
```

## 🧪 Executar Testes

```bash
./gradlew test
```

## 📝 Notas Importantes

- O servidor roda na porta **8080** por padrão
- O GraphiQL está habilitado para facilitar o desenvolvimento e testes
- Os dados são armazenados em memória (não persistem entre reinicializações)
- A aplicação suporta CORS para desenvolvimento

## 🛠️ Build para Produção

```bash
# Gerar JAR
./gradlew build

# Executar JAR gerado
java -jar build/libs/hello-world-graphql-java-spring-0.0.1-SNAPSHOT.jar
```

## 📖 Recursos Úteis

- [Documentação Spring GraphQL](https://docs.spring.io/spring-graphql/reference/)
- [GraphQL Java](https://www.graphql-java.com/)
- [GraphQL Specification](https://graphql.org/learn/)
