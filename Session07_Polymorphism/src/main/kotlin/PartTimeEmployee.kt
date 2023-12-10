class PartTimeEmployee(
    fname : String,
    lname: String,
    desig : String,
    var hourlyWage : Double,
    var hoursWorked : Int
    ) : Employee(fname, lname, desig){

        // overriding the abstract method from parent class
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
