package deusvult.petrkamaev.homework_5.Adapters

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import deusvult.petrkamaev.homework_5.Info.Feed
import deusvult.petrkamaev.homework_5.Info.NewsList
import deusvult.petrkamaev.homework_5.R

class NewsAdapter (val context: Context, val objects: List<NewsList>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_list, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news: NewsList = objects[position]

        holder.titleText.text = "" + news.title
        holder.bodyText.text = "" + news.body
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText = itemView.findViewById(R.id.title_news) as TextView
        val bodyText = itemView.findViewById(R.id.body_news) as TextView
    }
}
