package com.nuradityo.basestyle.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuradityo.basestyle.view.BaseRvAdapter.BaseHolder

abstract class BaseRvAdapter<Item, VH : BaseHolder<Item>>(private val context: Context) :
    RecyclerView.Adapter<VH>() {

    private var data: ArrayList<Item> = ArrayList()

    fun addOrUpdate(list: ArrayList<Item>) {
        for (item in list) {
            val position = findPosition(item)
            if (position == -1) {
                this.data.add(item)
            }
        }
        notifyDataSetChanged()
    }

    fun addOrUpdate(item: Item) {
        val position = findPosition(item)
        if (position == -1) {
            this.data.add(item)
        }
        notifyDataSetChanged()
    }

    private fun findPosition(item: Item): Int {
        var position = -1
        val size = itemCount - 1
        for (i in size downTo 0) {
            if (this.data[i]!! == item) {
                position = i
            }
        }
        return position
    }

    abstract fun setLayoutItem(): Int

    abstract fun injectHolder(v: View): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH =
        injectHolder(LayoutInflater.from(context).inflate(setLayoutItem(), parent, false))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.init()
        holder.bind(data[position], position)
        onBindCustomHolder(holder, position)
    }

    open fun onBindCustomHolder(holder: VH, position: Int) {
    }

    abstract class BaseHolder<Item>(v: View) : RecyclerView.ViewHolder(v),
        Base.HolderComponent {

        private var data: Item? = null
        private var position: Int? = null

        fun init() {
            initComponent()
        }

        open fun bind(item: Item, position: Int) {
            this.data = item
            this.position = position
            initView()
            loadView()
            setData()
            listener()
        }

        open fun getData() = data!!

        open fun getItemPosition() = position!!

        override fun initComponent() {
        }

        override fun loadView() {
        }

        override fun listener() {
        }

        override fun setData() {
        }
    }

}
