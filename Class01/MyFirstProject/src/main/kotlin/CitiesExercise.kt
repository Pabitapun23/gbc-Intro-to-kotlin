// template for object (Cities)
class City {
    // properties + data type
    var name:String
    var population:Int

    // provide a way for the main function
    // to set the initial value of these properties
    constructor(initialName:String, initialPopulation:Int) {
        name = initialName
        population = initialPopulation
    }
}

// 2. Main Function
fun main() {
    println("EXERCISE 2: List of cities")

    // 1. Create a list of cities
    val citiesList = mutableListOf(
        City("Toronto",   100),
        City("Vancouver", 2030),
        City("Montreal", 3008)
    )

    for (i in 0..citiesList.size-1) {
        println("City: ${citiesList[i].name}, Population: ${citiesList[i].population}")
    }

    // Write a program that calculates the:
    // - Total population across all cities
    // - Average population

    // 2. Calculate the total population
    var total = 0.0
    //checks the data type of total
    println(total::class.simpleName)   // total is Int if total = 0, it's Double if total = 0.0
    println(citiesList::class.simpleName)  // citiesList is ArrayList

    // strongly typed languages
    // whole number, decimal numbers
    // division
    // whole number divison (integer division)
    println(3/2)
    // decimal number division (decimal division)
    println(3.0/2.0)
    println(3/2.0)
    println(3.0/2)

    for (city in citiesList) {
        total += city.population
    }

    val avg = total / citiesList.size

    // 3. Output the total
    println("Population: ${total}")
    println("Average population: ${avg}")


    val arr = arrayOf(1,2,3)
    println(arr[0])      // output - 1
    arr[0] = 5          // will not give any error but why ? aren't they supposed to be final?
                            // - bcz here arr 's memory pointer is fixed and only its object value is changing.
                           // val says, you cannot change the reference (pointer) it is assigned to in the memory.
                          // But the object itself (the array) is mutable, so if you change the value in memory
                         // it does not violate the promise of val as you did not change the memory address
                        // arr is assigned to.

    for (i in 0..arr.size-1) {
        println("${arr[i]}")       // output - 5 2 3
    }

}