import interface_demo.Receivable

class ContractEmployee(
    fname : String,
    lname: String,
    desig : String,
    var contractAmount : Double,
    var months : Int
) : Employee(fname, lname, desig) , Receivable {

    //override - modifying the operation performed by the same method in the super class
    //method must be marked as open to be overridden
    //method overriding - polymorphism
    override fun getPay() : Double{
        return (contractAmount / months / 2)
    }

    override fun getReceivableAmount(): Double {
        // contract employee gets HR allowance max of $500
        val requestedAmount = 1200.0
        // necessary calculations or inputs for requested amount
        if(requestedAmount > 500) {
            return 500.0
        }
        return requestedAmount
    }

    override fun toString(): String {
        return "Contract Employee : \n" +
                "${super.toString()}" +
                "\n\tContract Amount  : ${this.contractAmount}" +
                "\n\tMonths of contract : ${this.months} months"
    }

}