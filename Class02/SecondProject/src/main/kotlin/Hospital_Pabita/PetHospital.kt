// template of pet hospital
class PetHospital {
    var name:String
    var address:String
    var doctor:Human

    // what types of data will the list store?
    // list of strings?
    // list of numbers?
    // list of Cat objects?
    var catsList:MutableList<Cat>

    // function provides a way for the main() program
    // to set the initial value of the properties
    constructor(hospitalName:String, hospitalAddress:String, dr:Human, cats:MutableList<Cat>) {
        name = hospitalName
        address = hospitalAddress
        doctor = dr
        catsList = cats
    }
}