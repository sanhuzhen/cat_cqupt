package com.example.cat_cqupt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed

/**
 * TODO:Splash开机动画
 */
@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {
    private val SPLASH_DELAY_TIME = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        delaySplash()
    }

    /**
     * 延长开机动画
     */
    private fun delaySplash(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        },SPLASH_DELAY_TIME)
    }
}