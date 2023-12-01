// 1. No return, no parameters
// Defining function sum1()
fun sum1() {
    val a = 25
    val b = 50
    val result = a + b
    println("The sum is ${result}")
}

// 2. No return but has parameters
// You must specify the data type of your parameter
fun sum2 (a:Int, b:Int) {
    val result = a + b
    println("The sum is ${result}")
}

// 3. Return and no parameters
// Modify the function to specify what data type is returned
fun sum3():Int {
    val a = 25
    val b = 30
    val result = a + b
    return result
}

// 4. Return function WITH parameters
fun sum4(a:Int, b:Int):Int {
    val result = a + b
    return result
}


fun main() {
    println("Functions Demo")

    sum1()  // calling function sum1()

    // call the function, you must use values that match the expected
    // parameter data type
    sum2(10,20)
    sum2(-99, -5)
    // sum2(12.2, 1.1) //error - The floating-point literal does not conform to the expected type Int
   // sum2(3.14, 6) //error

    // data type of the value returned by the sum3() function
    println(sum3()::class.simpleName)    // output - Int

    // use the sum3 function
    // do something with the returned value
    val x = sum3() + 100
    println(x)


    // use the result directly in some logic
    println(sum3())


    // data type of the value returned by the sum3() function
    println(sum4(3,2)::class.simpleName)        // output - Int


    // use the sum3 function
    // do something with the returned value
    val y = sum4(3,2) + 100
    println(y)


    // use the result directly in some logic
    println(sum4(3,2))


}
