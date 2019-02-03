package vysogotaoc.petrkamaev.socialnetwork.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import vysogotaoc.petrkamaev.socialnetwork.R
import vysogotaoc.petrkamaev.socialnetwork.fragments.FeedFragment
import vysogotaoc.petrkamaev.socialnetwork.fragments.NewsFragment
import vysogotaoc.petrkamaev.socialnetwork.fragments.NotificationsFragment
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity() {

    private val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        if (item.itemId == bottomNavigationView.selectedItemId)
            return@OnNavigationItemSelectedListener false
        when (item.itemId){
            R.id.feed_button -> {
                createFeedFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.news_button -> {
                createNewsFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.notifications_button -> {
                createNotificationsFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)


        createFeedFragment()
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun createFeedFragment() {
        title = "Feed"
        val transaction = manager.beginTransaction()
        val fragment = FeedFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun createNewsFragment() {
        title = "News"
        val transaction = manager.beginTransaction()
        val fragment = NewsFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun createNotificationsFragment() {
        title = "Notifications"
        val transaction = manager.beginTransaction()
        val fragment = NotificationsFragment()
        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}