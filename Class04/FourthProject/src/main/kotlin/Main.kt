import enumeration.Book
import enumeration.BookGenre
import enumeration.Library
import humanresources.PartTimeEmployee
import inheritance.ContractEmployee
import inheritance.Employee
import inheritance.Person

fun main(args: Array<String>) {
    println("Enumerations")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    testEnumerations()

    testInheritance()
}

// the main advantage of using enum is that we can build safer application if we have limited number of types

fun testEnumerations() {

    var bk1Genre : BookGenre = BookGenre.BIOGRAPHY

   // var bk2Genre : BookGenre = "FICTION" - gives error

    var bk2Genre : BookGenre = BookGenre.FICTION

    println("bk1Genre : $bk1Genre")

    println("bk2Genre : $bk2Genre")

    println("\n Enum values for BookGenre : -------")
    for (genre in BookGenre.values()) {
        println(genre)
    }

    //if we use null instead of none then, we can store in-built type things in it
    // but, here we are using enum, which is user-defined type. So, we use none instead of null
    var g3 = BookGenre.NONE

    if(g3 == BookGenre.NONE) {
        println("\n g3 - Book Genre is not determined yet")
    }

    var book1 = Book("The alchemist", "Paulo", BookGenre.FICTION)
    println("book1 : $book1")

    var library1 = Library("Sacred Space")

    library1.addBook("The orange sky", "Michael", BookGenre.FICTION)
    library1.addBook("Becoming", "Obama")
    library1.addBook(book1)

    println("\n library1 : ${library1}")

    var library2 = Library("Under the stars")

    library2.addBook("Mahotu", "Mori", BookGenre.NONFICTION)
    library2.addBook("Programming with Kotlin", "Chang", BookGenre.NONE)

    println("library2 : $library2")

    val book2 = Book("Ocean Science", "Peterson", BookGenre.NONE)

    book2.genre = BookGenre.valueOf("ENCYCLOPEDIA")
    println("book2 : $book2")

//    book2.genre = BookGenre.valueOf("SCIENCE")
//    println("book2 : $book2")

    // enumValueOf - is used to obtain specific enum type from values
    val bio : BookGenre = enumValueOf<BookGenre>("BIOGRAPHY")
    println("bio : $bio")
}


fun testInheritance() {
    var p1 = Person("Seno", "Daos")
    println("p1 : $p1")

    var emp1 = Employee("Professor")
    println("emp1 : $emp1")

    emp1.firstName = "Gepetto"

    // private members cannot be accessed outside the class
    // protected members cannot be accessed outside the class or subclass
    emp1.lastName = "Pizzerio"

    println("\nemp1 : $emp1")

    var emp2 = Employee("Rafael", "Ribeiro", "Software Architect")
    println("\nemp2 : $emp2")

    var contractEmp1 = ContractEmployee("Dwij", "Virani", "Mobile App Developer", 54000.0, 12)

    println("\ncontractEmp1 : $contractEmp1")


    var partEmp1 = PartTimeEmployee(
        "Hyun Seong",
        "Lee",
        "iOS team lead",
        87.90,
        73
    )

    println("\npartEmp1 : $partEmp1")

}

/*

Object-Oriented Principles :

1. Encapsulation - grouping attributes and its operations together in one module (class)
2. Inheritance - extending capabilities of one class by inheriting into another and reusing existing members
3. Polymorphism - same name performs different operation (constructor overloading, method overloading, method overriding)
*/