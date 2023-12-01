// template for cat
class Cat {
    // dog's property and data types
    var name:String
    var breed:String
    var status:Boolean
    var owner:Human

    constructor(catName:String, catBreed:String, isSick:Boolean, catOwner:Human) {
        name = catName
        breed = catBreed
        status = isSick
        owner = catOwner
    }
}