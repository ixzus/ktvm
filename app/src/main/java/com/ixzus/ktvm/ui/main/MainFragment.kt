package com.ixzus.ktvm.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixzus.ktvm.R
import com.ixzus.ktvm.ext.replaceFragment
import com.ixzus.ktvm.ui.find.FindFragment
import com.ixzus.ktvm.ui.more.MoreFragment
import com.ixzus.ktvm.ui.music.MusicFragment
import com.ixzus.ktvm.ui.read.ReadFragment
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx

class MainFragment : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    lateinit var navigationView: BottomNavigationView
    var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return MainUi().createView(AnkoContext.Companion.create(ctx, this))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (index == 0) replaceFragment(MainUi.id_content, ReadFragment.newInstance("", ""))
        navigationView.setOnNavigationItemSelectedListener { item ->
            index = item.itemId
            when (index) {
                R.id.menu_read -> {
                    replaceFragment(MainUi.id_content, ReadFragment.newInstance("", ""))
                }
                R.id.menu_music -> {
                    replaceFragment(MainUi.id_content, MusicFragment.newInstance("", ""))
                }
                R.id.menu_find -> {
                    replaceFragment(MainUi.id_content, FindFragment.newInstance("", ""))
                }
                R.id.menu_more -> {
                    replaceFragment(MainUi.id_content, MoreFragment.newInstance("", ""))
                }
            }
            true
        }
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
