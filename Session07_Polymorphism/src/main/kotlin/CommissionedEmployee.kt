import interface_demo.Receivable

// can mark the child class abstract if you don't want to provide definition
// for parent class abstract method
abstract class CommissionedEmployee(
    fname : String,
    lname : String,
    desig : String,
    var commissionRate : Double,
    var unitsSold : Int
) : Employee(fname, lname, desig) {

    override fun toString(): String {
        return "Commission Employee : \n" +
                "${super.toString()}" +
                "\n\tCommission Rate : ${this.commissionRate} +" +
                "\n\tUnits sold : ${this.unitsSold}"
    }
}