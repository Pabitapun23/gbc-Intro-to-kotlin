package enumeration

class Library(var libraryName : String, var libraryNumber : Int) {

    // companion object - used as static object
    // contain static properties.
    // properties whose values will be shared amongst all the objects
    // maintain common values for all the object
    companion object {
        var COUNTER = 100
        var management : String = "Toronto Public Library"
    }

    constructor(libraryName: String) : this(libraryName = libraryName, libraryNumber = ++COUNTER)

    // to indicate relationship between Library and Book class
    // a library have multiple Books
    // Has-A relationship - one class having object(s) of another class as a property
    var bookList : MutableList<Book> = mutableListOf()


    // method overloading - Polymorphism - take different forms(operations) under the same name
    // having multiple methods with same name in same class
    // but with different number of parameters and different types of parameters
    fun addBook(title : String, author : String) {
        this.bookList.add(Book(title, author, BookGenre.NONE))
    }

    fun addBook(title: String, author: String, genre: BookGenre) {
        this.bookList.add(Book(title, author, genre))
    }

    fun addBook(book : Book) {
        this.bookList.add(book)
    }

    // joinToString() - separates one line to another
    fun getBooks() : String {
        return this.bookList.joinToString("\n")
    }

    override fun toString(): String {
        return "Library name : $libraryName, Library number : ${this.libraryNumber}, Management : $management" +
                "\n Book in Library ${this.getBooks()}"
    }
}