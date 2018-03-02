package bicibot9k

import groovyx.net.http.HttpBuilder
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

class EcobiciAPIService implements InitializingBean {

    @Autowired
    EcobiciProperties ecobiciProperties

    private String accessToken = ""
    private String refreshToken = ""
    private http

    void afterPropertiesSet() throws Exception {
        setUpHttp()
        getAccessToken(ecobiciProperties.clientId, ecobiciProperties.secret)
    }


    def stations() {
        def result = http.get {
            request.uri.path = '/api/v1/stations.json'
            request.uri.query = [access_token: accessToken]
        }

        return result.stations
    }

    def status() {
        def result = http.get {
            request.uri.path = '/api/v1/stations/status.json'
            request.uri.query = [access_token: accessToken]
        }

        return result.stationsStatus
    }

    private void setUpHttp() {
        http = HttpBuilder.configure {
            request.uri = "https://pubsbapi.smartbike.com"
        }
    }

    private void getAccessToken(String clientId, String secret) {
        def result = http.get {
            request.uri.path = '/oauth/v2/token'
            request.uri.query = [client_id: clientId, client_secret: secret, grant_type: 'client_credentials']
        }

        accessToken = result.access_token
        refreshToken = result.refresh_token
    }

}
