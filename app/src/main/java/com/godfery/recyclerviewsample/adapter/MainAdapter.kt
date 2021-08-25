package com.godfery.recyclerviewsample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.godfery.recyclerviewsample.databinding.ItemLayoutBinding
import com.godfery.recyclerviewsample.model.BeerResponse

class MainAdapter ( private val items : ArrayList<BeerResponse> ): RecyclerView.Adapter<MainAdapter.DataViewHolder>(){


    class DataViewHolder(private val binding: ItemLayoutBinding) :RecyclerView.ViewHolder(binding.root){

        fun bind(item : BeerResponse){

            binding.itemName.text = item.name
            binding.itemTagline.text = item.tagline

            Glide.with(binding.root)
                .load( item.image_url)
                .centerInside()
                .placeholder( android.R.drawable.gallery_thumb)
                .error(android.R.drawable.stat_notify_error)
                .into(binding.itemThumbnail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder = DataViewHolder(
                ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =  holder.bind(items[position])

    override fun getItemCount(): Int  =  items.size

    fun addData(list : List<BeerResponse>){
        items.addAll(list)
    }


}