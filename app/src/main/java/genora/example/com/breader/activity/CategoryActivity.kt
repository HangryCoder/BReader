package genora.example.com.breader.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import genora.example.com.breader.R
import genora.example.com.breader.adapter.CategoryAdapter
import genora.example.com.breader.model.Category
import genora.example.com.breader.model.Publisher
import kotlinx.android.synthetic.main.category_layout.*

/**
 * Created by genora-sonia on 18/1/18.
 */
class CategoryActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var categoryAdapter: CategoryAdapter
    private var categoryList: ArrayList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_layout)

        val publisher = intent.extras.get("Publisher") as Publisher
        categoryList = publisher.categoryList as ArrayList<Category>

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        categoryAdapter = CategoryAdapter(this, categoryList)
        recycler_view.adapter = categoryAdapter
    }
}