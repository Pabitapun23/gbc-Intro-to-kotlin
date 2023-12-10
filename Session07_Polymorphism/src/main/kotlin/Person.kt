
open class Person(
    var firstName: String,
    var lastName : String
) {

    constructor() : this(firstName = "NA", lastName = "NA")

    constructor(fname: String) : this(firstName = fname, lastName = "NA")

    override fun toString(): String {
        return "Name : $firstName $lastName"
    }
}