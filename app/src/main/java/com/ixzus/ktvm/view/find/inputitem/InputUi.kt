package com.ixzus.ktvm.view.find.inputitem

import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.ixzus.ktvm.R
import com.ixzus.ktvm.helper.weidget.InputItem
import com.ixzus.ktvm.helper.weidget.circleImageView
import com.ixzus.ktvm.helper.weidget.settingItem
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by Administrator on 2018/3/7.
 */
class InputUi : AnkoComponent<InputFragment> {
    override fun createView(ui: AnkoContext<InputFragment>) = with(ui) {
        verticalLayout {
            padding = dip(16)
            circleImageView {
                imageResource = R.mipmap.ic_launcher
            }.lparams(width = wrapContent, height = wrapContent) {
                gravity = Gravity.CENTER_HORIZONTAL
            }

            InputItem(headImageResource = R.mipmap.ic_phone, hintResourceInt = R.string.app_name) { text ->
                text.length == 11
            }.getInputItem(viewManager = this).lparams(width = matchParent, height = dip(45)) {
                topMargin = dip(8)
            }

            InputItem(headImageResource = R.mipmap.ic_password,
                    hintResourceInt = R.string.app_name,
                    inputTypeEdit = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) { text ->
                text.length >= 8
            }.getInputItem(viewManager = this).lparams(width = matchParent, height = dip(45)) {
                topMargin = dip(8)
            }

            settingItem(viewManager = this, text = "我的头像", myView = CircleImageView(ctx)) {
                imageResource = R.mipmap.ic_launcher
            }.lparams(width = matchParent, height = dip(58))

            settingItem(viewManager = this, text = "我的手机号", enterImageRes = 0, myView = TextView(ctx)) {
                text = "13510000000".replaceRange(3..7,"****")
                gravity = Gravity.CENTER_VERTICAL or Gravity.START
                textColorResource = android.R.color.darker_gray
                textSize = 14f
            }.lparams(width = matchParent, height = dip(58))

            settingItem<View>(viewManager = this, text = "设置", imageResId = R.mipmap.ic_phone)
                    .lparams(width = matchParent, height = dip(58))
                    .onClick {
                        toast("click")
                    }

        }
    }
}