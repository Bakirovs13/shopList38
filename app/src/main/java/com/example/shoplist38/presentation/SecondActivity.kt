package com.example.shoplist38.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist38.databinding.ActivitySecondBinding
import com.example.shoplistapp38.presentation.MainViewModel

class SecondActivity : AppCompatActivity() {

    var myAdapter = ShopListAdapter()
    private val viewModel:MainViewModel by viewModels()
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        initRecycler()
        initListeners()

    }

    private fun initListeners() {
        myAdapter.onItemCLick = {
            viewModel.changeEnableState(it)
        }
            
    }

    private fun initObservers() {
        viewModel.shopListLD.observe(this){
            myAdapter.shopList = it
        }
    }

    private fun initRecycler() {
        binding.mainRV.run {
            adapter =myAdapter
        }
        setupSwipeListener(binding.mainRV)
    }

    private fun setupSwipeListener(mainRV: RecyclerView) {
        val callBack  = object:ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
               return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               val item = myAdapter.shopList[viewHolder.absoluteAdapterPosition]
                viewModel.deleteShopItem(item)
            }
        }

        val itemTouchHelper = ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(mainRV)
    }
}