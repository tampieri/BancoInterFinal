Instruções para teste da aplicação back end

Rode o projeto no CMD com o comando: mvn spring-boot:run

Na pasta resource/h2 contem um arquivo .sql que popula o banco de dados para uma carga inicial. 
no carregamento do sistema as tabelas e a carga inicial são geradas automaticamente.

No aplication.properties tem as configurações do banco a H2 e a porta utilizada que é a 8084.

Os testes foram realizados com a aplicação rodando e utilizando a ferramenta Postman 
os dois contextos utilizados são:
GET list:
http://localhost:8084/jobs
http://localhost:8084/tasks

POST
http://localhost:8084/jobs
    {
        "id": 6,
        "name": "JOB 06",
        "active": false,
        "tasks": []
    }
    
http://localhost:8084/tasks
    {
        "id": 2,
        "name": "TASK 03",
        "weight": 10,
        "completed": true,
        "createdAt": "2018-08-14T20:09:33.095+0000"
    }

PUT
http://localhost:8084/jobs/2
{
    "id": 2,
    "name": "JOB 021",
    "active": false
}

http://localhost:8084/tasks/1
    {
        "id": 1,
        "name": "1TASK 02",
        "weight": 111,
        "completed": true,
        "createdAt": "2018-08-14T20:55:41.379+0000"
    }

DELETE
http://localhost:8084/jobs/2    
http://localhost:8084/tasks/2

foi criado um metodo com a anotation de test: com.higor.demo.BancoInterApiTestFinalApplicationTests.contextLoads()
este metodo chama todas os metodos que esta classe possui todas as principais funcionalidades com interação manual ao banco.

Cada um possui sua propria controller e os metodos com as funcionalidades.

no diretorio /BancoInterApiTestFinal/src/main/webapp existe arquivos com a extensão .jsp para testes mas os 
mesmos ainda nao estão completamente confiaveis necessitam de configurações. Mas não fazem parte do objetivo principal do projeto 
no caso seria um plus somente.