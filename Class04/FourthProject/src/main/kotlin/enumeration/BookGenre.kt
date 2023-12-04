package enumeration


// Enum class cannot have duplicate values
// Enum class can be used to represent finite list of

//enum class BookGenre {
//    NONE, FICTION, NONFICTION, BIOGRAPHY, COMIC, ENCYCLOPEDIA
//}


enum class BookGenre {
    NONE,
    FICTION ("Book based on fictitious characters and events"),
    NONFICTION ("Book based on real-life people and events"),
    BIOGRAPHY ("Book based on someone's life journey"),
    COMIC,
    ENCYCLOPEDIA;

    /*
      if we want to show some attributes with description and some attributes without description
      then, we have to make two constructors for it
    */
    constructor(){
        this.description = "NA"
    }

    constructor(description : String) {
        this.description = description
    }

    var description : String? = null

    override fun toString(): String {
        return "Genre : ${this.name}, ( ${this.description} )"
    }
}