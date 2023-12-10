package interface_demo

// implementing interface in a class
// abstract class vs interfaces
// a class can implement multiple interfaces but cannot inherit multiple (abstract) classes
class Invoice(
    var partNumber : Int,
    var partDescription : String,
    var quantity : Int,
    var unitPrice : Double,
    override var amount : Double
) : Payable, Receivable {

    override fun getPayableAmount(): Double {
        // payable amount to supplier when the shop owner is purchasing parts

        return (this.unitPrice * this.quantity * 1.13)
    }

    override fun getReceivableAmount(): Double {
        // receivable amount from customer when the shop owner is selling parts

        var amount = (this.unitPrice + 0.50) * this.quantity

        if(this.quantity > 10) {
            amount = this.unitPrice * (this.quantity - 2)
        }

        amount *= 1.13

        return amount
    }

    override fun toString(): String {
        return "\nInvoice : " +
                "\n\tPartNumber : $partNumber," +
                "\n\tPart Description : $partDescription," +
                "\n\tUnit Price : $unitPrice," +
                "\n\tQuantity : $quantity,"

    }
}