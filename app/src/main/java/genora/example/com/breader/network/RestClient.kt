package genora.example.com.breader.network

import genora.example.com.breader.model.Details
import genora.example.com.breader.model.Publisher
import genora.example.com.breader.utils.Utils.Companion.BASE_URL
import genora.example.com.breader.utils.Utils.Companion.DEBUG
import genora.example.com.breader.utils.Utils.Companion.FETCH_DETAILS
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET

/**
 * Created by genora-sonia on 19/1/18.
 */
class RestClient {

    companion object {

        private fun getClient(): Retrofit {
            val client = OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()

            return Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }

        fun getRestClientAPI(): RestClientAPI {
            return getClient().create(RestClientAPI::class.java)
        }
    }

    interface RestClientAPI {
        @FormUrlEncoded
        @GET(FETCH_DETAILS)
        fun getPublishers()/*: Call<Details>*/
    }
}