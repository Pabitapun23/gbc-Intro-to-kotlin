// template of our objects
// 1. Human
// 2. Cat
// 3. Pet hospital

// main function is the entry point into your application
fun main() {
    println("+++ EXERCISE 4 : PET HOSPITAL +++")

    //println("Welcome to ${PetHospital.name}")

    // human - owners of the cats
//    val owner1 = Human("Peter Smith", 35)
//    val owner2 = Human("Suzy Wong", 18)

    // for animal list
    //     Cat("Fluffy", "Tabby Cat", false, owner1),
    //     Cat("Woof", "Sphinx Cat", true, owner2),
    //     Cat("Kitty", "Tabby Cat", true, owner1),
    //   )

    // cats list
    val catList = mutableListOf(
        Cat("Fluffy", "Tabby Cat", false, Human("Peter", 35)),
        Cat("Claws", "Siamese Cat", true, Human("Suzy", 89)),
        Cat("Meow", "Tiger", true, Human("Peter", 35)),
        Cat("Bubble", "Manx Cat", true, Human("Amy", 73)),
    )


    // Make a Pet Hospital
    val hospital = PetHospital("First Avenue Cat Hospital", "160 First Avenue", Human("Dr.Patel", 87 ), catList)

    //print output the name of the hospital & its address
    println("Welcome to ${hospital.name}")
    println("We are located at ${hospital.address}")

    // output the doctor
    println("Doctor in charge: ${hospital.doctor.name}")

    // output all cats and their owners
    println("------------------------------------------")
    println("PATIENT LIST")
    println("------------------------------------------")

    for (cat in catList) {
        println("${cat.name}, Owner: ${cat.owner.name}")
    }

    // output the number of sick cats vs. the number of recovering cats
    println("------------------------------------------")
    println("STATISTICS ABOUT OUR HOSPITAL")
    println("------------------------------------------")

    var sickCat = 0
    var recoveringCat = 0
    for(cat in catList) {
        if(cat.status) {
            sickCat++
        } else {
            recoveringCat++
        }
        println("Cat name: ${cat.name}, owner name: ${cat.owner.name}")
    }
    println("Number of Sick Cats: ${sickCat}")
    println("Number of Recovering Cats: ${recoveringCat}")

    // different way:
//    var numSick = 0
//    var numRecovered = 0
//    for (currAnimal in catList) {
//        if (currAnimal.status == true) {
//            numSick = numSick + 1
//        } else {
//            numRecovered = numRecovered + 1
//        }
//    }
//
//    println("Sick cats: ${numSick}")
//    println("Recovered cats: ${numRecovered}")

}