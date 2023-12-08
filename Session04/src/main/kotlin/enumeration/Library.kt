package enumeration

class Library(var libraryName : String, var libraryNumber : Int) {

    //static object
    //contain static properties
    //properties whose value will be shared amongst all the objects
    //common value for all the object
    companion object{
        var COUNTER = 100
        var management : String = "Toronto Public Library"
    }
    constructor(libraryName: String) : this(libraryName = libraryName, libraryNumber = ++COUNTER)

    //to indicate relationship between Library and Book class
    //a Library have multiple Books
    //HAS-A relationship  - one class having object(s) of another class as a property
    var bookList : MutableList<Book> = mutableListOf()

//    var book : Book = Book()

    //method overloading - polymorphism
    //having multiple methods with same name in same class
    //but with different number of parameters and different types of parameters
    fun addBook(title: String, author: String){
        this.bookList.add(Book(title, author, BookGenre.NONE))
    }

    fun addBook(title: String, author: String, genre : BookGenre){
        this.bookList.add(Book(title, author, genre))
    }

    fun addBook(book : Book){
        this.bookList.add(book)
    }

    fun getBooks() : String{
        return this.bookList.joinToString("\n")
    }

    override fun toString(): String {
        return "Library name : $libraryName, Library Num : ${this.libraryNumber}, Management : $management " +
                "\nBook in Library ${this.getBooks()}"
    }

}