package vysogotaoc.petrkamaev.socialnetwork.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.delegateadapter.delegate.CompositeDelegateAdapter
import vysogotaoc.petrkamaev.socialnetwork.adapters.NewsAdapter
import vysogotaoc.petrkamaev.socialnetwork.adapters.NotificationsAdapter
import vysogotaoc.petrkamaev.socialnetwork.Info.IViewModel
import vysogotaoc.petrkamaev.socialnetwork.Info.DataFile
import vysogotaoc.petrkamaev.socialnetwork.R
import kotlinx.android.synthetic.main.fragment_feed.*
import vysogotaoc.petrkamaev.socialnetwork.Info.NewsList
import vysogotaoc.petrkamaev.socialnetwork.activities.AddNewsActivity

class FeedFragment : Fragment() {
    var added_news_list = ArrayList<NewsList>()
    var allItems = added_news_list + DataFile.allItems.shuffled()
    private var news_data = 1


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = CompositeDelegateAdapter.Builder<IViewModel>()
            .add(NewsAdapter())
            .add(NotificationsAdapter())
            .build()
        feed_recyclerView.layoutManager = LinearLayoutManager(context)
        feed_recyclerView.adapter = adapter
        adapter.swapData(allItems)

        feed_recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0)
                    fab.hide()
                else
                    fab.show()
            }
        })
        fab.setOnClickListener {
            startActivityForResult(Intent(context, AddNewsActivity::class.java), news_data)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null || requestCode!= news_data || resultCode!= Activity.RESULT_OK) return

        val title = data.getStringExtra("Title")
        val description = data.getStringExtra("Body")

        val added_news_list = ArrayList<NewsList>()
        added_news_list.add(
            NewsList(
            title,
            description
        )
        )
        allItems = added_news_list + allItems

        val adapter = CompositeDelegateAdapter.Builder<IViewModel>()
            .add(NewsAdapter())
            .add(NotificationsAdapter())
            .build()
        feed_recyclerView.layoutManager = LinearLayoutManager(context)
        feed_recyclerView.adapter = adapter

        adapter.swapData(allItems)
    }
}