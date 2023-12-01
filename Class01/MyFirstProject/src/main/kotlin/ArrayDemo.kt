fun main() {
    println("+++ ARRAY DEMO! +++")

    // mutable list - change/modify the contents
    // val citiesList = ["a", "b", "c"]
    val citiesList = mutableListOf("Barcelona", "Rome", "Paris")

    // print
    println("Cities: ${citiesList}")

    // size of the list
    println("Number of cities? ${citiesList.size}")

    // get individual list items
    println(citiesList[0])
    println(citiesList[1])
    println(citiesList[2])

    // mutable list --> modify the contents
    citiesList[0] = "Madrid"
    citiesList[2] = "Lyons"

    println("Cities: ${citiesList}")

    // add to the list - .push in JS
    // we use .add() in Kotlin
    citiesList.add("London")
    citiesList.add("Shanghai")
    println("Cities: ${citiesList}")

    // .splice(pos, 1) in JS
    // remove from the list
    // we use .removeAt() in Kotlin
    citiesList.removeAt(2)
    println("Cities: ${citiesList}")

    // iterate over the contents of your list
    // using range
    for (i in 0..citiesList.size-1) {
        println("Welcome to ${citiesList[i]}")
    }

    for (currCity in citiesList) {
        println("Come back to ${currCity}")
    }

    // arrays
    // - create an array
    // - update values in array
    // - manipulate the array
    // - loop through array

    // In Kotlin, an array is called a LIST
    // There are 2 types of LISTS:
    // 1. Writeable lists
    // --> a list, where you can modify the contents of the list (mutable list)
    // 2. Read only lists
    // --> a list, but you cannot modify the contents of the list



}