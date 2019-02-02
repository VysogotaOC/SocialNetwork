package vysogotaoc.petrkamaev.socialnetwork.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.delegateadapter.delegate.CompositeDelegateAdapter
import vysogotaoc.petrkamaev.socialnetwork.Info.DataFile
import vysogotaoc.petrkamaev.socialnetwork.adapters.NotificationsAdapter
import vysogotaoc.petrkamaev.socialnetwork.Info.IViewModel
import vysogotaoc.petrkamaev.socialnetwork.R
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {
    val notifications = DataFile.notifications.shuffled()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CompositeDelegateAdapter.Builder<IViewModel>()
            .add(NotificationsAdapter())
            .build()
        notifications_recyclerView.layoutManager = LinearLayoutManager(context)
        notifications_recyclerView.adapter = adapter
        adapter.swapData(notifications)
    }
}
