package com.tatiana.bankotlin.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.tatiana.bankotlin.R
import com.tatiana.bankotlin.Tip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tip_content.view.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContentView(R.layout.activity_main)

        val tips: Array<Tip> = arrayOf(
            Tip(
                "1 Duis metus mi, tristique sit amet dolor sit",
                "lorem",
                R.drawable.house,
                R.drawable.backgroundblue
            ),
            Tip(
                "2 Duis metus mi, tristique sit amet dolor sit",
                "lorem",
                R.drawable.woman,
                R.drawable.backgroundpink
            ),
            Tip("3 Duis metus mi, tristique sit amet dolor sit",
                "lorem",
                R.drawable.sofa,
                R.drawable.backgroundorange
            )
            )

        addDots(tips.size)

        viewpager.adapter = OnboardingAdapter(tips)

        viewpager.setPageTransformer(true){page: View, position: Float ->
            page.alpha = 1 - abs(position)
            page.translationX = -position * page.width
        }

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                addDots(tips.size, position)

            }
        })
    }

    private fun addDots(size: Int, position: Int = 0) {
        dots.removeAllViews()
        Array(size) {
            val textView  = TextView(baseContext).apply {
                text = getText(R.string.dotted)
                textSize = 35f
                setTextColor(
                    if  (position == it) ContextCompat.getColor(baseContext, android.R.color.white)
                    else ContextCompat.getColor(baseContext, android.R.color.darker_gray)
                )
            }
            dots.addView(textView)
        }

    }

    private inner class OnboardingAdapter(val tips: Array<Tip>) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = layoutInflater.inflate(R.layout.tip_content, container, false)

        with(tips[position]) {
            view.tip_title.text = title
            view.tip_subtitle.text = subtitle
            view.tip_logo.setImageResource(logo)
            view.background = ContextCompat.getDrawable(this@MainActivity, background)
        }

            container.addView(view);

            return view;
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }


        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`;
        }

        override fun getCount(): Int = tips.size

    }
}
