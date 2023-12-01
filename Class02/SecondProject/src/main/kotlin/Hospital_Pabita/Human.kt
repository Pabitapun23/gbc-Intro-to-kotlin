// template of human
// - a class is a template for how to create individual object
// - a class also represents a custom data type that you've added to the system
class Human {
    // human's property and data types
    var name:String
    var age:Int

    // provide a way for the main function
    // to set the initial value of these properties
    constructor(humanName:String, humanAge:Int) {
        name = humanName
        age = humanAge
    }
}