fun main() {
    // how do we declare variables that can be set to null?

//    // 1. Suzy has a car
//    var car = "Tesla Model X"
//    // 2. some time passes, and Suzy decides to sell her car
//    // after she sells the car, she no longer has a car (car does not exist = null)
//    car = null // gives error - Null can not be a value of a non-null type String


    // implicit variable declaration
    // - declare a variable, and you allow Kotlin to "guess" the variable's data type
    // - 1. Kotlin examines the INITIAL value you assigned to the variable
    // - 2. Guesses what the data type should be based on that INITIAL value
    // - If the value looks like a whole number, Kotlin will assign an INT data type
    // - If the value looks like a decimal number, Kotlin will assign a DOUBLE data
    //  - If the value looks like a string, Kotlin will assign a string
    var x = "asdfdfsdf"
    println(x::class.simpleName)    // output - String

    // explicit variable declaration
    // - YOU tell Kotlin what the data type is (you don't allow it to guess)
    var y:Int = 35
    println(y::class.simpleName)   // output - Int
    var z:String = "abc"
    println(z::class.simpleName)   // output - String

    // explicit variable declaration to specify that a variable can store null values
    // 1. What is the main data type that a variable can store (Int, Double, String)
    // 2. Do you want the variable to ALSO be able to store a null value?
    // - NO, then leave it , and move on
    // - YES, modify the data type --> add a ? symbol to the end


    // nullable String type
    var car:String? = "Tesla Model X"
    println(car)
    car = null
    println(car)

    // String data type
    var firstName:String = "Peter"
    println(firstName)
    // firstName = null      // gives error - Null can not be a value of a non-null type String
    // println(firstName)


    var gpa:Double? = 3.5
    // println(gpa * 1.10)         // ERROR: 3.5 x 1.10 ==...

    gpa = null
    // println(gpa * 1.10)         // ERROR: null x 1.10 == ERROR!!!

    // write a program to increase the gpa by 10%



    println(gpa)
    gpa = 1.0
    println(gpa)


    // write a program to get the first score in the array
    var testScores = mutableListOf<Int>(25, 35)
    val result = testScores.firstOrNull()
    if (result == null) {
        println("ERROR: The list is empty, so there is no first item!")
    } else {
        println(result)
    }


}

//fun firstOrNull(data:MutableList<Int>):Int? {
//    if (data.size == 0) {
//        return null
//    } else {
//        return data[0]
//    }
//}