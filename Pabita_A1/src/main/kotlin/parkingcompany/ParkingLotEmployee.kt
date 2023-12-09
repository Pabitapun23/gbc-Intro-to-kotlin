package parkingcompany

// This class represents a person who works for the parking lot company.
// The employee’s job is to monitor the parking lots and collect the fees accumulated at the parking lot.
class ParkingLotEmployee {

    // check if the specified license plate belongs to a car that is legally parked in
    // the specified parking lot.
    fun checkVehicle(licensePlate : String, parkingLot : ParkingLot) : String {

        println("Checking license plate ${licensePlate}")

        for (car in parkingLot.carsList) {
            if (car.licencePlate == licensePlate && car.hoursRemaining > 0) {
                return ""
            } else {
                    return "Car with license plate $licensePlate is parked overtime."
            }
        }
        return "Vehicle with license plate $licensePlate is illegally parked!"
    }

    // This function displays a parking ticket for the vehicle with the specified license plate.
    fun issueParkingTicket(licensePlate : String, reason : String) {
        println("==== PARKING VI0LATION ====")
        println("Vehicle with ${licensePlate} is in violation of parking rules")
        println("reason : ${reason}")
        println("Fine : $100 \n")
    }

    // This function removes all the money collected by the specified parking lot
    fun collectPayments(parkingLot: ParkingLot) {
        val collectedAmount = parkingLot.balance

        println("The parking fees collected at ${parkingLot.name} are: $$collectedAmount")
        parkingLot.balance = 0.0
        println("Withdrawing parking fees.")
        println("Money remaining at Hanna Avenue: $${parkingLot.balance}")
    }


}