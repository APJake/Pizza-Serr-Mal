package com.apjake.pizzaserrmal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.apjake.pizzaserrmal.adapter.PizzaListAdapter
import com.apjake.pizzaserrmal.databinding.FragmentVegPizzaBinding
import com.apjake.pizzaserrmal.mvvm.event.PizzaListEvent
import com.apjake.pizzaserrmal.mvvm.state.PizzaState
import com.apjake.pizzaserrmal.mvvm.viewmodel.PizzaViewModel
import com.compose.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VegPizzaFragment : BaseFragment<PizzaViewModel, PizzaListEvent>() {

    private val viewModel: PizzaViewModel by viewModels()
    private lateinit var adapter: PizzaListAdapter
    private lateinit var binding: FragmentVegPizzaBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = PizzaListAdapter(requireContext())
        binding.rvVegPizza.adapter = adapter

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVegPizzaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun injectViewModel(): PizzaViewModel = viewModel

    override fun bind(event: PizzaListEvent) {
        when (event) {

        }
    }
}