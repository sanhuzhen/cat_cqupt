package com.example.cat_cqupt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.cat_cqupt.Adapter.ImagePaperAdapter
import com.example.cat_cqupt.base.BaseActivity
import kotlin.math.abs

class MainActivity: BaseActivity() {
    private val imageList = listOf<Int>(R.drawable.img_2,R.drawable.img_3,R.drawable.img_1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPaper()
    }
    private fun initViewPaper(){
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ImagePaperAdapter(this,imageList)
        viewPager.setPageTransformer(true){ page , position ->
            val normalizedPosition = abs(abs(position) - 1)
            page.scaleX = normalizedPosition / 2 + 0.5f
            page.scaleY = normalizedPosition /2 + 0.5f
        }//实现滑动效果，避免太僵硬
    }
}