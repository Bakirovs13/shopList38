package com.example.shoplistapp38.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


data class ShopItem(

    var name: String,
    var count: Int,
    var enabled: Boolean,
  //  @PrimaryKey(autoGenerate = true)
    var id: Int = UNDEFINED_ID

){
    companion object{
        const val UNDEFINED_ID = 0
    }
}

