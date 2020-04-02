package com.tatiana.bankotlin.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.tatiana.bankotlin.R
import com.tatiana.bankotlin.Tip
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tip_content.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        viewpager.adapter = OnboardingAdapter(tips)
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
