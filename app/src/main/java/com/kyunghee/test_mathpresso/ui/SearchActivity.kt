package com.kyunghee.test_mathpresso.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.kyunghee.test_mathpresso.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        var edit_id=findViewById<EditText>(R.id.edit_id)

        btn_search.setOnClickListener{
            val intent = Intent(this@SearchActivity, ProfileActivity::class.java)
            var txt = edit_id.text.toString()
            intent.putExtra("login",txt)
            startActivity(intent)
        }
    }
}
