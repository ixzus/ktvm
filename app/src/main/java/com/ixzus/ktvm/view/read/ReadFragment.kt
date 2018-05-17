package com.ixzus.ktvm.view.read


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ixzus.ktvm.R
import com.ixzus.ktvm.adapter.KtAdapter
import com.ixzus.ktvm.helper.ext.loadImgFromUrl
import com.ixzus.ktvm.model.data.GankModel
import com.ixzus.ktvm.model.remote.DaggerNetComponent
import com.ixzus.ktvm.model.remote.net.ApiService
import com.ixzus.ktvm.model.repository.GankRepository
import com.ixzus.ktvm.model.repository.ReadViewModel
import com.ixzus.ktvm.view.base.BaseFragment
import com.ixzus.ktvm.viewmodel.Injection
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.ctx
import timber.log.Timber
import javax.inject.Inject


class ReadFragment : BaseFragment() {

    @Inject
    lateinit var gankRepository: GankRepository

    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var readViewModel: ReadViewModel

    private var mParam1: String? = null
    private var mParam2: String? = null
    lateinit var recyclerView: RecyclerView
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var dataList: List<GankModel.AndroidResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = ReadUi().createView(AnkoContext.Companion.create(ctx, this))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerNetComponent.create().inject(this)
        viewModelFactory = Injection.provideViewModelFactory(gankRepository)
        readViewModel = ViewModelProviders.of(this, viewModelFactory).get(ReadViewModel::class.java)
        subscribeUi(readViewModel)
    }

    fun subscribeUi(readViewModel: ReadViewModel) {
        readViewModel.getAndroid("10", "1").observe(this,
                Observer<List<GankModel.AndroidResult>> { data ->
                    if (null != data) {
                        dataList = ArrayList()
                        dataList = data
                        updateUI(dataList)
                    }
                    Timber.i("onChanged: " + data?.size)
                })

        readViewModel.isLoading().observe(this, Observer<Boolean> {
            it?.let {
                if (it) {
                    Timber.e("加载中。。。")
                } else {
                    Timber.e("加载OK。。。")
                }
            }
        })

    }

    fun refreshUI() {
        readViewModel.getAndroid("3", "1").observe(this,
                Observer<List<GankModel.AndroidResult>> { data ->
                    if (null != data) {
                        dataList = ArrayList()
                        dataList = data
                        updateUI(dataList)
                    }
                    Timber.i("onChanged: " + data?.size)
                })
    }


    private fun updateUI(dataList: List<GankModel.AndroidResult>) {

        recyclerView.adapter = KtAdapter(R.layout.rv_item, dataList, init = { view, bean ->
            view.find<TextView>(R.id.tvItem).text = bean.desc
            var url = bean.images?.get(0)
            url?.let { view.find<ImageView>(R.id.ivItem).loadImgFromUrl(url) }

        })

    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"
        val gankService by lazy {
            ApiService.create("")
        }

        fun newInstance(param1: String, param2: String): ReadFragment {
            val fragment = ReadFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor