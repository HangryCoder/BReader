package genora.example.com.breader.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Category(
        @SerializedName("cat_id")
        val category_id: Int,
        @SerializedName("cat_name")
        val category_name: String,
        @SerializedName("icon50")
        val category_icon: String,
        @SerializedName("cat_timestamp")
        val category_timestamp: Long,
        @SerializedName("books")
        val booksList: List<Book>) : Serializable