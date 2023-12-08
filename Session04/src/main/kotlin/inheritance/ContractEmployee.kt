package inheritance

//ContractEmployee inherits from Employee
class ContractEmployee(
    fname : String,
    lname: String,
    desig : String,
    var contractAmount : Double,
    var months : Int
) : Employee(fname, lname, desig){

    //override - modifying the operation performed by the same method in the super class
    //method must be marked as open to be overridden
    //method overriding - polymorphism
    override fun getPay() : Double{
        return (contractAmount / months / 2)
    }

    override fun toString(): String {
        return "Contract Employee : \n" +
                "${super.toString()}" +
                "\n\tContract Amount  : ${this.contractAmount}" +
                "\n\tMonths of contract : ${this.months} months"
    }

}