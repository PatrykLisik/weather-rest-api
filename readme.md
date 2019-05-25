# Nierelacyjne bazy danych gr 5

## Create cassandra instance with port 9042 exposed
`docker run --name cassandra-db -d  -p 9042:9042 cassandra:latest`

---

## Run docker compose
`cd ./docker`

`docker-compose up --build`
