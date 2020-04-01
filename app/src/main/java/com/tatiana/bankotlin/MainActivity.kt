package com.tatiana.bankotlin.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.tatiana.bankotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tip_content.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = OnboardingAdapter();
    }

    private inner class OnboardingAdapter : PagerAdapter () {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view = layoutInflater.inflate(R.layout.tip_content, container, false);

            view.tip_title.text = "TATIANA";

            container.addView(view);

            return view;
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }


        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`;
        }

        override fun getCount(): Int = 3

    }
}
