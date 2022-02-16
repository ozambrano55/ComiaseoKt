
import com.google.gson.annotations.SerializedName

data class PruebaItem(
    @SerializedName("c_Despieze2")
    val cDespieze2: String,
    @SerializedName("cant")
    val cant: Int,
    @SerializedName("d_Ref02")
    val dRef02: String,
    @SerializedName("grupo")
    val grupo: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("n_Despieze2")
    val nDespieze2: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("ref")
    val ref: String,
    @SerializedName("unit")
    val unit: Double
)