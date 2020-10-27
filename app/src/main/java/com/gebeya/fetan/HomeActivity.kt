package com.gebeya.fetan

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import com.gebeya.fetan.framework.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homeAddRunButton.setOnClickListener {
            startActivity(Intent(this, AddRunActivity::class.java))
        }

//        with(AnimatorInflater.loadAnimator(this, R.animator.add_animation)) {
//            setTarget(homeAddRunButton)
//            start()
//        }

        val animator = ObjectAnimator.ofFloat(homeNoRunsLabel, "alpha", 0f, 1f)
        animator.apply {
            duration = 800
            startDelay = 400
            start()
        }

        val backgroundAnimator = ObjectAnimator.ofInt(
            homeAddRunButton,                // target
            "marginTop", // property
            0
        )
        backgroundAnimator.apply {
            duration = 800
            startDelay = 400
            start()
        }
    }
}