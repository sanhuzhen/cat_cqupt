package com.example.cat_cqupt.PageTransformor

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.example.cat_cqupt.MainActivity
import com.example.cat_cqupt.R
import com.example.cat_cqupt.R.*

/**
 * 建立一个适配器用于展示多张图片
 */
class ImagePaperAdapter(private val context: Context, val imageList: List<Int>) : PagerAdapter() {

    //返回想要展示的页面数
    override fun getCount(): Int {
        return imageList.size
    }

    //判断页面视图是否与指定图片相符
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    //实例化imageview
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.setImageResource(imageList[position])
        container.addView(imageView)
        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://www.cqupt.edu.cn/")
            Toast.makeText(context, "jj", Toast.LENGTH_LONG).show()

        }
        return imageView
    }


    //用于销毁页面
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}


