package com.example.shoplist38.domain.usecases

import androidx.lifecycle.LiveData
import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem

class GetShopItemUseCase (private val repository: ShopListRepository){

    suspend fun getShopItem(id: Int): ShopItem {
        return repository.getShopItemByID(id)
    }
}