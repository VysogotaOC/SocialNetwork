package vysogotaoc.petrkamaev.socialnetwork.adapters

import com.example.delegateadapter.delegate.KDelegateAdapter
import vysogotaoc.petrkamaev.socialnetwork.Info.NotificationsList

import vysogotaoc.petrkamaev.socialnetwork.R
import kotlinx.android.synthetic.main.notification_list.*

class NotificationsAdapter : KDelegateAdapter<NotificationsList>() {

    override fun onBind(item: NotificationsList, viewHolder: KViewHolder) =
        with(viewHolder) {
            textView_id.text = item.title
            notification_image_id.setImageResource(item.image)
        }

    override fun isForViewType(items: List<*>, position: Int) =
        items[position] is NotificationsList

    override fun getLayoutId(): Int = R.layout.notification_list
}
