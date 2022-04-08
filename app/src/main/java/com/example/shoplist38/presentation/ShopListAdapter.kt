package com.example.shoplist38.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist38.R
import com.example.shoplistapp38.domain.entities.ShopItem
import java.lang.RuntimeException


class ShopListAdapter: ListAdapter<ShopItem,ShopListAdapter.ShopItemViewHolder>(ShopListItemDiffCallback()) {

    var onItemCLick :((ShopItem)->Unit)? = null
    var onLongItemCLick :((Int)->Unit)? = null
  //  var shopList = listOf<ShopItem>()



    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return  if (item.enabled){
            VIEW_TYPE_ENABLED
        }else{
            VIEW_TYPE_DISABLED
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val layout = when(viewType){
            VIEW_TYPE_DISABLED->R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED->R.layout.item_shop_enabled
            else -> throw RuntimeException("Unknown view type : $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        holder.onBind(getItem(position))

    }



    inner class ShopItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        private  var productName:TextView = itemView.findViewById(R.id.tv_name)
        private  var counter :TextView = itemView.findViewById(R.id.tv_count)


        fun onBind(shopItem: ShopItem) {
            productName.text = shopItem.name
            counter.text = shopItem.count.toString()

            itemView.setOnLongClickListener {
                onLongItemCLick?.invoke(position)
              return@setOnLongClickListener true
            }
            itemView.setOnClickListener {
                onItemCLick?.invoke(shopItem)
            }

        }


    }

    companion object{
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

    }


}