package com.nuradityo.basestyle.view

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import com.nuradityo.basestyle.R
import java.util.*

abstract class BaseCustomDialog(private val activity: Activity) : Dialog(activity),
    Base.DialogComponent {

    companion object {
        private const val MARGIN_SIZE = 32
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(setLayout())
        setSizeDialog()
        initBackround()
        initComponent(savedInstanceState)
        initView()
        loadView()
        listener()
        setData()
    }

    override fun setSizeDialog() {
        Objects.requireNonNull<Window>(window).setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun initBackround() {
        (if (setResourceBackground() != 0) {
            window!!.setBackgroundDrawable(
                InsetDrawable(
                    ContextCompat.getDrawable(
                        activity,
                        setResourceBackground()
                    ), MARGIN_SIZE
                )
            )
        } else {
            window!!.setBackgroundDrawable(
                InsetDrawable(
                    ContextCompat.getDrawable(
                        activity,
                        R.drawable.basestyle_bg_rounded
                    ), MARGIN_SIZE
                )
            )
        })
    }

    override fun loadView() {
    }

    override fun listener() {
    }

    override fun setData() {
    }

}