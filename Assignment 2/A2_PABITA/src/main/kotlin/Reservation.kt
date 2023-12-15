import kotlin.random.Random

// Reservation class will represent an air ticket reservation.
// The Reservation class inherits all the Flight class attributes and methods.
// child class

class Reservation(
    flNum: String,
    dpAirport : String,
    arrAirport : String,
    flDist : Double,
    var passenger : Traveller,
    var seatNumber : String
) : Flight(flightNumber = flNum, departureAirport = dpAirport, arrivalAirport = arrAirport, flightDistance = flDist) {

    // private reservationId is initialized with a randomly generated 4-digit number between 1000 and 9999
    private val reservationId : Int = generateRandomReservationId()

    // creating getter to allow retrieval of the reservation ID - which is private
    // The reservation ID is not modifiable because it is a read-only property
    fun getReservationId(): Int {
        return reservationId
    }

    /*
      Random.nextInt() - this is a function from the Kotlin standard library
                         to generate a random integer between 1000 and 9999.
   */
    private fun generateRandomReservationId(): Int {
        return Random.nextInt(1000, 10000)
    }


    // calculateCost() - calculates and returns the cost of the reservation
    fun calculateCost() : Double {
       return 100 + (this.flightDistance * 0.12)
    }

    override fun toString(): String {
        return "Passenger : ${passenger.name}" +
                "\nReservation Id : ${reservationId}" +
                "\nFlight Information : " +
                "${super.toString()}" +
                "\nSeat Number : ${seatNumber}"
    }

}

