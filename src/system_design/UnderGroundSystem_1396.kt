package system_design


fun main() {
    val syste = UnderGroundSystem_1396()
    println(syste.checkIn(45, "Leyton", 3))
    syste.checkIn(32, "Paradise", 8)
    syste.checkIn(27, "Leyton", 10)
    syste.checkOut(45, "Waterloo", 15)
    syste.checkOut(27, "Waterloo", 20)
    syste.checkOut(32, "Cambridge", 22)
    println(syste.getAverageTime("Paradise", "Cambridge"))
    println(syste.getAverageTime("Leyton", "Waterloo"))
    syste.checkIn(10, "Leyton", 24)
    println(syste.getAverageTime("Leyton", "Waterloo"))
    syste.checkOut(10, "Waterloo", 38)
    println(syste.getAverageTime("Leyton", "Waterloo"))
}

class UnderGroundSystem_1396 {
    private var currentTripMap: MutableMap<Int, Trip> = HashMap()
    private var routeMap: MutableMap<String, Route> = HashMap()

    fun checkIn(id: Int, stationName: String, t: Int) {
        if (!currentTripMap.containsKey(id)) {
            val trip = Trip()
            trip.checkIn(stationName, t)
            currentTripMap[id] = trip
        }
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        if (currentTripMap.containsKey(id)) {
            val passenger = currentTripMap[id]!!
            passenger.checkout(stationName, t)
            val routeKey = passenger.checkinLocation + "," + passenger.checkoutLocation
            val route = routeMap.getOrDefault(routeKey, Route(passenger.checkinLocation, passenger.checkoutLocation))
            route.addTrip(passenger.checkinTime, passenger.checkoutTime)
            routeMap[routeKey] = route
            currentTripMap.remove(id)
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        return routeMap["$startStation,$endStation"]?.averageTime?:0.0
    }


}

class Trip {

    var checkoutTime = 0
    var checkoutLocation: String = ""
    var checkinLocation: String = ""
    var checkinTime = 0

    fun checkIn(checkinLocation: String, checkinTime: Int) {
        this.checkinLocation = checkinLocation
        this.checkinTime = checkinTime

    }

    fun checkout(checkoutLocation: String, checkoutTime: Int) {
        this.checkoutLocation = checkoutLocation
        this.checkoutTime = checkoutTime
    }
}

class Route(var startStation: String, var endStation: String?) {
    var totalNumberOfTrips = 0
    var totalTimeSpentInTrips: Long = 0

    val averageTime: Double
        get() = totalTimeSpentInTrips.toDouble() / totalNumberOfTrips

    fun addTrip(startTime: Int, endTime: Int) {
        totalTimeSpentInTrips += (endTime - startTime).toLong()
        totalNumberOfTrips++
    }
}