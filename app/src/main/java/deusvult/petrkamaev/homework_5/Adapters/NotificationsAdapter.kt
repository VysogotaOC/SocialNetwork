package deusvult.petrkamaev.homework_5.Adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.media.Image
import android.support.v7.widget.RecyclerView
//import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import deusvult.petrkamaev.homework_5.Info.DataFile.notifications
import deusvult.petrkamaev.homework_5.Info.NotificationsList

import deusvult.petrkamaev.homework_5.R

class NotificationsAdapter ( val context: Context, val objects: List<NotificationsList>) : RecyclerView.Adapter<NotificationsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.notification_list, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return objects.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val notifications: NotificationsList = objects[position]

        holder.title.text = "" + notifications.title
        holder.imageView.setImageResource(notifications.image)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById(R.id.textView_id) as TextView
        var imageView = itemView.findViewById(R.id.notification_image_id) as ImageView
    }
}