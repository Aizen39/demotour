package fr.pageup.demoapp.data

/**
 * A customer has a name, a description and an image of his package
 */
data class Customer(
    val firstname: String,
    val lastname: String,
    val description: String,
    val img: Int
)

