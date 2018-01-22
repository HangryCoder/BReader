package genora.example.com.breader.model

import com.google.gson.annotations.SerializedName

/**
 * Created by genora-sonia on 16/1/18.
 */
data class MainResponse(val status: Int, val timestamp: Long, val error: Int,
                        val current_version: String, val link: String,
                        val force_update: Int,
                        @SerializedName("Details")
                        val publisherList: ArrayList<Publisher>)