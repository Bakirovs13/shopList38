package com.example.shoplistapp38.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shop_dataDB")

data class ShopItemDBModel(

    var name: String,
    var count: Int,
    var enabled: Boolean,
    @PrimaryKey(autoGenerate = true)
    var id: Int

)



