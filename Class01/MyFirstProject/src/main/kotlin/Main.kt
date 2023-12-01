// Where is the starting (entry) point of your app?
// - Create a function in Kotlin
// - Name that function main

// const main = () = {}

// In a Kotlin program, you can only have 1 main() function
// if you put 2 main functions (or more) you get an error
fun main() {
    // write your Kotlin code for your app (program)
    // - output to the console
    // console.log("Hello World!")
    println("Hello World!")              // println = PRINT LINE into new line, print = print into same line
                                         // HELLO WORLD + a new line at the end
    println("This is my first Kotlin program!")
    // run the program

    // print
    print("Hello")
    print("World")

    // println
    println("APPLE")
    println("Banana")

    // variables
    // - read only (const) --> val
    // - writeable variable (let) --> var
    var x = 25
    println(x)
    x = 50
    println(x)

    val v = 10
    println(v)
    // v = 20         // this gives error - v is val which can't be reassigned
    // println(v)


    // Kotlin is strongly typed language
    // - after you assign a variable a data type, you can't change it
    var y = 3.14
    // y = "abc"      //error! - Type mismatch: inferred type is String but Double was expected

    y = 9.18
    y = 1.23456
    y = 0.0000001

    // output the data type
    println(y::class.simpleName)         // output - Double

    val z = 100
    println(z::class.simpleName)         // output - Int

    val a = false
    val b = "hello"        // "" - String
    val c = '%'            // '' - character

    println(a::class.simpleName)        // output - Boolean
    println(b::class.simpleName)        // output - String
    println(c::class.simpleName)        // output - Char

    // String = multiple character/letter/number/symbol
    // double quote "
    val d = "%%%%%%"   // symbol String
    val e = "3123123"   // number String

    println(d::class.simpleName)
    println(e::class.simpleName)

    // char = a single character/letter/number/symbol
    // single quote '
    val f = '%'   // symbol character
    val g = '3'   // number character
    val h = 'A'   // letter character

    println(f::class.simpleName)
    println(h::class.simpleName)
    println(g::class.simpleName)

    // Kotlin --> Strings are composed of individual characters

    var name = "Peter"
    // a string = an array of 5 Character elements

    println(name[0])
    println(name[1])
    println(name[2])
    println(name[3])
    println(name[4])

    println(name[2]::class.simpleName)
    println(name[4]::class.simpleName)

    // output variables into a String
    // (String concatenation)
    val student = "Emily"
    val age = 80

    // "Hello Emily, you are 80 years old"
    // - string concatenation (+)
    println("Hello " + student + " you are " + age + " years old.")
    // - string interpolation (template) --> `Hello ${name}, you are ${age} years old`

    // (string interpolation / string template)
    println("Hello ${student}, you are ${age} years old")
    println("In 5 years, you will be ${age + 5} years old")

    // conditionals
    if (age > 16) {
        println("You can drive a car!")
    } else if (age > 10 && age < 16) {
        println("You must wait a few more years")
    } else {
        println("You cannot drive at all")
    }

    // loop
    // for -- repeats 3 times
    // 12..14 ==> range (range of 3 number)
    // 12, 13, 14
    for ( i in 12..14) {
        println(i)
    }

    for( i in 100..102) {
        println(i)                // 100, 101, 102
    }

    for (i in 0..2) {           // 0, 1, 2
        println(i)
    }

    for (abc in 0..2) {
        println("HELLO")          // prints hello in new line 3 times
    }

    for (pqr in 0..5) {
        println("Loop ${pqr}")   // prints Loop 0, Loop 1, Loop 2, Loop 3, Loop 4, Loop 5
    }

}