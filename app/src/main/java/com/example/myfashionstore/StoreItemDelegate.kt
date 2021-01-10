package com.example.myfashionstore

import android.R.attr.data
import android.R.attr.listPreferredItemPaddingRight
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.example.myfashionstore.ui.main.loadImg
import kotlinx.android.synthetic.main.item_store.view.*
import java.util.*


data class StoreItem(
    val title: String,
    val image: String,
    val description: String,
    val price:Long,
    val discount:Int,
) {
    constructor() : this("", "", "",0,0)
}

class StoreItemDelegate(var mContext: Context) :
    ItemViewBinder<StoreItem, StoreItemDelegate.ViewHolder>() {

    var onItemClick: ((item: StoreItem) -> Unit)? = null

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(
            inflater.inflate(
                R.layout.item_store,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, item: StoreItem) {
        holder.bind(item, getPosition(holder))
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: StoreItem, position: Int) = with(itemView) {
            title.text=item.title
            image.loadImg(item.image, 100)
            description.text=item.description
            discount.text=""+item.discount.toString()+"% OFF"
            price.paintFlags = price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            price.text=item.price.toString()
            val actualPrice=item.price -((item.price*item.discount)/100);
            actuallPrice.text= "Rs. $actualPrice"

        }
    }
}