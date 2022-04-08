package com.example.shoplist38.data.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shoplistapp38.domain.entities.ShopItemDBModel


@Database(entities = [ShopItemDBModel::class], version = 4, exportSchema = false)

abstract class ShopDataBase : RoomDatabase() {
    abstract fun shopListDao(): ShopDao
}