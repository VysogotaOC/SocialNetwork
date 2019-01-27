package deusvult.petrkamaev.homework_5.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import deusvult.petrkamaev.homework_5.Adapters.NewsAdapter
import deusvult.petrkamaev.homework_5.Info.DataFile

import deusvult.petrkamaev.homework_5.R
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {
    val news = DataFile.news.shuffled()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        news_recyclerView.layoutManager = LinearLayoutManager(context)
        news_recyclerView.adapter = NewsAdapter(requireContext(), news)


    }
}
