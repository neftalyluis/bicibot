package bicibot9k

import bicibot9k.embed.Availability
import grails.gorm.transactions.Transactional

@Transactional
class BootstrapService {

    def ecobiciAPIService

    def createStations() {
        def apiStations = ecobiciAPIService.stations()
        def entityStations = apiStations.collect { station -> return new Station(station) }
        Station.saveAll(entityStations)
    }

    def updateStatus() {
        ecobiciAPIService.status().each { entry ->
            def station = Station.get(entry.id)
            def statusEntity = station.status
            if (statusEntity) {
                statusEntity.status = entry.status
                statusEntity.availability = entry.availability
            } else {
                statusEntity = new Status(status: entry.status, availability: new Availability(entry.availability), station: station)
            }
            statusEntity.save(failOnError: true)
        }
    }

}
