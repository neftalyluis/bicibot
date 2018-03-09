package bicibot9k.properties

import org.hibernate.validator.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties

import javax.validation.constraints.NotNull

@ConfigurationProperties("telegram")
class TelegramProperties {

    @NotNull
    @NotBlank
    String webhookUrl

    @NotNull
    @NotBlank
    String token

}
