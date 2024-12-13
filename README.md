![Programação-Arquitetura Java](https://github.com/jacqueline-oliveira/3698-java-clean-architecture/assets/66698429/0191ea20-432f-4583-a391-f01558004fb9)
![](https://img.shields.io/github/license/alura-cursos/android-com-kotlin-personalizando-ui)

# CodeChella

App de simulação de um site para venda de ingressos de eventos diversos

## 🔨 Objetivos do projeto

- Conhecer os diferentes tipos de arquitetura de software;
- Aprender os princípios da Clean Architecture;
- Implementar um projeto com separação de responsabilidades e isolamento do domínio;
- Entender sobre entidades, objetos de valor, casos de uso, repositórios e controladores;
- Analisar os prós e contras de arquiteturas que utilizam muitas camadas de abstração.

## Endpoints

- Cadastrar usuário
```
curl --location 'http://localhost:8080/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cpf":"000.000.000-00",
    "nome":"Carlos",
    "nascimento":"2000-01-01",
    "email":"carlos@teste.com"
}'
```

- Buscar todos os usuários
```
curl --location 'http://localhost:8080/usuarios'
```