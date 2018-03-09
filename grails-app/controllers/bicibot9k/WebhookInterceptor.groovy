package bicibot9k

import bicibot9k.properties.TelegramProperties
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired

class WebhookInterceptor {

    int order = HIGHEST_PRECEDENCE

    @Autowired
    TelegramProperties telegramProperties

    WebhookInterceptor() {
        match controller: 'telegramWebhook'
    }

    boolean before() {
        if (telegramProperties.webhookUrl == params.id) {
            return true
        } else {
            log.error "Bad Webhook parameter from client " +
                    "${request.getHeader("X-Forwarded-For") ?: request.getRemoteAddr()} " +
                    "for controller $controllerName"
            render(view: "/notFound")
            return false
        }
    }
}
