package parkingcompany

// Parking Lot Car
// The parking lot is responsible for tracking which cars are parked
// and how much money is collected in parking fees.

// Properties - name : The parking lot’s name
//            - numSpaces: The number of spaces in the parking lot
//            - hourlyRate: The cost of 1 hour of parking in the lot
//            - balance: The total parking fees collected by the parking lot
//            - carsList: A list of cars that have paid for parking in the parking lot

// var carsList :
class ParkingLot(
    var name : String,
    var numSpaces : Int,
    var hourlyRate : Double,
    var balance : Double
    ) {

    // to indicate relationship between ParkingLot and Car class
    // a Parking lot have multiple Cars
   var carsList : MutableList<Car> = mutableListOf()

    // this function checks if a car can be parked in the parking lot or not, and if yes then, adds it to the list
    fun parkCar(licensePlate : String, hoursRequested : Int, amountPaid : Double) {

        println("\nAttempting to park license plate ${licensePlate} for ${hoursRequested} hours.")

        // checks if parking lot is full or not
        // checks if amount paid is sufficient or not
        if (numSpaces <= 0) {
            println("  The parking lot is full")
        } else if ( amountPaid < (hourlyRate * hoursRequested)) {
            print("  The cost is $${hourlyRate * hoursRequested}. You paid $${amountPaid}. ")
            println("Insufficient amount paid")
            println("  Car ${licensePlate} NOT parked")
            println("Space remaining : ${numSpaces}")
        } else if (numSpaces > 0) {
            print("  The cost is $${hourlyRate * hoursRequested}. You paid $${amountPaid}. ")
            this.carsList.add(Car(licensePlate, hoursRequested))
            balance += amountPaid
            numSpaces--
            println("Car ${licensePlate} parked")
            println("Space remaining : ${numSpaces}")
        }
    }

    fun getCars() : String {
        return this.carsList.joinToString("\n")
    }

    // This function simulates time passing.
    // the function should reduce the
    // amount of time remaining for each car in the parking lot by the specified number of hours.
    fun passTime(hours : Int) {
        println("Passing time for ${hours} hours...")

        var hoursRequested = 0
        var licensePlate = ""
        var hoursRemaining = 0

        for (car in carsList) {
            hoursRequested = car.hoursRemaining
            licensePlate = car.licencePlate
            hoursRemaining = hoursRequested - hours

            println("Time remaining for ${licensePlate}: ${hoursRemaining} hours")
        }

    }

    fun totalParkingFeesCollected(): Double {
        return balance
    }


    override fun toString(): String {
       return "${this.getCars()}"
    }
}