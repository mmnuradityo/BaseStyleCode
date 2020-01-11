package com.example.basestylecode.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.basestyle.view.BaseActivity
import com.example.basestylecode.R
import com.example.basestylecode.repositoies.DataDefault.Companion.addDataItem
import com.example.basestylecode.repositoies.DataDefault.Companion.addDataList
import com.example.basestylecode.repositoies.DataDefault.Companion.getAll
import com.example.basestylecode.view.adapter.RvAdapter
import com.example.basestylecode.view.adapter.RvAdapter.*
import kotlinx.android.synthetic.main.activity_main.*

class MainBaseActivity : BaseActivity(), RvAdapterOnLastPosition {

    private lateinit var rvAdapter: RvAdapter

    override fun setLayout(): Int = R.layout.activity_main

    override fun initComponent(savedInstanceState: Bundle?) {
        rvAdapter = RvAdapter(this, this)
    }

    override fun initView() {
        rv_list_data_main.setHasFixedSize(true)
        rv_list_data_main.adapter = rvAdapter
    }

    override fun listener() {
        btn_add_list_main.setOnClickListener {
            rvAdapter.addOrUpdate(addDataList())
            rvAdapter.onLastPosition()
        }
    }

    override fun setData() {
        super.setData()
        rvAdapter.addOrUpdate(getAll())
        rvAdapter.onLastPosition()
    }

    override fun onLastItem(position: Int) {
        btn_add_data_main.setOnClickListener {
            rvAdapter.addOrUpdate(addDataItem(position))
            rvAdapter.onLastPosition()
        }
    }

    fun btnSwitchToFragmentActivity(view: View) {
        startActivity(Intent(this, FragmentActivity::class.java))
    }

}
