package humanresources

import inheritance.Employee

class PartTimeEmployee(
    fname : String,
    lname: String,
    desig : String,
    var hourlyWage : Double,
    var hoursWorked : Int
    ) : Employee(fname, lname, desig){

    override fun getPay(): Double {
        return (this.hourlyWage * this.hoursWorked)
    }

    override fun toString(): String {
        return "Parttime Employee : \n" +
                "${super.toString()}" +
                "\n\tHours Worked  : ${this.hoursWorked}" +
                "\n\tHourly Wage : ${this.hourlyWage}"
    }
}

//class PartTimeEmployee(
//    var hourlyWage : Double,
//    var hoursWorked : Int
//) : Employee(){
//
////    constructor(fname : String,
////                lname: String,
////                desig : String,
////                hourlyWage: Double,
////                hoursWorked: Int) : super(fname = fname, lname = lname, designation = desig){
////                    this.hourlyWage = hourlyWage
////                    this.hoursWorked = hoursWorked
////                }
//
//}