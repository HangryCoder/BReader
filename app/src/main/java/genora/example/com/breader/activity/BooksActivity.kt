package genora.example.com.breader.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import genora.example.com.breader.R
import genora.example.com.breader.adapter.BooksAdapter
import genora.example.com.breader.model.Book
import genora.example.com.breader.model.Category
import kotlinx.android.synthetic.main.books_layout.*

/**
 * Created by genora-sonia on 18/1/18.
 */
class BooksActivity : AppCompatActivity() {

    private lateinit var booksAdapter: BooksAdapter
    private lateinit var booksList: ArrayList<Book>
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.books_layout)

        setContentView(R.layout.category_layout)

        val category = intent.extras.get("Category") as Category
        booksList = category.booksList as ArrayList<Book>

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager

        booksAdapter = BooksAdapter(this, booksList)
        recycler_view.adapter = booksAdapter
    }
}