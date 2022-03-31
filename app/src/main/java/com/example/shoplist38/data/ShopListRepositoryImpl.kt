package com.example.shoplist38.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoplistapp38.domain.ShopListRepository
import com.example.shoplistapp38.domain.entities.ShopItem
import java.lang.RuntimeException
import kotlin.random.Random

class ShopListRepositoryImpl :ShopListRepository {

     private val shopListLD = MutableLiveData<List<ShopItem>>()

    private val list  = sortedSetOf<ShopItem>({o1,o2->o1.id.compareTo(o2.id)})

    private  var autoIncrementId= 0


     init {
         // цикл 50 элементов  рандомно enable

         for (i in 0 until 50){
             val item = ShopItem("Banana: $i",i, Random.nextBoolean())
             addShopItem(item)


         }

     }

    override fun addShopItem(shopItem: ShopItem) {

        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        list.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        list.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)

    }


     override fun getShopItem(shopItemID: Int):ShopItem {
     return list.find {
         it.id ==shopItemID
     } ?:throw  RuntimeException("Element with ID$shopItemID not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

     private  fun updateList(){
         shopListLD.value = list.toList()

     }

}