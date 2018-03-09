package bicibot9k

import bicibot9k.properties.TelegramProperties
import grails.gorm.transactions.Transactional
import groovyx.net.http.HttpBuilder
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

@Transactional
class TelegramAPIService implements InitializingBean {

    @Autowired
    TelegramProperties telegramProperties

    private http

    void afterPropertiesSet() throws Exception {
        http = HttpBuilder.configure {
            request.uri = "https://api.telegram.org/bot${telegramProperties.token}"
        }
    }

}