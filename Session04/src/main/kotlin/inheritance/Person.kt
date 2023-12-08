package inheritance

//super class
//by default - class is final (cannot be inherited)
//mark the class with open keywork to allow inheritance
open class Person(
    var firstName: String,
    //protected members can be accessed within the class it is declared in as well as in the subclass
    //but not anywhere else
    protected var lastName : String

    //private members are only accessible within the class it is declared in
    //not available in the sub-class
//    private var lastName : String
) {

    constructor() : this(firstName = "NA", lastName = "NA")

    constructor(fname: String) : this(firstName = fname, lastName = "NA")

    override fun toString(): String {
        return "Name : $firstName $lastName"
    }
}