// abstract classes are by default open classes
// cannot create its object
// abstract classes are meant to be inherited
// must implement
abstract class Employee(
    fname : String,
    lname : String,
    var designation : String,
    var empID : Int = ++EMP_COUNTER)
    : Person(firstName = fname, lastName = lname) {

    companion object{
        var EMP_COUNTER = 0
    }

    constructor() : this("NA", "NA", "NA", empID = ++EMP_COUNTER)

    constructor(desig : String) : this("NA", "NA", designation = desig, empID = ++EMP_COUNTER){
        println("Generating employee with number $empID")
    }

    //function must be marked as open to allow overriding
//    open fun getPay() : Double{
//        return 0.0;
//    }

    // abstract method
    // cannot have a body/definition
    // indicates what the method should do; not how it should be done
    // abstraction - only providing declaration of method; implementation is not provided
    // if any member of the class is abstract; class must be marked as an abstract.
    // abstract methods are by default open methods
    abstract fun getPay() : Double;

    //super keyword refers to the superclass or parent class
    override fun toString(): String {

        return "\n\tEMP ID : $empID, " +
                "\n\tName : ${super.firstName} ${super.lastName}, " +
                "\n\tDesignation : $designation," +
                "\n\tPay : ${this.getPay()}"
    }
}