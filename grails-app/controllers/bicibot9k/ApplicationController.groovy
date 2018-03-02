package bicibot9k

import grails.core.GrailsApplication
import grails.util.Environment
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager
    def bootstrapService

    def index() {
        bootstrapService.addNearbyStations()
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }
}
