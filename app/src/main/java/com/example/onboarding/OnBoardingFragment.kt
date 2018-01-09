package com.example.onboarding

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnBoardingFragment : Fragment() {

    interface OnBoardingListener {
        fun onNextClick()
    }

    companion object {
        val NAME = "name"

        /**
         * @param name a string to be displayed on the fragment
         * @param listener click listener to pass click events to the activity
         */
        fun newInstance(name : String, listener : OnBoardingListener) : Fragment {
            val fragment = OnBoardingFragment()
            val bundle = Bundle()
            bundle.putString(NAME, name)
            fragment.arguments = bundle
            fragment.onBoardingListener = listener
            return fragment
        }
    }

    private lateinit var onBoardingListener : OnBoardingListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_name.text = arguments.getString(NAME, "")

        // pass the click event to the activity
        tv_next.setOnClickListener({
            onBoardingListener.onNextClick()
        })
    }
}