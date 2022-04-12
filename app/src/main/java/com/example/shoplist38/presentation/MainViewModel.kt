package com.example.shoplistapp38.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoplist38.domain.usecases.EditSHopItemUseCase
import com.example.shoplist38.data.ShopListRepositoryImpl
import com.example.shoplist38.domain.usecases.GetShopItemUseCase
import com.example.shoplistapp38.domain.entities.ShopItem
import com.example.shoplistapp38.domain.usecases.AddShopItemUseCase
import com.example.shoplistapp38.domain.usecases.DeleteShopItemUseCase
import com.example.shoplistapp38.domain.usecases.GetShopListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {



    private val repository = ShopListRepositoryImpl()

    private val getShopListUseCase =GetShopListUseCase(repository)
    private val deleteShopListUseCase =DeleteShopItemUseCase(repository)
    private  val addShopItemUseCase =AddShopItemUseCase(repository)
    private  val editSHopItemUseCase =EditSHopItemUseCase(repository)
    private  val getShopItemUseCase =GetShopItemUseCase(repository)


    val shopListLD = getShopListUseCase.getShopList()


    suspend fun getShopItem(id: Int): ShopItem {
        return getShopItemUseCase.getShopItem(id)
    }


    fun addShopItem(shopItem: ShopItem){
        viewModelScope.launch (Dispatchers.IO){
            addShopItemUseCase.addShopItem(shopItem)

        }
    }

    suspend fun deleteShopItem(shopItem: ShopItem){
        viewModelScope.launch (Dispatchers.IO){
            deleteShopListUseCase.deleteShopItem(shopItem)
        }
    }


    fun changeEnableState(shopItem: ShopItem){
        viewModelScope.launch (Dispatchers.IO){
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editSHopItemUseCase.editShopItem(newItem)
        }

    }



}