package com.example.shoplist38.domain.usecases

import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem

class EditSHopItemUseCase(private  val repository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem){
        repository.editShopItem(shopItem)
    }
}