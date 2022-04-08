package com.example.shoplist38.data.Room

import com.example.shoplistapp38.domain.entities.ShopItem
import com.example.shoplistapp38.domain.entities.ShopItemDBModel

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDBModelToEntity(shopItemDBModel: ShopItemDBModel) =ShopItem(
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        enabled = shopItemDBModel.enabled,
        count = shopItemDBModel.count
    )

    fun mapListDBModeltoListentity(list: List<ShopItemDBModel>) = list.map {shopItemDBModel->
        mapDBModelToEntity(shopItemDBModel)
    }
}