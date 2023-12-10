import interface_demo.Invoice

fun main() {
    println("Trying polymorphism")

    testPolymorphism()

    testInterfaces()
}

fun testPolymorphism(){

    var contractEmp1 = ContractEmployee(
        "Dwij",
        "Virani",
        "Mobile App Developer",
        54000.0,
        12)

    println("\ncontractEmp1 : $contractEmp1")

    var partEmp1 = PartTimeEmployee(
        "Hyun Seong",
        "Lee",
        "iOS team lead",
        87.90,
        73
    )
    println("\npartEmp1 : $partEmp1")

    var ftEmp1 = FullTimeEmployee(
        fname = "Allen",
        lname = "Bond",
        desig = "Software Architect",
        annualSalary = 85000.0,
    )

    println("\nftEmp1 : $ftEmp1")


    // abstract class cannot be instantiated
    // cannot create object of abstract class due to partial definition

//    var emp1 = Employee("Bob", "Smith", "CEO")
//    println("\nemp1 : $emp1")


    var employeeList = mutableListOf<Employee>()

    employeeList.add(ftEmp1)
    employeeList.add(partEmp1)
    employeeList.add(contractEmp1)
    employeeList.add(PartTimeEmployee("Johnny", "Brown", "Android Development", 45.0, 44))
    employeeList.add(ContractEmployee("Patrick", "Idaho", "Android Development", 96000.0, 15))
    employeeList.add(FullTimeEmployee("Jeremy", "Tsai", "Full-Stack Developer", 12000.0))
    employeeList.add(FullTimeEmployee("Toye", "Arogunmati", "Cross Platform Developer", 115000.0))

    println("\nList of employees...............")
    for(emp in employeeList) {
        print("\t ${emp.firstName} ${emp.lastName}")

        // give 02% increment to Full-time employees
        // is - operator to find is emp full-time one or not
        if(emp is FullTimeEmployee) {
            emp.annualSalary *= 1.02
            print(", annual salary : ${emp.annualSalary}")
        }
        println()
    }


}

fun testInterfaces() {
    val invoice1 = Invoice(101, "L Pipes", 50, 1.5, 76.0)
    println("\nInvoice 1 : $invoice1")
    println("\tPayable Amount : ${invoice1.getPayableAmount()}")
    println("\tReceivable Amount : ${invoice1.getReceivableAmount()}")
    println("\tAmount from interfaces : ")
    invoice1.displayAmount()

    val purchaseInvoice = Invoice(102, "Nuts", 100, 0.99, 23.0)
    println("\nPurchase Invoice : $purchaseInvoice")
    println("\tPayable Amount : ${purchaseInvoice.getPayableAmount()}")
    println("\tAmount from interfaces : ")
    purchaseInvoice.displayAmount()

    val saleInvoice = Invoice(101, "L Pipes", 10, 2.0, 50.0)
    println("\nSale Invoice : $saleInvoice")
    println("\tReceivable Amount : ${saleInvoice.getReceivableAmount()}")
    println("\tAmount from interfaces : ")
    saleInvoice.displayAmount()

    var contractEmp1 = ContractEmployee(
        "Dwij",
        "Virani",
        "Mobile App Developer",
        54000.0,
        12)

    println("\ncontractEmp1 : $contractEmp1")
    println("\tReceivable Expenses : ${contractEmp1.getReceivableAmount()}")


}