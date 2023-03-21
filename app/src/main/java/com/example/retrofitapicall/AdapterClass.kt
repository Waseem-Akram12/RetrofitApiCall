package com.example.retrofitapicall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AdapterClass(var imageUrls:List<String>):RecyclerView.Adapter<AdapterClass.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView= itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageUrl = imageUrls[position]
        Glide.with(holder.itemView)
            .load(imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {return imageUrls.size}
}