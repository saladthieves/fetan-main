package com.gebeya.fetan

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*
import java.util.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val animator = AnimatorInflater.loadAnimator(this, R.animator.shoe_animation)
        animator.apply {
            setTarget(aboutShoeIcon)
        }

        animator.addListener(object: Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                animation?.start()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }
        })

        animator.start()

        aboutShoeIcon.setOnClickListener {
            val amount = Random().nextInt(5) + 1
            val value = Random().nextInt(2)
            val direction = if (value == 0) -1 else 1
            val rotate = ObjectAnimator.ofFloat(aboutShoeIcon, "rotation", 0f, amount * 360f * direction)
            rotate.apply {
                duration = 5000
                start()
            }
            val rootRotate = ObjectAnimator.ofFloat(aboutRoot, "rotation", 0f, amount * 360f * -direction)
            rootRotate.apply {
                duration = 5000
                start()
            }
        }
    }
}