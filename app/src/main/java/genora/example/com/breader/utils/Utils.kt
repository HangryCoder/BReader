package genora.example.com.breader.utils

import android.content.Context

/**
 * Created by genora-sonia on 18/1/18.
 */
class Utils {

    companion object {

        const val BASE_URL = "http://www.genorainnovations.com/Test/"

        const val FETCH_DETAILS = "test4.php"

        const val IMG_EXTENSION = "${BASE_URL}img/"

        const val DEBUG = true

        fun loadJSONFromAsset(context: Context): String {
            return context.assets.open("details_json.json").bufferedReader().use {
                it.readText()
            }
        }
    }
}
