# API REST criada para um teste técnico onde a proposta era simular um sistema de votação.
Nesta API é possivel criar uma pauta de votação, após a criação da pauta,  devemos abrir uma sessão de votação. A sessão de votação tem por padrão uma duração de 1 min caso não seja informado um horario de término.
Após abertura de votação, podemos registrar votos "SIM" ou "NAO" onde recebe apenas 1 votante por pauta.
Também é possível contabilizar os resultados de uma pauta, gerando um resultado de: APROVADO, NEGADO ou EMPATE.


Tecnologias utilizadas:
# Spring Boot
# Java 11
# Lombok
# Azure Cloud
# Mongo DB
# Cosmos DB
# Maven
# CI/CD

Caso deseje rodar localmente, navegar até o diretório que contem o arquivo docker-compose e por um terminal digitar:
docker compose up -d , mudando o apontamento para o docker em application.properties e startar a aplicação utilizando uma IDE de sua preferência
