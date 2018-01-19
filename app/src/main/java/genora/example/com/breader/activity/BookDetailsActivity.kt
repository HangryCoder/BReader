package genora.example.com.breader.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import genora.example.com.breader.R
import genora.example.com.breader.model.Book
import genora.example.com.breader.utils.Utils
import kotlinx.android.synthetic.main.book_details_layout.*

/**
 * Created by genora-sonia on 19/1/18.
 */
class BookDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_details_layout)

        val book: Book = intent.extras.get("Book") as Book

        book_name.text = book.book_name
        book_id.text = book.book_id.toString()
        best_seller_count.text = book.best_seller_count.toString()
        featured.text = if (book.featured == 1) "Yes" else "No"
        price_tv.text = book.price

        Glide.with(this)
                .load(Utils.Companion.IMG_EXTENSION + book.book_img)
                .into(book_icon)
    }
}