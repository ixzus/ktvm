package com.ixzus.ktvm.view.forecast

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.ixzus.ktvm.R
import com.ixzus.ktvm.adapter.KtAdapter
import com.ixzus.ktvm.helper.ext.loadImgFromUrl
import com.ixzus.ktvm.view.toolbar.ToolbarManager
import kotlinx.android.synthetic.main.activity_forecast_list.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class ForecastListActivity : AppCompatActivity(), ToolbarManager {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7",
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7",
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7",
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_list)

        initToolbar()
        toolbarTitle = "首页"
        enableHomeAsUp {
            toast("后退")
            onBackPressed()
        }

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
//        forecastList.adapter = ForecastListAdapter(items)
        forecastList.adapter = KtAdapter(R.layout.rv_item, items, init = { view, bean ->
            view.find<TextView>(R.id.tvItem).text = bean
            var url = "http://h.hiphotos.baidu.com/image/h%3D300/sign=afbdb5c0b03eb1355bc7b1bb961fa8cb/7a899e510fb30f246d10752bc495d143ad4b030b.jpg"
            view.find<ImageView>(R.id.ivItem).loadImgFromUrl(url)
        })

        /*doAsync {
            uiThread {
                longToast("ForecastRequest performed")
            }
        }*/
    }

}
