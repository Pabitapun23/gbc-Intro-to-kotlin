package interface_demo

interface Payable {
    // val payableAmount : Double

//    fun getPayableAmount() : Double {
//        return 0.0
//    }

    fun getPayableAmount() : Double

    // cannot initialize the variables in interface
//    var amount : Double = 100.0
    var amount : Double

    fun displayAmount() {
        println("Amount : $amount")
    }

}