package com.ixzus.ktvm.ui.splash

import android.view.Gravity
import android.widget.ImageView
import com.ixzus.ktvm.ext.loadImgFromUrl
import org.jetbrains.anko.*

/**
 * Created by Administrator on 2018/3/2.
 */
class SplashUi : AnkoComponent<SplashFragment> {

    override fun createView(ui: AnkoContext<SplashFragment>) = with(ui) {
        frameLayout {
            owner.btnNext = button("立即体验") {
                //                onClick { startActivity<ForecastListActivity>() }

            }.lparams() {
                gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
                bottomMargin = dip(32)
            }
            imageView {
                val url = "http://www.pstxg.com/UploadFiles/201504/2015042140831785.jpg"
                scaleType = ImageView.ScaleType.CENTER_CROP
//                imageResource = R.mipmap.ic_launcher
                loadImgFromUrl(url)
            }
        }
    }
}