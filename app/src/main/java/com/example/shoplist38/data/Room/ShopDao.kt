package com.example.shoplist38.data.Room


import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoplistapp38.domain.entities.ShopItemDBModel


@Dao
interface ShopDao {

    @Query("SELECT * FROM shop_dataDB")
     fun getShopList(): LiveData<List<ShopItemDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addShopItem(shopItemDbModel: ShopItemDBModel)

    @Query("DELETE FROM shop_dataDB WHERE id=:shopItemId")
    suspend fun deleteShopItem(shopItemId: Int)


    @Query("SELECT * FROM shop_dataDB WHERE id=:shopItemId LIMIT 1")
     suspend fun getShopItem(shopItemId: Int): ShopItemDBModel

     @Update
     fun editShopItem(shopItemDbModel: ShopItemDBModel)
}