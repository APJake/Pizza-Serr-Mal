package com.apjake.pizzaserrmal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.apjake.pizzaserrmal.common.util.prefixDollar
import com.apjake.pizzaserrmal.common.util.show
import com.apjake.pizzaserrmal.databinding.ActivityOrderBinding
import com.apjake.pizzaserrmal.mvvm.state.OrderState
import com.apjake.pizzaserrmal.mvvm.viewmodel.OrderViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderActivity : AppCompatActivity() {
    private val viewModel: OrderViewModel by viewModels()
    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val pizzaId = "2"

        viewModel.getPizzaDetail(pizzaId)
        itemObserver()
    }

    private fun itemObserver() {
        viewModel.pizzaItemState.observe(this){
            it?.let {
                when(it){
                    is OrderState.Loaded -> {
                        binding.tvPizzaName.text = it.item.title
                        binding.tvDesc.text = it.item.pizza.description
                        binding.tvVeg.text = it.item.vegType
                        binding.ivPizza.show(it.item.pizza.image)
                        binding.tvPrice.text = it.item.pizza.price.prefixDollar()
                    }
                }
            }
        }
    }
}