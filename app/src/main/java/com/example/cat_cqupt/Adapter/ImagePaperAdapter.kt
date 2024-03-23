package com.example.cat_cqupt.Adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

/**
 * TODO:建立一个适配器用于展示多张图片
 */
class ImagePaperAdapter(private val context: Context, private val imageList: List<Int>) : PagerAdapter() {

    //返回想要展示的页面数
    override fun getCount(): Int {
        return imageList.size
    }

    //判断页面视图是否与指定图片相符
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }


    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }//实现循环，让viewPaper以为有无数个页面

    //实例化imageview
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.setImageResource(imageList[position])

        container.addView(imageView)
        return imageView
    }

    //用于销毁页面
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}


