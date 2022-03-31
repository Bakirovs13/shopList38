package com.example.shoplistapp38.domain.usecases

import androidx.lifecycle.LiveData
import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem

class GetShopListUseCase(private  val repository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
      return  repository.getShopList()
    }

}