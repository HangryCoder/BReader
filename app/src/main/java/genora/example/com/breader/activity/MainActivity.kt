package genora.example.com.breader.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import genora.example.com.breader.R
import genora.example.com.breader.adapter.PublisherAdapter
import genora.example.com.breader.model.Publisher
import kotlinx.android.synthetic.main.recycler_view_layout.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var publisherAdapter: PublisherAdapter
    private var publisherList: ArrayList<Publisher> = ArrayList<Publisher>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        publisherList = addNewPublishers()

        publisherAdapter = PublisherAdapter(this, publisherList)

        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        recycler_view.adapter = publisherAdapter
    }

    private fun addNewPublishers(): ArrayList<Publisher> {
        var publisher: Publisher

        publisher = Publisher(1, "Sonia W", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Shilpa W", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Krupa Bhat", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Stephen G", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Suhail S", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Saisha N", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Vaishali S", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        publisher = Publisher(1, "Lax N", "blah blah", "11-11-2018")
        publisherList.add(publisher)

        return publisherList
    }
}
