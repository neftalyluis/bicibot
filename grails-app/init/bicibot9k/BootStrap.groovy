package bicibot9k

class BootStrap {

    def bootstrapService

    def init = { servletContext ->
        bootstrapService.createStations()
        log.info "Se han persistido ${Station.count} estaciones"
    }

    def destroy = {
    }
}
