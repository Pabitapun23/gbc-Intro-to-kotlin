fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    testClasses()

    testProfessor()
}

fun testClasses() {

    // create an instance of Person class
    val amy = Person("Amy", "Jackson");
    println("Amy : ${amy}")     // output - Amy : Person@6ce253f1 --> object reference of class

    println("Amy name : ${amy.name}")

    amy.name = "Almira Mahsa Hassan"
    println("Amy name: firstname : ${amy.firstName}, lastname : ${amy.lastName}, name: ${amy.name}")

    println("Amy name : ${amy.name}")

    //println("Amy Name : ${amy.firstName} ${amy.lastName}")

    // val cannot be reassigned
    // amy.firstName = "Amira"  - gives error

    // object is also declared as constant
    // amy = Person("Amira", "Jackson") - gives error

    var bob = Person("Bob", "Smith")
    println("Bob : ${bob.firstName} ${bob.lastName}")  // output - Bob : Bob Smith

    bob = Person("Bobby", "Smith")
    println("Bob : ${bob.firstName} ${bob.lastName}")  // output - Bob : Bobby Smith

    // bob.firstName = "Robert"      // not allowed as firstname is constant

    var charlie = Person("Charlie")
    // charlie.isEmployed ? "yes" : "no"
    println("charlie : firstname : ${charlie.firstName}, lastname : ${charlie.lastName}, isEmployed : ${ if (charlie.isEmployed) "yes" else "no"}")

    charlie.isEmployed = true
    charlie.lastName = "Windsor"
    println("charlie  : firstname : ${charlie.firstName}, lastname : ${charlie.lastName}, isEmployed : ${ if (charlie.isEmployed) "yes" else "no"}")

    charlie = Person("Charles", "Darwin")
    println("charlie two params : firstname : ${charlie.firstName}, lastname : ${charlie.lastName}, isEmployed : ${ if (charlie.isEmployed) "yes" else "no"}")

    charlie = Person("Charles", "Darwin", true)
    println("charlie all params : firstname : ${charlie.firstName}, lastname : ${charlie.lastName}, isEmployed : ${ if (charlie.isEmployed) "yes" else "no"}")

    // when object is used within string or as a string, it automatically calls the toString()
    println("Amy : $amy")
    println("Bob : $bob")
    println("Charlie : ${charlie.toString()}")
}

fun testProfessor() {
    // using primary constructor - must do as it is indicated - mentions parameters which is fixed
    var prof1 = Professor("John Doe",
        101,
        "john.doe@college.com",
        "6324523438",
        "ICET")

    println("Prof1 : $prof1")

    // using secondary constructor with two parameters - used as a helper or supporter - mentions temporary parameters
    var prof2 = Professor("Jane Jacobs", "1231241234")
    println("Prof2 : $prof2")

    // using secondary constructor with three parameters
    var prof3 = Professor("Kemy Brown", "213134124", "kemy.brown@gmail.com")
    println("Prof3 : $prof3")


    var rect1 = Rectangle(20, 40)
    println("rect1 : $rect1")

    println("rect1.area : ${rect1.area}")

    rect1.area = 400
    println("rect1.area : ${rect1.area}")
    println("rect1 : $rect1")
    println("rect1.area : ${rect1.area}")
}