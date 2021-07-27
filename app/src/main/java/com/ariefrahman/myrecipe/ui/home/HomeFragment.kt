package com.ariefrahman.myrecipe.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariefrahman.core.data.source.Resource
import com.ariefrahman.core.domain.model.Category
import com.ariefrahman.myrecipe.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var binding: FragmentHomeBinding? = null
    private val adapter: RecipeAdapter = RecipeAdapter()
    private val categoryAdapter: CategoryAdapter = CategoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.getNewRecipe().observe(viewLifecycleOwner, {
            if(it != null){
                when(it){
                    is Resource.Loading -> {binding?.progressBar?.visibility = View.VISIBLE}
                    is Resource.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        adapter.setList(it.data)

                        binding?.recyclerView.let {  rv ->
                            rv?.layoutManager = LinearLayoutManager(context)
                            rv?.adapter = adapter
                        }

                    }
                    else -> return@observe
                }
            }
        })

        GlobalScope.launch(Dispatchers.Main) {
            homeViewModel.getCategory().observe(viewLifecycleOwner, {
                if(it != null){
                    when(it){
                        is Resource.Success -> {
                            categoryAdapter.setList(it.data)
                            binding?.rvChip.let {
                                it?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                                it?.adapter = categoryAdapter
                            }
                        }
                    }

                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}