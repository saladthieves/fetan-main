package com.gebeya.fetan

import android.content.Intent
import android.os.Bundle
import com.gebeya.fetan.framework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.runs_summary_layout.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAddRunButton.setOnClickListener {
            startActivity(Intent(this, AddRunActivity::class.java))
        }

        // 1) pass in null => root element of the layout android:layout_centerInParent="true"
        // 2) pass in viewGroup => viewGroup returned with inflated layout as child
        val root = layoutInflater.inflate(R.layout.runs_summary_layout, summaryContainer)

        runsSummaryTime.text = "0 mins"
        runsSummaryDistance.text = "0 meters"
    }
}