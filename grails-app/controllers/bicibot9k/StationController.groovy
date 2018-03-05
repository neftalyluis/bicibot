package bicibot9k

class StationController {

    def index() {
        def stations = Station.all
        [stationList: stations]
    }

    def show() {
        def station = Station.get(params.long('id'))
        [station: station]
    }

    def nearby() {
        def nearby = Station.executeQuery(
                "SELECT s FROM Station s JOIN s.nearbyStations ns WHERE ns = :nearbyStation",
                [nearbyStation: params.long('id')]
        )

        render(view: "index", model: [stationList: nearby])
    }
}
