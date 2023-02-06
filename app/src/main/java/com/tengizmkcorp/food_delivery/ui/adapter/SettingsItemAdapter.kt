package com.tengizmkcorp.food_delivery.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tengizmkcorp.food_delivery.databinding.SettingsItemBinding
import com.tengizmkcorp.food_delivery.ui.element.SettingsFragmentDirections
import com.tengizmkcorp.food_delivery.ui.model.SettingsItem

class SettingsItemAdapter() :
    ListAdapter<SettingsItem, SettingsItemAdapter.SettingsItemViewHolder>(ItemDiffCallback()) {

    inner class SettingsItemViewHolder(private val binding: SettingsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind() {
            if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                val source: SettingsItem = getItem(absoluteAdapterPosition)
            binding.titleTV.text = source.title
            binding.expandBTN.setOnClickListener {
                when (absoluteAdapterPosition) {
                    0 -> {
                        val action =
                            SettingsFragmentDirections.actionSettingsFragmentToContactsFragment() //current item
                        binding.rootLayout.findNavController().navigate(action)
                    }
                }
            }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingsItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SettingsItemBinding.inflate(layoutInflater, parent, false)
        return SettingsItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingsItemViewHolder, position: Int) {
        holder.bind()
    }

    private class ItemDiffCallback : DiffUtil.ItemCallback<SettingsItem>() {
        override fun areItemsTheSame(oldItem: SettingsItem, newItem: SettingsItem): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: SettingsItem, newItem: SettingsItem): Boolean =
            oldItem == newItem

    }

}

