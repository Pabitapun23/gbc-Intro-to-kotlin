package humanresources

import inheritance.Employee

class PartTimeEmployee(
    fname : String,
    lname : String,
    desig : String,
    var hourlyWage : Double,
    var hoursWorked : Int
) : Employee(fname, lname, desig)  {

    override fun getPay() : Double {
        return (this.hourlyWage * this.hoursWorked)
    }

    override fun toString(): String {
        return "Part Time Employee : \n" +
                "${super.toString()}" +
                "\n\tHourly Worked : ${this.hoursWorked}" +
                "\n\tHourly Wage : ${this.hourlyWage}"
    }

}

//class PartTimeEmployee(
//    var hourlyWage : Double,
//    var hoursWorked : Int
//) : Employee()  {
//
//    constructor(fname : String,
//                lname : String,
//                desig : String,
//                hourlyWage : Double,
//                hoursWorked : Int) : super(fname = fname, lname = lname, designation = desig) {
//                    this.hourlyWage = hourlyWage
//                    this.hoursWorked = hoursWorked
//                }
//
//    constructor() : this() {
//        this.hourlyWage = 0.0
//        this.hoursWorked = 0.0
//    }
//}