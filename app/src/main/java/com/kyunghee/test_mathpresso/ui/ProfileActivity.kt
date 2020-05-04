package com.kyunghee.test_mathpresso.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kyunghee.test_mathpresso.model.GithubResponse
import com.kyunghee.test_mathpresso.R
import com.kyunghee.test_mathpresso.presenter.ViewPresenter
import com.kyunghee.test_mathpresso.model.ViewPresenterImpl

class ProfileActivity : AppCompatActivity(),
    ViewPresenter.View {

    var presenterImplementation: ViewPresenterImpl? = null
    lateinit var profile_img_url :ImageView
    lateinit var profile_txt_name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profile_img_url = findViewById(R.id.img_profile)
        profile_txt_name= findViewById(R.id.txt_name)

        presenterImplementation =
            ViewPresenterImpl(this)
        presenterImplementation!!.loadItem(intent.extras?.get("login").toString())


    }

    override fun updateView(items: GithubResponse) {
            Glide.with(this)
                .load(items.avatar_url)
                .into(profile_img_url)
        profile_txt_name.text= items.login.toString()


    }
}
