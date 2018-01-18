package genora.example.com.breader.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import genora.example.com.breader.R
import genora.example.com.breader.activity.CategoryActivity
import genora.example.com.breader.model.Category
import genora.example.com.breader.model.Publisher
import kotlinx.android.synthetic.main.publisher_item_layout.view.*
import java.io.Serializable

/**
 * Created by genora-sonia on 16/1/18.
 */
class PublisherAdapter(private val context: Context, private var publisherList: List<Publisher>)
    : RecyclerView.Adapter<PublisherAdapter.PublisherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PublisherHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.publisher_item_layout, parent, false)
        return PublisherHolder(view)
    }

    override fun onBindViewHolder(holder: PublisherHolder?, position: Int) {
        val publisher = publisherList[position]
        holder?.itemView?.publisher_name?.text = publisher.publisher_name
        holder?.itemView?.publisher_timestamp?.text = publisher.publisher_timestamp
        // Glide.with(context).load(publisher.publisher_icon)
        //       .into(holder?.itemView?.publisher_icon!!)
    }

    override fun getItemCount() = publisherList.size

    inner class PublisherHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var view = itemView

        init {
            view?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val publisher: Publisher = publisherList[adapterPosition]
            val context = v?.context
            val intent = Intent(context, CategoryActivity::class.java)
            intent.putExtra("Publisher", publisher as Serializable)
            context?.startActivity(intent)
        }

    }
}