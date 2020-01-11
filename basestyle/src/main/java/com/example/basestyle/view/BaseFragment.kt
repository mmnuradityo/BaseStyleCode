package com.example.basestyle.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), Base.FragmentComponent {

    private lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(setLayout(), container, false)
        initComponent(inflater, container, savedInstanceState)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentView(view, savedInstanceState)
        initView()
        loadView()
        listener()
        setData()
    }

    override fun onFragmentView(view: View, savedInstanceState: Bundle?) {
    }

    override fun fragmentView(): View = v

    override fun loadView() {
    }

    override fun listener() {
    }

    override fun setData() {
    }

}
