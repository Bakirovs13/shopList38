package com.example.shoplist38.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.shoplist38.App
import com.example.shoplist38.data.Room.ShopListMapper
import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem
import kotlin.random.Random


class ShopListRepositoryImpl() :ShopListRepository {

    private val mapper =ShopListMapper()
    private val dao = App.shopDataBase.shopListDao()


     init {
        for(i in 0 until 50){
            val item = ShopItem("Banana",i, Random.nextBoolean())
            dao.addShopItem(mapper.mapEntityToDBModel(item))
        }
    }


    override  fun addShopItem(shopItem: ShopItem) {
        dao.addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        dao.deleteShopItem(shopItem.id)

    }

    override fun editShopItem(shopItem: ShopItem) {
        dao.editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override suspend fun getShopItemByID(shopItemID: Int): ShopItem {
        return mapper.mapDBModelToEntity(dao.getShopItem(shopItemID))

    }


    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        dao.getShopList()
    ){
        mapper.mapListDBModeltoListentity(it)
    }



}