// constructors are used to initialize the attributes of the objects to some default value


// class with primary constructor & no method
// primary constructor can be declared with the class header

// attributes of class mentioned and uninitialized in the Primary constructor
// must be supplied when creating object of the class
// must supply the values for the uninitialized members of primary constructor; if there is no secondary constructor

// class Person (val firstName:String, val lastName:String)

// primary constructor with default values for the properties & toString() method
class Person(var firstName : String, var lastName : String = "NA", var isEmployed : Boolean = false) {

    var name : String
        get() = "${this.firstName} ${this.lastName}"
        set(value) {
            if (!value.isNullOrEmpty()) {
                // if the value is not empty,
                // obtain the first name and last name by splitting the value by space
                // for example : Jane Doe is the value, Jane as firstname and Doe as lastname
                this.firstName = value.split(" ").first().toString()
                this.lastName = value.split( " ").last().toString()
            }
        }


    // initializer block
    // automatically called / executed when the object of the class is created
    // can access the attributes declared in the primary constructor

    //    init {
//        println("Creating an object of person class for name $firstName")
//
//        if(lastName == "NA") {
//            println("Last name is not provided")
//        }
//
//        if(!isEmployed) {
//            println("Creating unemployed person instance")
//        }
//    }



    // a class can have multiple initializer block
    // they will be executed in the same sequence as they are created in class
    init {
        println("Creating an object of person class for name $firstName")
    }

    init {
        if(!isEmployed) {
            println("Creating unemployed person instance")
        }
    }

    init {
        if(lastName == "NA") {
            println("Last name is not provided")
        } else {
            println("All info is given")
        }
    }



    // returns a string representation of the object;
    // typically shows values for all the attributes of the objects
    override fun toString(): String {
//        return super.toString()
        return "Name : $firstName $lastName, isEmployed : ${if (isEmployed) "employed" else "unemployed"}"
    }
}