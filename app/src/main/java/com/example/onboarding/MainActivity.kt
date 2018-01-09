package com.example.onboarding

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // launch the onboarding screen if it is the first launch of the app
        if (isFirstLaunch()) {
            startActivity(Intent(this, OnBoardingActivity::class.java))
            finish()
        }
    }

    private fun isFirstLaunch() : Boolean {
        return SharedPref.getInstance(applicationContext).isFirstLaunch()
    }
}
