class Student(
    val id : String,
    var firstName : String,

    // ? - optional - means some people have last name
    var lastName : String?,
    var type : StudentType
) {

    // we put this here instead of in the constructor because there is logic associated with
    // setting the value of the full Name
    // using a computed property
    val fullname : String
        get() {
            if (lastName == null) {
                return "${firstName}"
            } else {
                return "${firstName} ${lastName}"
            }
        }

    // produce string representation of the class
    override fun toString(): String {
        return "Student(id='$id', firstName='$firstName', lastName=$lastName, studentType=$type, fullname='$fullname')"
    }


//    init {
//        println("constructor finished, init{} executing")
//        println("first name : ${this.firstName}")
//        println("last name : ${this.lastName}")
//
//        if (lastName == null) {
//            fullname = "${firstName}"
//        } else {
//            fullname = "${firstName} ${lastName}"
//        }
//        println("init{} finished")
//    }





}