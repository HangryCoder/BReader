package genora.example.com.breader.model

import java.io.Serializable

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Publisher(val publisher_id: Int, val publisher_name: String,
                     val publisher_icon: String, val publisher_timestamp: String,
                     val categoryList: List<Category>) : Serializable