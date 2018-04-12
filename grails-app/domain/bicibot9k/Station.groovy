package bicibot9k

import bicibot9k.embed.Location
import com.vividsolutions.jts.geom.Coordinate
import com.vividsolutions.jts.geom.GeometryFactory
import com.vividsolutions.jts.geom.Point

class Station {
    String name
    String address
    String addressNumber
    Long zipCode
    String districtCode
    String districtName
    String altitude
    String stationType
    Location location
    Point newLocation
    List nearbyStations

    static hasMany = [nearbyStations: Long]
    static hasOne = [status: Status]
    static embedded = ['location']

    static constraints = {
        id bindable: true
        districtCode nullable: true
        districtName nullable: true
        zipCode nullable: true
        altitude nullable: true
        status nullable: true
        newLocation nullable: true
    }

    def beforeInsert() {
        createPoint()
    }

    def beforeUpdate() {
        createPoint()
    }

    def createPoint() {
        newLocation =  new GeometryFactory().createPoint(new Coordinate(location.lat, location.lon))
    }
}
