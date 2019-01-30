package deusvult.petrkamaev.homework_5.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import deusvult.petrkamaev.homework_5.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Sign in"

        login_button_id.setOnClickListener{login()}
    }

    private fun login(){
        if(login_id.text.toString().isEmpty() && password_id.text.toString().isEmpty()){
            Snackbar.make(findViewById(android.R.id.content), resources.getString(R.string.login_and_password_empty), Snackbar.LENGTH_SHORT).show()
        }else if(login_id.text.toString() == "test" && password_id.text.toString() == "test"){
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
        }else if(login_id.text.toString().isEmpty() && password_id.text.toString().isNotEmpty()){
            Snackbar.make(findViewById(android.R.id.content), resources.getString(R.string.login_empty), Snackbar.LENGTH_SHORT).show()
        }else if(password_id.text.toString().isEmpty() && login_id.text.toString().isNotEmpty()){
            Snackbar.make(findViewById(android.R.id.content), resources.getString(R.string.password_empty), Snackbar.LENGTH_SHORT).show()
        }else if(login_id.text.toString() != password_id.text.toString()){
            Snackbar.make(findViewById(android.R.id.content), resources.getString(R.string.incorrect_login_and_password), Snackbar.LENGTH_SHORT).show()
        }
    }
}