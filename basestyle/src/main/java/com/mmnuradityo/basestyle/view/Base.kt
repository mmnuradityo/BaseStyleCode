package com.mmnuradityo.basestyle.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Base {

    interface Component {
        fun initView()
        fun loadView()
        fun listener()
        fun setData()
    }

    interface ActivityComponent : Component {
        fun setLayout(): Int
        fun initComponent(savedInstanceState: Bundle?)
    }

    interface FragmentComponent : Component {
        fun setLayout(): Int
        fun initComponent(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        )

        fun onFragmentView(view: View, savedInstanceState: Bundle?)
        fun fragmentView(): View
    }

    interface HolderComponent : Component {
        fun initComponent()
    }

    interface DialogComponent : ActivityComponent {
        fun setResourceBackground(): Int
        fun initBackround()
        fun setSizeDialog()
    }

}
