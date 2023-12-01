// template of our objects
// 1. Human
// 2. Cat
// 3. Pet hospital

// template of human
// - a class is a template for how to create individual object
// - a class also represents a custom data type that you've added to the system
class Human {
    // human's property and data types
    var name:String
    var age:Int

    // provide a way for the main function
    // to set the initial value of these properties
    constructor(humanName:String, humanAge:Int) {
        name = humanName
        age = humanAge
    }
}

// template for cat
class Cat {
    // dog's property and data types
    var name:String
    var breed:String
    var status:Boolean
    var owner:Human

    constructor(catName:String, catBreed:String, isSick:Boolean, catOwner:Human) {
        name = catName
        breed = catBreed
        status = isSick
        owner = catOwner
    }
}

// template of pet hospital
class PetHospital {
    var name:String
    var address:String
    var doctor:Human

    // what types of data will the list store?
    // list of strings?
    // list of numbers?
    // list of Cat objects?
    var catsList:MutableList<Cat>

    // function provides a way for the main() program
    // to set the initial value of the properties
    constructor(hospitalName:String, hospitalAddress:String, dr:Human, cats:MutableList<Cat>) {
        name = hospitalName
        address = hospitalAddress
        doctor = dr
        catsList = cats
    }
}

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