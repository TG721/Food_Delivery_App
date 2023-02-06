package com.tengizmkcorp.food_delivery.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import com.tengizmkcorp.food_delivery.data.remote.model.DiscoverSubListItem
import com.tengizmkcorp.food_delivery.databinding.DiscoverItemBinding


class DiscoverItemAdapter(
) : ListAdapter<DiscoverSubListItem, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    inner class DiscoverItemViewHolder(private val binding: DiscoverItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val source = getItem(absoluteAdapterPosition)
            binding.apply {
                title.text = source.title
                description.text = source.description
                Glide.with(imageView)
                    .load(source.picture)
                    .into(imageView)
                //case of Fresh Deals
                if(source.description.length<6)  {
                    description.textSize = 36.0f
                    description.setTextColor(Color.parseColor("#e50d0d"));
                    description.setTypeface(null, Typeface.BOLD);
                    val rootDimensions = rootLayout.layoutParams
                    rootDimensions.width= 240
                    cardView.layoutParams.width = 220
                    imageView.layoutParams.width = 220
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = DiscoverItemBinding.inflate(layoutInflater, parent, false)
            return DiscoverItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      return (holder as DiscoverItemViewHolder).bind()
    }

    private class ItemDiffCallback : DiffUtil.ItemCallback<DiscoverSubListItem>() {
        override fun areItemsTheSame(
            oldItem: DiscoverSubListItem,
            newItem: DiscoverSubListItem,
        ): Boolean =
            oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: DiscoverSubListItem,
            newItem: DiscoverSubListItem,
        ): Boolean =
            oldItem == newItem

    }
}
