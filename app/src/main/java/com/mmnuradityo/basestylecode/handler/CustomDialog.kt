package com.mmnuradityo.basestylecode.handler

import android.app.Activity
import android.os.Bundle
import com.mmnuradityo.basestyle.view.BaseCustomDialog
import com.mmnuradityo.basestylecode.R
import kotlinx.android.synthetic.main.custom_dialog_test.*

class CustomDialogTest(activity: Activity, private val view: OnCustomDialogTest) :
    BaseCustomDialog(activity) {

    override fun setResourceBackground(): Int = 0

    override fun setLayout(): Int = R.layout.custom_dialog_test

    override fun initComponent(savedInstanceState: Bundle?) {
    }

    override fun initView() {
        btn_close_custome_dialog.setOnClickListener {
            view.onCloseClick()
            this.dismiss()
        }
    }


    interface OnCustomDialogTest {
        fun onCloseClick()
    }
}