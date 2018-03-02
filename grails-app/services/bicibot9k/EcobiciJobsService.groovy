package bicibot9k

import grails.gorm.transactions.Transactional
import groovy.json.JsonOutput
import org.springframework.scheduling.annotation.Scheduled

@Transactional
class EcobiciJobsService {

    boolean lazyInit = false
    def bootstrapService

    @Scheduled(fixedRate = 30000L)
    void updateStateOfStations() {
        log.info "Se actualizo Status de Estaciones"
        bootstrapService.updateStatus()
    }
}
