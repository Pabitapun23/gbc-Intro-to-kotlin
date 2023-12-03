class Professor(var name : String, var employeeNumber : Int , var email : String, var phoneNumber : String, var department : String) {

    init {
        println("Hiring a professor for $department. Name : $name")
        println("Please assign employee number $employeeNumber")
    }

    // secondary constructor
    // can be created using constructor keyword
    // can be used as an alternative to primary constructor when creating the object
    // if the class has primary constructor, each secondary constructor must delegate to it using this()
    constructor(employeeName : String, phone : String ) :
            this(name = employeeName,
                employeeNumber = 0,
                email = "NA",
                phoneNumber = phone,
                department = "TBD"
                ) {

                println("Creating professor object with name and phone number")
    }

    // overloaded constructors - multiple secondary constructors
    // constructor overloading.
    // overloaded constructors must have different number of parameters and different types of parameters
//    constructor(employeeName : String, email : String ) :
//            this(name = employeeName,
//                employeeNumber = 0,
//                email = email,
//                phoneNumber = "NA",
//                department = "TBD"
//            ) {
//
//        println("Creating professor object with name and phone number")
//    }

    constructor(employeeName : String, phone : String, emailAddress : String) :
            this(name = employeeName,
                employeeNumber = 0,
                email = emailAddress,
                phoneNumber = phone,
                department = "TBD"
            ) {

        println("Creating professor object with name and phone number")
    }

    override fun toString(): String {
        return "Professor {" +
                "\n\t Name : $name, " +
                "\n\t Employee # : $employeeNumber, " +
                "\n\t Email : $email" +
                "\n\t PhoneNumber : $phoneNumber" +
                "\n\t Department : $department }"
    }
}