package com.toxicflame427.asciiart

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            //New way of removing status bar
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            //Old way must still be used if targeting older devices
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val splashIcon = findViewById<ImageView>(R.id.splash_icon)
        val splashIconAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_icon_animation)
        splashIcon.startAnimation(splashIconAnimation)

        Thread{
            Thread.sleep(2500)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
           overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_left)
        }.start()
    }
}