package com.example.shoplist38

import android.app.Application
import androidx.room.Room
import com.example.shoplist38.data.Room.ShopDataBase

class App:Application() {

    override fun onCreate() {
        super.onCreate()

        shopDataBase = Room.databaseBuilder(this, ShopDataBase::class.java, "database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var shopDataBase: ShopDataBase
    }
}