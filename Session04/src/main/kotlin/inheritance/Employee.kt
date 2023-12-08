package inheritance

//Inheriting Person class into Employee class

//final class cannot be inherited within or outside package
//final class Employee(

//sealed classes can be inherited within same package but not outside the package
//sealed class Employee(

//open class can be inherited within and outside package
open class Employee(
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

//    constructor(fname : String, lname : String, desig : String) : this( fname, lname, desig, empID = ++EMP_COUNTER)

    //final methods cannot be overridden
//    final fun getPay() : Double{

    //sealed cannot be applied to functions
//    sealed fun getPay() : Double{

    //function must be marked as open to allow overriding
    open fun getPay() : Double{
        return 0.0;
    }

    //super keyword refers to the superclass or parent class
    override fun toString(): String {

        return "\n\tEMP ID : $empID, " +
                "\n\tName : ${super.firstName} ${super.lastName}, " +
                "\n\tDesignation : $designation," +
                "\n\tPay : ${this.getPay()}"


//        return "\n\tEMP ID : $empID, " +
//                "\n\t${super.toString()}, " +
//                "\n\tDesignation : $designation"
    }
}