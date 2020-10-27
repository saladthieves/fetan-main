package com.gebeya.fetan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import com.gebeya.fetan.framework.base.BaseActivity
import com.gebeya.fetan.framework.util.PREFS_NAME
import kotlinx.android.synthetic.main.activity_welcome.*

const val KEY_WELCOME_SEEN = "WELCOME-SEEN"

class WelcomeActivity : BaseActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Get an instance of SharedPrefs
//        prefs = getPreferences(Context.MODE_PRIVATE)  << prefs unique for this Activity
        prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        val seenWelcome = prefs.getBoolean(KEY_WELCOME_SEEN, false)

        if (seenWelcome) {
            openHome()
        }

        welcomeContinueButton.setOnClickListener {
            openHome()
        }
    }

    private fun openHome() {
        val editor = prefs.edit()
        editor.putBoolean(KEY_WELCOME_SEEN, true)
        editor.apply()

        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}