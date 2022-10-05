# ACME API
### _Assessment Jennifer Omena - Bloco Java_

# Usuário

## GET http://localhost:8082
### Verifica se a api foi conectada.

```sh
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 9
Date: Wed, 05 Oct 2022 20:45:07 GMT
Keep-Alive: timeout=60
Connection: keep-alive

Conectou!

Response code: 200; Time: 4ms (4 ms); Content length: 9 bytes (9 B)
```

## GET http://localhost:8082/usuarios
### Consulta todos os usuário

```sh
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 20:48:09 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[
  {
    "id": 1,
    "nome": "Jennifer Omena",
    "email": "jennifer@omena.com",
    "password": "123456",
    "username": "jenniferomena"
  },
  {
    "id": 2,
    "nome": "Wanir Estevez",
    "email": "wanir@estevez.com",
    "password": "123456",
    "username": "wanirestevez"
  },
  {
    "id": 3,
    "nome": "Jéssica Estevez",
    "email": "jessica@estevez.com",
    "password": "123456",
    "username": "jessicaestevez"
  },
  {
    "id": 4,
    "nome": "Marta Omena",
    "email": "marta@omena.com",
    "password": "123456",
    "username": "martaomena"
  },
  {
    "id": 7,
    "nome": "Giselle Lessa",
    "email": "giselle@lessa.com",
    "password": "123456",
    "username": "gisellelessa"
  },
  {
    "id": 8,
    "nome": "Guilherme Omena",
    "email": "guilherme@omena.com",
    "password": "123456",
    "username": "guilhermeomena"
  }
]
Response file saved.
> 2022-10-05T174809.200.json

Response code: 200; Time: 1101ms (1 s 101 ms); Content length: 646 bytes (646 B)
```
## GET http://localhost:8082/usuarios/4
### Consulta usuário pelo id passado como parametro

```sh
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 20:49:50 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 4,
  "nome": "Marta Omena",
  "email": "marta@omena.com",
  "password": "123456",
  "username": "martaomena"
}
Response file saved.
> 2022-10-05T174950.200.json

Response code: 200; Time: 974ms (974 ms); Content length: 99 bytes (99 B)
```

## POST http://localhost:8082/usuarios

```sh
 Content-Type: application/json

 {
    "nome": "Leonardo Junger",
    "email": "leonardo@junger.com",
    "password": "123456",
    "username": "leonardojunger"
}
```

### Cadastra usuário

```sh
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 20:51:46 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 9,
  "nome": "Leonardo Junger",
  "email": "leonardo@junger.com",
  "password": "$2a$10$rUPBRo5b.oCjGTKBOXpeW.IxHnTSzGjaSCM38uti6zHT3oT6inv/u",
  "username": "leonardojunger"
}
Response file saved.
> 2022-10-05T175146.200.json

Response code: 200; Time: 780ms (780 ms); Content length: 165 bytes (165 B)
```

## PUT http://localhost:8082/usuarios/7

```sh
Content-Type: application/json

{
  "nome": "Giselle Estevez",
  "username": "giselleestevez",
  "email": "giselle@estevez.com",
  "password": "123456"
}
```

### Atualiza usuário pelo id passado como parametro

```sh
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 20:54:59 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 7,
  "nome": "Giselle Estevez",
  "email": "giselle@estevez.com",
  "password": "$2a$10$53va0LVPC38rNizKYSYR0OnIwsili0AeDw9zVdfar7rIxxibRpEQu",
  "username": "giselleestevez"
}
Response file saved.
> 2022-10-05T175459.201.json

Response code: 201; Time: 945ms (945 ms); Content length: 165 bytes (165 B)
```

## DELETE http://localhost:8082/usuarios/2
### Deleta um usuário pelo id passado como parametro

```sh
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 18
Date: Wed, 05 Oct 2022 20:56:22 GMT
Keep-Alive: timeout=60
Connection: keep-alive

Usuário excluido.

Response code: 200; Time: 706ms (706 ms); Content length: 17 bytes (17 B)
```


# Produtos


## GET http://localhost:8082/produtos

```sh
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 21:00:34 GMT
Keep-Alive: timeout=60
Connection: keep-alive

[
  {
    "id": 1,
    "nome": "Laptop",
    "marca": "Samsung",
    "valor": "R$ 1.000,00"
  },
  {
    "id": 2,
    "nome": "monitor",
    "marca": "aoc",
    "valor": "R$ 768,98"
  },
  {
    "id": 5,
    "nome": "Mochila",
    "marca": "Nike",
    "valor": "R$ 99,99"
  }
]
Response file saved.
> 2022-10-05T180034.200.json

Response code: 200; Time: 961ms (961 ms); Content length: 186 bytes (186 B)

```
## GET  http://localhost:8082/produtos/2
### Consulta Produto por id

```sh
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 21:01:38 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 2,
  "nome": "monitor",
  "marca": "aoc",
  "valor": "R$ 768,98"
}
Response file saved.
> 2022-10-05T180138.200.json

Response code: 200; Time: 1085ms (1 s 85 ms); Content length: 59 bytes (59 B)
```

## GET  http://localhost:8082/produtos/gerarCsv/1
### Gerar Csv do Produto por id

```sh
HTTP/1.1 404 
Content-Type: text/plain;charset=UTF-8
Content-Length: 24
Date: Wed, 05 Oct 2022 21:02:06 GMT
Keep-Alive: timeout=60
Connection: keep-alive

Lista de Produtos Vazia.

Response code: 404; Time: 952ms (952 ms); Content length: 24 bytes (24 B)
```

## POST http://localhost:8082/produtos

```sh
Content-Type: application/json

{
  "nome": "Mochila",
  "marca": "Nike",
  "valor": "R$ 99,99"
}
```
### Cadastra um produto

```sh
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 21:02:52 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 6,
  "nome": "Mochila",
  "marca": "Nike",
  "valor": "R$ 99,99"
}
Response file saved.
> 2022-10-05T180252.201.json

Response code: 201; Time: 684ms (684 ms); Content length: 59 bytes (59 B)
```

## PUT http://localhost:8082/produtos/2

```sh
Content-Type: application/json

{
  "nome": "monitor",
  "marca": "aoc",
  "valor": "R$ 768,98"
}
```
### Atualiza produto pelo id passado como parametro

```sh
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Wed, 05 Oct 2022 21:03:43 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "id": 2,
  "nome": "monitor",
  "marca": "aoc",
  "valor": "R$ 768,98"
}
Response file saved.
> 2022-10-05T180343.201.json

Response code: 201; Time: 689ms (689 ms); Content length: 59 bytes (59 B)
```

## DELETE http://localhost:8082/produtos/6
### Deleta um produto pelo id passado como parametro

```sh
HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 17
Date: Wed, 05 Oct 2022 21:04:30 GMT
Keep-Alive: timeout=60
Connection: keep-alive

Produto excluido.

Response code: 200; Time: 842ms (842 ms); Content length: 17 bytes (17 B)
```