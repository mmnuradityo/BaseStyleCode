package com.mmnuradityo.basestylecode.view.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.mmnuradityo.basestyle.view.BaseFragment
import com.mmnuradityo.basestyle.widget.showText
import com.mmnuradityo.basestylecode.R
import com.mmnuradityo.basestylecode.handler.CustomDialogTest
import com.mmnuradityo.basestylecode.handler.CustomDialogTest.OnCustomDialogTest
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), OnCustomDialogTest {

    private lateinit var text: String
    private lateinit var draw: Drawable

    override fun setLayout(): Int = R.layout.fragment_main

    override fun initComponent(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        text = activity!!.application.applicationInfo.name ?: "Name Application"
        draw = activity!!.getDrawable(R.drawable.ic_launcher_foreground)!!
    }

    override fun initView() {
        tv_id.text = text
    }

    override fun listener() {
        btn_show_image.setOnClickListener {
            if (!iv_img_test.isVisible) {
                iv_img_test.visibility = VISIBLE
                iv_img_test.setImageDrawable(draw)
                btn_show_image.visibility = GONE
                btn_show_Dilaog.visibility = VISIBLE
            }
        }

        btn_show_Dilaog.setOnClickListener {
            iv_img_test.visibility = GONE
            btn_show_image.visibility = VISIBLE
            btn_show_Dilaog.visibility = GONE
            CustomDialogTest(activity!!, this).show()
        }
    }

    override fun onCloseClick() {
        showText(activity!!, "Button Close Click")
        activity!!.onBackPressed()
    }

}
