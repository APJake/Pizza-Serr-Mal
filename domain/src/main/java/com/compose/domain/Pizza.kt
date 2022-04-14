data class Pizza(
    val id: Int,
    val name: String,
    val img: String,
    val description: String,
    val price: Int,
    val quantity: Int,
    val sizeandcrust: List<Sizeandcrust>,
    val veg: Boolean
)