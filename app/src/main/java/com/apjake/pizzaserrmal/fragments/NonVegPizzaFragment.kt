package com.apjake.pizzaserrmal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.apjake.pizzaserrmal.adapter.PizzaListAdapter
import com.apjake.pizzaserrmal.common.base.BaseFragment
import com.apjake.pizzaserrmal.databinding.FragmentNonVegPizzaBinding
import com.apjake.pizzaserrmal.databinding.FragmentVegPizzaBinding
import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import com.apjake.pizzaserrmal.mvvm.viewmodel.VegPizzaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonVegPizzaFragment : BaseFragment<VegPizzaViewModel, PizzaListEvent>() {

    private val viewModelVeg: VegPizzaViewModel by viewModels()
    private lateinit var adapter: PizzaListAdapter
    private lateinit var binding: FragmentNonVegPizzaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PizzaListAdapter(requireContext())
        binding.rvNonVegPizza.adapter = adapter
        viewModelVeg.getPizzaList()
        viewModelVeg.pizzaLisState.observe(viewLifecycleOwner) {
            when (it) {
                is PizzaState.Success -> adapter.setNewDataList(it.item)
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNonVegPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun injectViewModel(): VegPizzaViewModel = viewModelVeg

    override fun bind(event: PizzaListEvent) {
        when (event) {

        }
    }
}