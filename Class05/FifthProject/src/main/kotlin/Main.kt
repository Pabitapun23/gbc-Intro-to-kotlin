fun main() {

    println("Transcript of students")

    val s1  = Student("101", "Peter", null, StudentType.UNDERGRADUATE)
    val s2 = Student("102", "Amy", "Smith", StudentType.POSTGRADUATE)

    println(s1.fullname)
    println(s2.fullname)

    println(s1)
    println(s2)

    // Create 5 courses and assign grades to each course.
    val c1 = Course("Intro to Biology", 70.5)
    val c2 = Course("Algebra", 94.0)
    val c3 = Course("English In Pop Culture", 49.0)
    val c4 = Course("Statistics", 15.0)
    val c5 = Course("Creative Problem Solving", 100.00 )


    // create a transcript for the UG Students
    val ugTranscript = UGTranscript(s1, mutableListOf<Course>(c1, c2, c3))
    var result = ugTranscript.addCourse(c4)
    println("Trying to add Statistics")
    println(result)
    result = ugTranscript.addCourse(c2)
    println("Trying to add ${c2.title}")
    println(result)
    // demonstrate that the student cannot take duplicate courses
//    ugTranscript.getCourseList().add(c2)
//     println(ugTranscript.getCourseList())

    // create a transcript for the PG student
    val pgTranscript = PGTranscript(s2, mutableListOf<Course>(c4, c5))

    // output the UG transcript to screen
    println("----------------------------")
    ugTranscript.show()
    // output the PG transcript to the screen
    println("----------------------------")
    pgTranscript.show()


}

