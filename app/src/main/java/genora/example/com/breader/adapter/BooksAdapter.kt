package genora.example.com.breader.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import genora.example.com.breader.R
import genora.example.com.breader.activity.BookDetailsActivity
import genora.example.com.breader.model.Book
import kotlinx.android.synthetic.main.books_item_layout.view.*
import java.io.Serializable

/**
 * Created by genora-sonia on 19/1/18.
 */
class BooksAdapter(private val context: Context, private val booksList: List<Book>)
    : RecyclerView.Adapter<BooksAdapter.BooksHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BooksHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.books_item_layout, parent, false)
        return BooksHolder(view)
    }

    override fun onBindViewHolder(holder: BooksHolder?, position: Int) {
        val books: Book = booksList[position]
        holder?.itemView?.book_name?.text = books.book_name
    }

    override fun getItemCount() = booksList.size

    inner class BooksHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val view = itemView

        init {
            view?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val book: Book = booksList[adapterPosition]
            val context = v?.context
            val intent = Intent(context, BookDetailsActivity::class.java)
            intent.putExtra("Book", book as Serializable)
            context?.startActivity(intent)
        }
    }
}