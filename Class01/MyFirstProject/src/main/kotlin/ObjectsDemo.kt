// 1. Template (pattern/mold/blueprint) for the object
// Student object
// Template for this object
// - Create the definition of what a student is
// - What are the properties that a student has

// 2. Use this template to create individual students

// In Kotlin, all students will have the same properties and you cannot modify it
class Student {
    // define the properties of a student
    // - what is the data type of each property
    var name:String
    var age:Int
    var tuitionPaid:Boolean

    // Tell Kotlin what the values of name/age
    // are for each student you end up creating
    // function called a constructor
    constructor(initialName:String, initialAge:Int, tp:Boolean) {
        name = initialName
        age = initialAge
        tuitionPaid = tp
    }
}


fun main() {
    println("+++ Objects Demo +++")

    val s1 = Student(initialName = "Peter", initialAge = 15, tp = true)
    val s2 = Student(initialName = "Suzy", initialAge = 20, tp = false)
    val s3 = Student(initialName = "Emily", initialAge = 25, tp = true)

    println("Who is student 1? ${s1.name}, Age = ${s1.age}")
    //output s2 and s3 's name & age to the screen
    println("Who is student 2? ${s2.name}, Age = ${s2.age}")
    println("Who is student 3? ${s3.name}, Age = ${s3.age}")

    // modify the existing properties
    // Peter - Peter Smith, Age = 30
    s1.name = "Peter Smith"
    s1.age = 30

    println("Updated Student 1: ${s1.name}, Age = ${s1.age}")

    println("${s1.name},  Age = ${s1.age}, Paid? ${s1.tuitionPaid}")
    println("${s2.name},  Age = ${s2.age}, Paid? ${s2.tuitionPaid}")
    println("${s3.name},  Age = ${s3.age}, Paid? ${s3.tuitionPaid}")

}