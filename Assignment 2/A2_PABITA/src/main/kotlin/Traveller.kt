// This Traveller class implements ICanValidate interface

data class Traveller(
    var name : String,
    var email : String,
    var passportNumber : Int
) : ICanValidate {

    // overrides the isValid() function of ICanValidate interface
    override fun isValid(): Boolean {
        if (passportNumber in 10000..99999) {
            return true
        } else {
            return false
        }
    }

    override fun toString(): String {
        return  "name = $name " +
                "\nemail = $email " +
                "\npassportNumber=$passportNumber\n"
    }


}