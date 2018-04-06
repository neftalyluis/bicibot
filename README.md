# El bicibot

Me caga salir de mi trabajo y tener que:
- Buscar como pendejo alguna estacion de Ecobici con bicis disponibles
- Llegar a mi destino y tener que pasear por la colonia buscando estacion con lugar libre (_**te estoy mirando a ti Tabacalera**_)

Asi que voy a automatizar eso porque `pinche hueva`

Puedes probar la version mas actual deployada en Heroku: http://morning-sands-48314.herokuapp.com/

## Como levantar el bot
### En entorno de desarrollo
 - Agrega al `application.yml` tus credenciales de Ecobici de la siguiente manera:
 
    ``` 
    ecobici:
      clientId: misuperid
      secret: misupersecret
    ```
 - Haz desde tu terminal un `./grailsw run-app`
### En entorno de produccion
 - Haz desde tu terminal un `./grailsw stage`
 - Ejecuta `java -jar app.jar`

 
 ## Que le falta?
  - Endpoint para enviar estaciones cercanas dada una ubicacion (lat, long)
  - Integracion con API's de Bots (Hangouts, FB Messenger, Twitter?)
  - Documentacion de la API
  - Pruebas (lol)
