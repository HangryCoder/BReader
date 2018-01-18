package genora.example.com.breader.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import genora.example.com.breader.R

/**
 * Created by genora-sonia on 18/1/18.
 */
class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_layout)

        setContentView(R.layout.category_layout)

        /*val category = intent.extras.get("Category") as Category
        booksList = category.categoryList as ArrayList<Book>

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        categoryAdapter = CategoryAdapter(this, categoryList)
        recycler_view.adapter = categoryAdapter*/
    }
}