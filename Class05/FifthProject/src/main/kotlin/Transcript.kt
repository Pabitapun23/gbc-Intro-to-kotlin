// classes and their relationships

open class Transcript(
    val student : Student,
    private var courseList : MutableList<Course>
    ) {
    // has 1 student
    // has many courses

    // other object will inherit from the Transcript.
    // Transcript = parent = super class = base class

    // accessor (getter) function
    // - provides access to your private properites
    // In kotlin, this is encapsulation
    fun getCourseList():List<Course> {
        // convert a mutable list to a readonly list
        return courseList.toList();
    }


    // use this function to add a course to the courseList
    fun addCourse(courseToAdd : Course) : String {
        // write the logic to check if the person already has this course in their course list
        // search the current list for the course (compare based on course name)
        var courseExists = false
        for (currCourse in courseList) {
            if (currCourse.title == courseToAdd.title) {
                courseExists = true
                break
            }
        }
        // if yes, return an error
        if (courseExists == true) {
            return "Cannot add a duplicate course!"
        }
        // if no, add to the course list
        else {
            courseList.add(courseToAdd)
            return "Course successfully added"
        }
    }

    open fun show() {

    }

    override fun toString(): String {
        return "Transcript(student=$student, courseList=$courseList)"
    }


}


// undergraduate transcript IS A type of Transcript.
// UGTranscript = child class
// derived class
class UGTranscript(
    currStudent : Student,
    currCourseList : MutableList<Course>,
    var gpa : Double = 0.0
) : Transcript(student = currStudent, courseList = currCourseList) {


    override fun show() {
        // output student name, id, student type
        println("Student Name : ${student.fullname}")
        println("Student ID : ${student.id}")
        println("Student Type : ${student.type}")

        // output course list & percentage grade
        for (currCourse in getCourseList()) {
            println("${currCourse.title} = ${currCourse.finalGrade}%")
        }

        // output gpa
        println("GPA : ${gpa}")
    }

    override fun toString(): String {
        return "UGTranscript(gpa=$gpa)"
    }

}


class PGTranscript(
    student : Student,
    courseList : MutableList<Course>)
    : Transcript(student, courseList) {

    override fun show() {
        // output student name, id, student type
        println("Student Name : ${student.fullname}")
        println("Student ID : ${student.id}")
        println("Student Type : ${student.type}")

        // output course list & PASS / FAIL for each course
        for (currCourse in getCourseList()) {
            if (currCourse.finalGrade >= 50) {
                println("${currCourse.title} =  PASS")
            } else {
                println("${currCourse.title} =  FAIL")
            }

        }

    }

    override fun toString(): String {
        return "PGTranscript()"
    }

}




// option 2
// other object will inherit from the Transcript.
// Transcript = parent = super class = base class
//open class Transcript() {
//    // has 1 student
//    var student:Student
//    // has many courses
//    var courseList:MutableList<Course>
//
//
//    constructor(student:Student, courseList:MutableList<Course) {
//        this.student = student
//        this.courseList = courseList
//    }
//}
