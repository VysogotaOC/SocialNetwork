package deusvult.petrkamaev.homework_5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        title = resources.getString(R.string.title_feed)

        val recyclerView = findViewById(R.id.notifications_recyclerView) as RecyclerView

        //Creating objects
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val objects = listOf<FeedList>(
            FeedList("notification1"),
            FeedList("notification2"),
            FeedList("notification3"),
            FeedList("notification4"),
            FeedList("notification5"),
            FeedList("notification6")
        )
        val adapter = FeedAdapter(this, objects)
        recyclerView.adapter = adapter

        val navigationView = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
        navigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.feed_button -> {

                }
                R.id.news_button -> {

                }
                R.id.notifications_button -> {
                    recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
                }
            }
            true
        }
    }
}