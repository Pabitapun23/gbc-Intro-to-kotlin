// Exercise :
// - create a mutable list of vehicles
//   -- Vehicle 1  = Honda Civic 		AFGH990
//   -- Vehicle 2 = Tesla Model X   	PPPP9999
//   -- Vehicle 3 =  Ford Focus		GHN412
// - every vehicle has these properties
//    -- model --> String (Honda Civic)
//    -- LicensePlate --> String (AFGH990)
// Write a program that loops through your list of vehicles and
// outputs the license plate for each vehicle


// template for object (vehicles)
class Vehicle {
    // properties + data type
    var model:String
    var licensePlate:String

    // provide a way for the main function
    // to set the initial value of these properties
    constructor(initialName:String, initialLp:String) {
        model = initialName
        licensePlate = initialLp
    }
}

fun main() {
    println("EXERCISE 1: VEHICLES")

    //    val v1 = Vehicle (initialModel = "Honda Civic", lp = "AFGH990")
    //    val v2 = Vehicle(initialModel= "Toyota Corolla", lp = "PPH151")

    // 1. OPTION 1: A list of vehicle objects
    val vehicleList = mutableListOf(
        Vehicle ("Honda Civic",  "AFGH990"),
        Vehicle("Toyota Corolla", "PPH151"),
        Vehicle("Tesla Model X", "YNZ928")
    )


    // 2. OPTION 2: Creating separate vehicle variables and adding them to the list
    //    val v1 = Vehicle("Toyota Corolla Cross", "UUU123")
    //   val v2 = Vehicle("Tesla Model X", "PHG654")
   //    val v3 = Vehicle("Ford F150", "YNZ918")


    // 2. Loop through the list
    for (i in 0..vehicleList.size-1) {
        // 3. For each item in the list, output the license plate
        println("License Plate: ${vehicleList[i].licensePlate}")
    }

    for (v in vehicleList) {
        println("+ License Plate: ${v.licensePlate}")
    }

}