package com.example.myfashionstore.ui.main

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.drakeet.multitype.MultiTypeAdapter
import com.example.myfashionstore.R

fun ImageView.loadImg(
    imgUrl: String,
    resize: Int = 0,
    defaultImage: Int = R.drawable.ic_baseline_image_24
) {
    if (imgUrl != ""){
        if(resize==0){
//            val radius = 30 // corner radius, higher value = more rounded
//            val margin = 10 // crop margin, set to 0 for corners with no crop

            Glide.with(context)
                .load(imgUrl)
                .error(defaultImage)
                .placeholder(defaultImage)
//                .transform(RoundedCornersTransformation(radius, margin))
                .into(this)
        }
        else{
            Glide.with(context)
                .load(imgUrl)
                .placeholder(defaultImage)
                .override(resize,resize)
                .error(defaultImage)
                .into(this)
        }
    }
}
fun RecyclerView.setMultiRv(context: Context, adapter: MultiTypeAdapter) {
    layoutManager = LinearLayoutManager(context)
    this.adapter = adapter
}
