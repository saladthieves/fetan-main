package com.gebeya.fetan

import android.content.Intent
import android.os.Bundle
import com.gebeya.fetan.framework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAddRunButton.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
    }
}