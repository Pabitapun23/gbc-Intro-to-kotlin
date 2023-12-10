// child class must implement/override the abstract method from parent class
class FullTimeEmployee(
    fname : String,
    lname : String,
    desig : String,
    var annualSalary : Double,
) : Employee(fname, lname, desig) {

    override fun getPay(): Double {
        return (this.annualSalary / 26)
    }

    override fun toString(): String {
        return "Full Time Employee : \n" +
                "${super.toString()}" +
                "\n\tAnnual Salary : ${this.annualSalary}"
    }
}