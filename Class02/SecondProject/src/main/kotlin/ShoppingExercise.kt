// 1. Accepts list of shopping cart items
fun getShoppingCart(productItems: MutableList<Product>) {
    println("DEBUG: Number of students ${productItems.size}")

    println("Name     Qty     Unit Price     Cost")

    var subtotal = 0.00
    for(items in productItems) {
        println("${items.name}    ${items.quantity}        ${items.price}           ${items.price * items.quantity}")
        subtotal += (items.quantity * items.price)
    }

    println("Subtotal: $subtotal")
    // tax - 13% of subtotal
    val tax = subtotal * 0.13
    val finalCost = subtotal + tax
    println("Tax: $tax")
    println("Final Cost : $finalCost")

}

fun main() {

    val productList = mutableListOf(
        Product("Banana", 2, 1.00),
        Product("Apple", 3, 2.50)
    )

    getShoppingCart(productList)

}