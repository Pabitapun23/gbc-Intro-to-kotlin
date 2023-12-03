class Rectangle(var width : Int, var height : Int) {
//    var area : Int
//        // getter - called everytime you use/refer the property
//        get() = this.width * this.height        // backing field
//
//        // setter - caller everytime you assign a value to the property
//        // the assigned value is available within setter using value keyword
//        set(value) {
//            println("assigning $value to area")
//
//            if (value < 0) {
//                println("should not assign 0 as area")
//            }
//        }

    // if only setter is used, the property must be initialized
    var area : Int = 0
        // if there's no getter then, we can't receive a value
        // so, we must have a getter to have a setter

        // setter - caller everytime you assign a value to the property
        // the assigned value is available within setter using value keyword
        set(value) {
            println("assigning $value to area")

            if (value < 0) {
                println("should not assign 0 as area")
            } else if (value > 0){
                println("assigning $value to area")
                // initializing the property within its own setter using same name creates infinite loop
                // area = value   // here, area is property so initializing it with value creates infinite loop

                // use backing field - when you need to initialize to the property within its own setter
                field = value     // but, field is not a property but a backing field so, it doesn't create infinite loop

                // can also set other properties
                this.width = value / 2
                this.height = value / 2
            }
        }

    override fun toString(): String {
        return "Rectangle width = ${this.width}, height = ${this.height}, area = ${this.area}"
    }

}