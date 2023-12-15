fun main() {

    // create empty list of Traveller objects, Flight objects and Flight Reservation objects
    val travellerList = mutableListOf<Traveller>()
    val flightList = mutableListOf<Flight>()
    val reservationList = mutableListOf<Reservation>()


    // Adding passengers to the list of travellerList:
    val p1 = Traveller("Bob Smith", "bob@gmail.com", 10000)
    travellerList.add(p1)
    val p2 = Traveller("Abigail Diaz", "abigail@gmail.com", 1231)
    travellerList.add(p2)
    val p3 = Traveller("Carmen Pope","carmen@gmail.com", 92129)
    travellerList.add(p3)


    // Adding flightList into the list of flightList:
    val f1 = Flight("AA281", "DFW", "ICN", 6835.70)
    flightList.add(f1)
    val f2 = Flight("AC306", "PHX", "YUL", 2291.00)
    flightList.add(f2)
    val f3 = Flight("WN3855", "PHX", "STL", 1261.38)
    flightList.add(f3)


    // Section 1: Searching for a Traveller and determining if a passport is valid
    println("------------ Searching for a Traveller ----------")

    // this variable is boolean and checks whether traveller exists or not
    var travellerFound = false
    for (traveller in travellerList) {
        if (traveller.name.contains("Smith")) {
            println("Traveller found.")
            println(traveller)

            travellerFound = true
            // Exit the loop once a matching traveler is found
            break
        }
    }

    // if travellerFound = false - means if traveller is not found then return error msg
    if (!travellerFound) {
        println("No matching travellerList found")
    }

    // Section 2: Is the passport valid?
    println("------------ CHECKING PASSPORT ----------")

    // Retrieve Abigail’s object from the Traveller’s array using Abigail's position in the array.
    // Find Abigail's position in the array
    val abigailIndex = travellerList.indexOfFirst { it.name == "Abigail Diaz" }

    if (abigailIndex != -1) {
        val abigail = travellerList[abigailIndex]

        // checks passport's validity
        // if passport number is invalid then, update it with valid one
        if (abigail.isValid()) {
            println("Abigail has a valid passport number.")
        } else {
            println("Abigail's passport is invalid.")
            println("Passport number is Updating...")
            // Update to a valid number
            abigail.passportNumber = 11122
            println("Abigail's updated passport number : ${abigail.passportNumber}")
        }
    } else {
        println("Abigail is not found in the list of travellerList.")
    }

    println()

    // Section 3: Creating reservationList
    println("------------ reservationList INFORMATION ----------")

    // Find Bob's and Carmen's positions in the travellerList array
    val bobIndex = travellerList.indexOfFirst { it.name == "Bob Smith" }
    val carmenIndex = travellerList.indexOfFirst { it.name == "Carmen Pope" }

    // Find the flight positions in the flightList array
    val wn3855Index = flightList.indexOfFirst { it.flightNumber == "WN3855" }
    val aa281Index = flightList.indexOfFirst { it.flightNumber == "AA281" }
    val ac306Index = flightList.indexOfFirst { it.flightNumber == "AC306" }

    // Create reservationList for Bob and Carmen, and add them to the reservationList array list
    if (bobIndex != -1 && wn3855Index != -1 && aa281Index != -1) {
        reservationList.add(Reservation(flightList[wn3855Index].flightNumber, flightList[wn3855Index].departureAirport, flightList[wn3855Index].arrivalAirport, flightList[wn3855Index].flightDistance, travellerList[bobIndex], "99Q"))
        reservationList.add(Reservation(flightList[aa281Index].flightNumber, flightList[aa281Index].departureAirport, flightList[aa281Index].arrivalAirport, flightList[aa281Index].flightDistance, travellerList[bobIndex], "99Q"))
    }

    if (carmenIndex != -1 && ac306Index != -1) {
        reservationList.add(Reservation(flightList[ac306Index].flightNumber, flightList[ac306Index].departureAirport, flightList[ac306Index].arrivalAirport, flightList[ac306Index].flightDistance, travellerList[carmenIndex], "8A"))
    }

    // Section 4: Outputting Information about reservationList
    // counter
    var phxReservationCounter = 0

    // totalReservationCost - total reservation cost (total revenue) = sum of all the all reservation costs
    // (ie: total revenue = reservation 1 cost + reservation 2 cost + reservation 3 cost + reservation 4 cost + ....)
    var totalReservationCost = 0.0
    for (res in reservationList) {
        // Programmatically calculate and output the total revenue generated from all reservationList.
        totalReservationCost += res.calculateCost()

        // Programmatically calculate and output the total number of reservationList containing flightList departing PHX
        if (res.departureAirport == "PHX") {
            phxReservationCounter++
        }
    }
    println("Number of reservationList departing PHX : ${phxReservationCounter}")
    println("Total revenue from reservationList : ${totalReservationCost}")

    println()

    // Section 5: Modifying a Reservation
    println("------------ CARMEN'S RESERVATION ----------")

    /*
      Retrieve Carmen’s reservation from the reservationList array using Carmen’s position number in the array.
      Using the retrieved reservation:
           ○ Output Carmen’s current reservation details to the screen.
           ○ Change Carmen’s seat number to a different value
           ○ Reduce the flight distance on Carmen’s reservation by 10%
    */

    // Output Carmen’s current reservation details to the screen.
    val carmenReservationIndex = reservationList.indexOfFirst { it.passenger.name == "Carmen Pope" }
    val carmenReservation = reservationList[carmenReservationIndex]
    println(carmenReservation)

    // store the old reservation cost in a variable
    val oldReservationCost = carmenReservation.calculateCost()

    println()
    println("------------ UPDATED RESERVATION ----------")

    //Change Carmen’s seat number to a different value
    carmenReservation.seatNumber = "999Q"

    // Reduce the flight distance on Carmen’s reservation by 10%
    carmenReservation.flightDistance *= 0.9
    println(carmenReservation)

    println()
    println("Old reservation cost: $oldReservationCost")
    println("Updated reservation cost: ${carmenReservation.calculateCost()}")
}