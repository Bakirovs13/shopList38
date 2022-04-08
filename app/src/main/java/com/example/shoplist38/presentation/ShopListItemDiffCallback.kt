package com.example.shoplist38.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoplistapp38.domain.entities.ShopItem

class ShopListItemDiffCallback : DiffUtil.ItemCallback<ShopItem>() {


    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}