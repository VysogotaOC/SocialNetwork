package deusvult.petrkamaev.homework_5

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FeedAdapter ( val context: Context, val objects: List<FeedList>) : RecyclerView.Adapter<FeedAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.notification_list, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news: FeedList = objects[position]

        holder.title.text = "" + news.title
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.textView_id) as TextView
    }
}