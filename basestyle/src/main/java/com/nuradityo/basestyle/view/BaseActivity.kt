package com.nuradityo.basestyle.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nuradityo.basestyle.view.Base.ActivityComponent

abstract class BaseActivity : AppCompatActivity(), ActivityComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initComponent(savedInstanceState)
        initView()
        loadView()
        listener()
        setData()
    }

    override fun loadView() {
    }

    override fun listener() {
    }

    override fun setData() {
    }

}