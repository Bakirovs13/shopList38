package com.example.shoplistapp38.domain

import androidx.lifecycle.LiveData
import com.example.shoplistapp38.domain.entities.ShopItem

interface ShopListRepository  {

    //do not change

    fun addShopItem(shopItem: ShopItem){
    }

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

    fun getShopItem(shopItemID: Int): ShopItem
}