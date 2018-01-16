package genora.example.com.breader.model

/**
 * Created by genora-sonia on 16/1/18.
 */
data class Details(val status: Int, val timestamp: Long, val error: Int,
                   val current_version: Int, val link: String,
                   val force_update: Int)