package genora.example.com.breader.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import genora.example.com.breader.R
import genora.example.com.breader.activity.BooksActivity
import genora.example.com.breader.model.Category
import kotlinx.android.synthetic.main.category_item_layout.view.*
import java.io.Serializable

/**
 * Created by genora-sonia on 18/1/18.
 */
class CategoryAdapter(private val context: Context, private val categoryList: List<Category>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item_layout, parent, false)
        return CategoryHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryHolder?, position: Int) {
        val category: Category = categoryList[position]

        holder?.itemView?.category_name?.text = category.category_name
    }

    override fun getItemCount() = categoryList.size


    inner class CategoryHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val view = itemView

        init {
            view?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val category: Category = categoryList[adapterPosition]
            val context = v?.context
            val intent = Intent(context, BooksActivity::class.java)
            intent.putExtra("Category", category as Serializable)
            context?.startActivity(intent)
        }

    }
}