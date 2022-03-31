package com.example.shoplist38.presentation

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplist38.databinding.ActivitySecondBinding
import com.example.shoplistapp38.presentation.MainViewModel


class SecondActivity : AppCompatActivity() {

    private var myAdapter = ShopListAdapter()
    private val viewModel:MainViewModel by viewModels()
    private lateinit var binding:ActivitySecondBinding
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
            ItemTouchHelper.LEFT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
               return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showAlert(viewHolder)
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive
                )
                viewHolder.apply {
                val background =ColorDrawable(Color.RED)
                background.setBounds(
                    itemView.right , itemView.top,
                    itemView.right+ dX.toInt() , itemView.bottom)
                background.draw(c)
            }
            }  //onChildDraw
        }

        val itemTouchHelper = ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(mainRV)
    }

    private fun showAlert(viewHolder: RecyclerView.ViewHolder) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Delete Task")
        dialog.setMessage("Are you sure you want to delete this Task?")
        dialog.setPositiveButton("Confirm") { _, _ ->    //   <-- delete task on swipe
            val item = myAdapter.shopList[viewHolder.absoluteAdapterPosition]
            viewModel.deleteShopItem(item)
        }
        dialog.setNegativeButton("Cancel"
        ) { _, _ -> myAdapter.notifyItemChanged(viewHolder.absoluteAdapterPosition) }
        dialog.show()

    }

}