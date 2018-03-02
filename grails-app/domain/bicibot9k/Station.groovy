package bicibot9k

import bicibot9k.embed.Location

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
    }
}
