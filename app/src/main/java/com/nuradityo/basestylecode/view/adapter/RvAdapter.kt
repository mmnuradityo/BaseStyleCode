package com.nuradityo.basestylecode.view.adapter

import android.content.Context
import android.view.View
import android.view.View.OnClickListener
import com.nuradityo.basestyle.view.BaseRvAdapter
import com.nuradityo.basestyle.widget.showText
import com.nuradityo.basestylecode.R
import com.nuradityo.basestylecode.model.DataModel
import com.nuradityo.basestylecode.view.adapter.RvAdapter.MyViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class RvAdapter(context: Context, private val view: RvAdapterOnLastPosition) :
    BaseRvAdapter<DataModel, MyViewHolder>(context) {

    override fun setLayoutItem(): Int = R.layout.item_list

    override fun injectHolder(v: View): MyViewHolder = MyViewHolder(v)

    override fun onBindCustomHolder(holder: MyViewHolder, position: Int) {
        super.onBindCustomHolder(holder, position)
        holder.injectView(view)
    }

    fun onLastPosition() {
        view.onLastItem(itemCount)
    }

    class MyViewHolder(v: View) : BaseHolder<DataModel>(v), OnClickListener {

        lateinit var view: RvAdapterOnLastPosition

        override fun initView() = with(itemView) {
            setOnClickListener(this@MyViewHolder)
            tv_title_item_list.text = getData().title
            tv_detail_item_list.text = getData().detail
        }

        fun injectView(view: RvAdapterOnLastPosition) {
            this.view = view
        }

        override fun onClick(v: View?) {
            view.onLastItem(getItemPosition() + 1)
            showText(itemView.context, "Position Item " + (getItemPosition() + 1))
        }

    }

    interface RvAdapterOnLastPosition {
        fun onLastItem(position: Int)
    }

}