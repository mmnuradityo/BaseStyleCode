package com.mmnuradityo.basestylecode.view.activity

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.mmnuradityo.basestyle.view.BaseActivity
import com.mmnuradityo.basestylecode.R
import com.mmnuradityo.basestylecode.view.fragment.MainFragment

class FragmentActivity : BaseActivity() {

    private lateinit var fragmentTransaction: FragmentTransaction

    override fun setLayout(): Int = R.layout.activity_fragment

    override fun initComponent(savedInstanceState: Bundle?) {
        fragmentTransaction = supportFragmentManager.beginTransaction()
    }

    override fun initView() {
        fragmentTransaction.replace(R.id.container, MainFragment())
        fragmentTransaction.commit()
    }

}
