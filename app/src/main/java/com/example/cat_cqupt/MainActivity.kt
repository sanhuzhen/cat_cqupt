package com.example.cat_cqupt

import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.cat_cqupt.Adapter.ImagePaperAdapter
import com.example.cat_cqupt.base.BaseActivity
import java.util.Objects
import java.util.Timer
import java.util.TimerTask
import kotlin.math.abs

class MainActivity: BaseActivity() {
    private val imageList = listOf<Int>(R.drawable.img_2,R.drawable.img_3,R.drawable.img_1,R.drawable.ic_launcher_foreground)
    private var timer: Timer? = null
    private var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPaper()
    }
    private fun initViewPaper(){
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ImagePaperAdapter(this,imageList)

        timer = Timer()
        timer?.schedule(object: TimerTask(){
            override fun run() {
                runOnUiThread {
                    if (currentPage == (viewPager.adapter as ImagePaperAdapter).count - 1){
                        currentPage = 0
                    }else{
                        currentPage++
                    }
                    viewPager.setCurrentItem(currentPage,true)
                }
            }
        },0,3000)
        viewPager.setPageTransformer(true){ page , position ->
            val normalizedPosition = abs(abs(position) - 1)
            page.scaleX = normalizedPosition / 2 + 0.5f
            page.scaleY = normalizedPosition /2 + 0.5f
        }//实现滑动效果，避免太僵硬

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                if (position == (viewPager.adapter as ImagePaperAdapter).count -1) {
                    // 滑动到最后一页时，手动将ViewPager切换到第一页
                    viewPager.setCurrentItem(0, true)
                }
            }
            override fun onPageScrollStateChanged(state: Int) {}


        })
    }
}
