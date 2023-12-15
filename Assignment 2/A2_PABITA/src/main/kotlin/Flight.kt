// Parent class for Reservation
open class Flight(
    var flightNumber : String,
    var departureAirport : String,
    var arrivalAirport : String,

    // flight distance between the arrival and departure cities in Miles
    var flightDistance : Double
    ) {

    override fun toString(): String {
        return "Flight : $flightNumber" +
                "\nDeparture Airport : $departureAirport " +
                "\narrivalAirport : $arrivalAirport " +
                "\nflightDistance : $flightDistance "
    }
}