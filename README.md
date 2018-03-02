# El bicibot

Me caga salir de mi trabajo y tener que:
- Buscar como pendejo alguna estacion de Ecobici con bicis disponibles
- Llegar a mi destino y tener que pasear por la colonia buscando estacion con lugar libre (_**te estoy mirando a ti Tabacalera**_)

Asi que voy a automatizar eso porque `pinche hueva`

## Como levantar el bot
 - Agrega al `application.yml` tus credenciales de Ecobici de la siguiente manera:
    ``` 
    ecobici:
      clientId: misuperid
      secret: misupersecret
    ```
 - Haz desde tu terminal un `./grailsw run-app` para levantarlo en modo de desarrollo