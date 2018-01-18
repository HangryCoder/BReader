package genora.example.com.breader.model

import java.io.Serializable

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Category(val category_id: Int, val category_name: String,
                    val category_icon: String, val category_timestamp: Long,
                    val booksList: List<Book>) : Serializable