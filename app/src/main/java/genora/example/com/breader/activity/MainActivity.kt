package genora.example.com.breader.activity

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import genora.example.com.breader.R
import genora.example.com.breader.adapter.PublisherAdapter
import genora.example.com.breader.model.Book
import genora.example.com.breader.model.Category
import genora.example.com.breader.model.MainResponse
import genora.example.com.breader.model.Publisher
import genora.example.com.breader.network.RestClient
import genora.example.com.breader.utils.Utils
import kotlinx.android.synthetic.main.recycler_view_layout.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.Serializable

class MainActivity : AppCompatActivity(), PublisherAdapter.PublisherCallBack {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var publisherAdapter: PublisherAdapter
    private var publisherList: ArrayList<Publisher> = ArrayList()
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // publisherList = parseDetailsJSON(publisherList)

        publisherAdapter = PublisherAdapter(this, publisherList, this)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = publisherAdapter

        progressDialog = ProgressDialog(this)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setMessage("Loading, Please Wait")
        progressDialog.show()

        fetchDetails()
    }

    private fun fetchDetails() {
        RestClient.getRestClientAPI().getPublishers().enqueue(object : Callback<MainResponse> {

            override fun onResponse(call: Call<MainResponse>?, response: Response<MainResponse>?) {
                progressDialog.dismiss()
                publisherList = response?.body()?.publisherList!!
                Log.e("Response", "response - $publisherList")

                publisherAdapter = PublisherAdapter(applicationContext, publisherList, this@MainActivity)
                recycler_view.adapter = publisherAdapter
            }

            override fun onFailure(call: Call<MainResponse>?, t: Throwable?) {
                progressDialog.dismiss()
                Log.e("fetchDetails ", "onFailure " + (t?.localizedMessage))
                if (t is IOException) {
                    Toast.makeText(this@MainActivity, "No Internet Connection",
                            Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun parseDetailsJSON(publishList: ArrayList<Publisher>): ArrayList<Publisher> {
        try {
            val jsonObject = JSONObject(Utils.loadJSONFromAsset(this))
            val detailsArray: JSONArray = jsonObject.getJSONArray("Details")

            for (i in 0 until detailsArray.length()) {
                val detailsJSONObject: JSONObject = detailsArray.getJSONObject(i)

                val categoryJSONArray: JSONArray = detailsJSONObject.getJSONArray("category")
                val categoryList: ArrayList<Category> = ArrayList()

                for (j in 0 until categoryJSONArray.length()) {
                    val categoryJSONObject: JSONObject = categoryJSONArray.getJSONObject(j)

                    val booksJSONArrayList = categoryJSONObject.getJSONArray("books")
                    val booksList: ArrayList<Book> = ArrayList()

                    for (k in 0 until booksJSONArrayList.length()) {
                        val booksJSONObject = booksJSONArrayList.getJSONObject(k)

                        val books = Book(booksJSONObject.getInt("book_id"),
                                booksJSONObject.getString("book_name"),
                                booksJSONObject.getString("frontcover_path"),
                                booksJSONObject.getInt("count_best_seller"),
                                booksJSONObject.getInt("featured"),
                                booksJSONObject.getString("product_key"),
                                booksJSONObject.getString("price"),
                                booksJSONObject.getString("pdf_path"),
                                booksJSONObject.getString("book_img"),
                                booksJSONObject.getString("sample_copy_path"))

                        booksList.add(books)
                    }

                    val category = Category(categoryJSONObject.getInt("cat_id"),
                            categoryJSONObject.getString("cat_name"),
                            categoryJSONObject.getString("icon50"),
                            categoryJSONObject.getLong("cat_timestamp"),
                            booksList)

                    categoryList.add(category)
                }

                val publisher = Publisher(detailsJSONObject.getInt("pub_id"),
                        detailsJSONObject.getString("pub_name"),
                        detailsJSONObject.getString("picon"),
                        detailsJSONObject.getString("pub_timestamp"),
                        categoryList)

                publishList.add(publisher)
            }

        } catch (jsonException: JSONException) {
            jsonException.printStackTrace()
        }

        return publishList
    }

    override fun onPublishItemClickListener(position: Int) {
        val publisher: Publisher = publisherList[position]
        val intent = Intent(applicationContext, CategoryActivity::class.java)
        intent.putExtra("Publisher", publisher as Serializable)
        startActivity(intent)
    }
}
