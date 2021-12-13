# Pokemon-API
Projeto em java para leitura da API publica https://pokeapi.co/


## Utilização

*O setup do projeto foi feito utilizando PostgreSQL utilizando a porta padrão 5432 com usuário e senha "postgres" e "159753" respectivamente.


#### Endpoints da API

* GetById

Recebe o ID do pokemon a ser buscado

``` 
http://localhost:8080/api/pokemon/2
```

* GetAll 

Recebe dois parametros para buscar a lista de pokemons, "limit" que representa a quantidade de pokemons a ser buscado e "offset" que representa o pokemon inicial da lista.

``` 
http://localhost:8080/api/pokemon?limit=100&offset=200
```

## Observações

Como não haveria condições de implementar de forma satisfatória a persistencia no banco de dados e/ou cache sem comprometer o funcionamento dos endpoints a tempo, optei por não implementa-los.

 - Projeto executado entre os dias 09/12 a 11/12.