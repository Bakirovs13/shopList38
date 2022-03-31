package com.example.shoplistapp38.domain.usecases

import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem

class AddShopItemUseCase(private  val repository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }

    fun deleteItem(shopItem: ShopItem){
        repository.addShopItem(shopItem)
    }
}