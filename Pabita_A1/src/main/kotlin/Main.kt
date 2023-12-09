import parkingcompany.Car
import parkingcompany.ParkingLot
import parkingcompany.ParkingLotEmployee

fun main() {
    println("=================================================")
    println("Demo: Parking cars in the lot")
    println("=================================================")

    parkInParkingLot()

}

fun parkInParkingLot() {

    // 1. Create objects for a ParkingLot class
    val pl1 = ParkingLot("Hanna Avenue", 2, 5.00, 0.00)

    // 2. ParkingLot instance, call the necessary functions to demonstrate what happens when you:
    // a. Park a car in the lot, but do not pay the correct amount.
    pl1.parkCar("CCVT 045", 6, 10.00)

    // b. Park the same car in the lot, and provide the correct cost of parking
    pl1.parkCar("CCVT 045", 6, 30.00)

    // c. Attempt to park another car in a lot, and provide the correct cost of parking
    pl1.parkCar("BHFL 582", 1, 5.00)

    // d. Attempt to park a car in a lot that is full
    pl1.parkCar("AXTM 915", 2, 20.00)

    println()

    // e. Parking lot’s ability to reduce the amount of time remaining for each car in the lot.
    println("================================================")
    println("Demo: Reducing the time of each car in the lot")
    println("=================================================")

    pl1.passTime(3)

    println()
    println("================================================")
    println("Demo: Checking the cars in the lot")
    println("=================================================")


    // ParkingLotEmployee instance
    val plEmp = ParkingLotEmployee()

    // list of license plates to be checked
    var licensePlatesList = mutableListOf("CCVT 045", "BHFL 582", "ZZZZ 000")

    for(licensePlate in licensePlatesList) {
        val result = plEmp.checkVehicle(licensePlate, pl1)

        // check if car is legally parked or not
        if (result == "") {
            println("  Vehicle with license plate $licensePlate is okay. \n")
        } else {
            plEmp.issueParkingTicket(licensePlate, result)
        }
    }

    // collects payment for parking
    println("================================================")
    println("Demo: Collecting money from the parking lot")
    println("=================================================")

    plEmp.collectPayments(pl1)
}
