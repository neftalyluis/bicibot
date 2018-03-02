package bicibot9k

import org.hibernate.validator.constraints.NotBlank
import org.springframework.boot.context.properties.ConfigurationProperties

import javax.validation.constraints.NotNull

@ConfigurationProperties("ecobici")
class EcobiciProperties {

    @NotNull
    @NotBlank
    String clientId

    @NotNull
    @NotBlank
    String secret

}
