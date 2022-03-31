package com.example.shoplist38.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.shoplist38.R
import com.example.shoplist38.databinding.ActivityMainBinding
import com.example.shoplistapp38.domain.entities.ShopItem
import com.example.shoplistapp38.presentation.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    private val shopList = mutableListOf<ShopItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObserves()
        initListeners()
    }

    private fun initListeners() {
      binding.startBtn.setOnClickListener {
          viewModel.addShopItem(ShopItem(name = "Apples", count = 2, enabled = false ))
      }
        binding.editBtn.setOnClickListener {
            viewModel.changeEnableState(ShopItem(name = "Apples", count = 2, enabled = false, id = 0))
        }

    }

    private fun initObserves() {
        viewModel.shopListLD.observe(this){
            Log.e("Shamal","Shoplist: $it")
        }
    }
}