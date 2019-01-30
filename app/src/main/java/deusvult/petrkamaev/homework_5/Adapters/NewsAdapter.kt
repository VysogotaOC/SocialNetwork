package deusvult.petrkamaev.homework_5.adapters

import com.example.delegateadapter.delegate.KDelegateAdapter
import deusvult.petrkamaev.homework_5.Info.NewsList
import deusvult.petrkamaev.homework_5.R
import kotlinx.android.synthetic.main.news_list.*

class NewsAdapter : KDelegateAdapter<NewsList>() {

    override fun onBind(item: NewsList, viewHolder: KViewHolder) =
        with(viewHolder) {
            title_news.text = item.title
            body_news.text = item.body
        }

    override fun isForViewType(news: List<*>, position: Int) =
        news[position] is NewsList

    override fun getLayoutId(): Int = R.layout.news_list
}
