package com.example.shoplistapp38.presentation

import androidx.lifecycle.ViewModel
import com.example.shoplist38.domain.usecases.EditSHopItemUseCase
import com.example.shoplist38.data.ShopListRepositoryImpl
import com.example.shoplistapp38.domain.entities.ShopItem
import com.example.shoplistapp38.domain.usecases.AddShopItemUseCase
import com.example.shoplistapp38.domain.usecases.DeleteShopItemUseCase
import com.example.shoplistapp38.domain.usecases.GetShopListUseCase

class MainViewModel:ViewModel() {

    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase =GetShopListUseCase(repository)
    private val deleteShopListUseCase =DeleteShopItemUseCase(repository)
    private  val addShopItemUseCase =AddShopItemUseCase(repository)
    private  val editSHopItemUseCase =EditSHopItemUseCase(repository)


    val shopListLD = getShopListUseCase.getShopList()



    fun addShopItem(shopItem: ShopItem){
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopListUseCase.deleteShopItem(shopItem)
    }


    fun changeEnableState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editSHopItemUseCase.editShopItem(newItem)
    }



}