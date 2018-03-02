package bicibot9k

import bicibot9k.embed.Availability

class Status {

    String status
    Availability availability

    static belongsTo = [station: Station]
    static embedded = ['availability']

    static constraints = {
    }
}
