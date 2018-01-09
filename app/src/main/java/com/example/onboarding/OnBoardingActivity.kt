package com.example.onboarding

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnBoardingActivity : AppCompatActivity(), OnBoardingFragment.OnBoardingListener {

    private var currentPage = 0
    private val fragments = ArrayList<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        val adapter = OnBoardingViewPagerAdapter(supportFragmentManager)
        for (i in 0..5) {
            fragments.add(OnBoardingFragment.newInstance(i.toString(), this))
        }
        adapter.addFragments(fragments)
        view_pager.adapter = adapter

        // keep track of the current screen
        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                currentPage = position
            }
        })
    }

    // open the main screen when next is tapped on the last screen
    override fun onNextClick() {
        if (currentPage == fragments.size - 1) {
            startActivity(Intent(this, MainActivity::class.java))
            SharedPref.getInstance(applicationContext).setIsFirstLaunchToFalse()
            finish()
        } else {
            view_pager.setCurrentItem(currentPage + 1, true)
        }
    }
}