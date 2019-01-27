package deusvult.petrkamaev.homework_5.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.delegateadapter.delegate.CompositeDelegateAdapter
import deusvult.petrkamaev.homework_5.Adapters.NewsAdapter
import deusvult.petrkamaev.homework_5.Adapters.NotificationsAdapter
import deusvult.petrkamaev.homework_5.IViewModel
import deusvult.petrkamaev.homework_5.Info.DataFile


import deusvult.petrkamaev.homework_5.R
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {
    val allItems = DataFile.allItems.shuffled()

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
    }

}