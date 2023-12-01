// 1. accepts a list of student objects
fun getGraduationStatus(studentList: MutableList<Student>) {
    // 2. loop through each student and
    // output their graduation status
    // can graduate if they have 1.9 GPA
    println("DEBUG: Number of students ${studentList.size}")

//    for (currStudent in studentList) {
//        print(currStudent.name)
//        if(currStudent.gpa > 1.9) {
//            // graduate
//            print(" - CAN GRADUATE")
//        } else {
//            // cannot graduate
//            print(" - MUST TRY AGAIN")
//        }
//        println()
//    }

    // different option
    for (currStudent in studentList) {
        var status = ""
        if (currStudent.gpa > 1.9) {
            status = "CAN GRADUATE"
        }
        else {
            status = "MUST TRY AGAIN"
        }
        println("++ ${currStudent.name} - ${status}")
    }

}

fun main() {

    // Create a student list
    val classList = mutableListOf(
        Student("Peter", 1.5),
        Student("Abigail", 2.5),
        Student("Amy", 4.0),
        Student("Mark", 3.14),
        Student("Suzy", 1.98)
    )

    getGraduationStatus(classList)
}