package com.example.basestylecode.view.activity

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.basestyle.view.BaseActivity
import com.example.basestylecode.R
import com.example.basestylecode.view.fragment.MainFragment

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
