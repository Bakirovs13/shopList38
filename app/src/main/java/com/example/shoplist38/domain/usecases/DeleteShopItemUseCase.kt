package com.example.shoplistapp38.domain.usecases

import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem

class DeleteShopItemUseCase (private val repository: ShopListRepository){

    fun deleteShopItem(shopItem: ShopItem){
        repository.deleteShopItem(shopItem)
    }
}