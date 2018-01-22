package genora.example.com.breader.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Publisher(
        @SerializedName("pub_id")
        val publisher_id: Int,
        @SerializedName("pub_name")
        val publisher_name: String,
        @SerializedName("picon")
        val publisher_icon: String,
        @SerializedName("pub_timestamp")
        val publisher_timestamp: String,
        @SerializedName("category")
        val categoryList: List<Category>) : Serializable