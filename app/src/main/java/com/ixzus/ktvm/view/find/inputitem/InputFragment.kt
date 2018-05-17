package com.ixzus.ktvm.view.find.inputitem


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ixzus.ktvm.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.ctx


/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = InputUi().createView(AnkoContext.Companion.create(ctx,this))
        return view
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): InputFragment {
            val fragment = InputFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}
