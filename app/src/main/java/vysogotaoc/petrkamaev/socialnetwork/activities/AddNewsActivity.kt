package vysogotaoc.petrkamaev.socialnetwork.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_add_news.*
import vysogotaoc.petrkamaev.socialnetwork.R

class AddNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        post_button_id.setOnClickListener {post()}
    }

    fun post() {
        if (add_title_news.text!!.isNotEmpty() || add_body_news.text!!.isNotEmpty()) {
            val intent = this.intent
            intent.putExtra("Title", add_title_news.text.toString())
            intent.putExtra("Body", add_body_news.text.toString())
            this.setResult(RESULT_OK, intent)
            finish()

        } else {
            Snackbar.make(findViewById(android.R.id.content), "Enter empty fields", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
