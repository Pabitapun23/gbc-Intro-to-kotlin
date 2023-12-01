// template for owner
class Person {
    var name:String
    var address:String

    constructor(initialName: String, initialAddress:String) {
        name = initialName
        address = initialAddress
    }
}

// template for object (Dog)
class Dog {
    // properties + data type
    var name:String
    var breed:String
    var owner:Person

    // provide a way for the main function
    // to set the initial value of these properties
    constructor(dogName:String, dogBreed:String, dogOwner:Person) {
        name = dogName
        breed = dogBreed
        owner = dogOwner
    }
}


fun main() {
    println("EXERCISE 3: Dogs")

    val owner1 = Person("Peter Smith", "255 Main Street")
    val owner2 = Person("Suzy Patel", "100 Avenue Road")
    val dogsList = mutableListOf(
        Dog("Fido", "Poodle", owner1),
        Dog("Woof", "Bulldog", owner2),
        Dog("King", "Golden Retriever", Person("Amy Wong", "123 Road"))
    )

    for ( d in dogsList) {
        println("Name: ${d.name}, Owner Address: ${d.owner.address}")
    }
}
