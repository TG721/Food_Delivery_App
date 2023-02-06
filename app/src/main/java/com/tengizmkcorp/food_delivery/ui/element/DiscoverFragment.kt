package com.tengizmkcorp.food_delivery.ui.element

import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.tengizmkcorp.food_delivery.R
import com.tengizmkcorp.food_delivery.data.remote.model.DiscoverSubList
import com.tengizmkcorp.food_delivery.databinding.FragmentDiscoverBinding
import com.tengizmkcorp.food_delivery.ui.adapter.DiscoverItemAdapter
import com.tengizmkcorp.food_delivery.ui.common.BaseFragment
import com.tengizmkcorp.food_delivery.ui.viewmodel.DiscoverViewModel
import com.tengizmkcorp.food_delivery.utils.ResponseState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiscoverFragment : BaseFragment<FragmentDiscoverBinding>(FragmentDiscoverBinding::inflate) {
    private val viewModel: DiscoverViewModel by viewModels()
    private lateinit var discoverItemAdapter1: DiscoverItemAdapter
    private lateinit var discoverItemAdapter2: DiscoverItemAdapter
    private lateinit var discoverItemAdapter3: DiscoverItemAdapter
    override fun setup() {
        setupRecyclers()
        setupProgressBar()
    }

    override fun observers() {
        viewModel.getDiscoverInfo()
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.myState.collect {
                    when (it) {
                        is ResponseState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is ResponseState.Error -> {
                            binding.messageText.text = it.message
                            binding.messageText.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                        }
                        is ResponseState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            val discoverList = mutableListOf<DiscoverSubList>()
                            for (i in 0 until it.items.size) {
                                discoverList.add(it.items[i])
                                when (i) {
                                    0 -> {
                                        discoverItemAdapter1.submitList(discoverList[i])
                                    }
                                    1 -> {
                                        discoverItemAdapter2.submitList(discoverList[i])
                                    }
                                    2 -> {
                                        discoverItemAdapter3.submitList(discoverList[i])
                                    }
                                }

                            }
                            binding.progressBar.visibility = View.GONE
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    private fun setupProgressBar() {
        val progressBar = binding.progressBar
        val drawable = DrawableCompat.wrap(progressBar.progressDrawable)
        DrawableCompat.setTint(drawable, ContextCompat.getColor(requireContext(), R.color.red_500))
        progressBar.progressDrawable = drawable
    }

    private fun setupRecyclers() {
        val linearLayoutManager1 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val linearLayoutManager2 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val linearLayoutManager3 =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.fastFoodRV.layoutManager = linearLayoutManager1
        binding.dealsRV.layoutManager = linearLayoutManager2
        binding.healthyRV.layoutManager = linearLayoutManager3
        discoverItemAdapter1 = DiscoverItemAdapter()
        discoverItemAdapter2 = DiscoverItemAdapter()
        discoverItemAdapter3 = DiscoverItemAdapter()
        binding.fastFoodRV.adapter = discoverItemAdapter1
        binding.dealsRV.adapter = discoverItemAdapter2
        binding.healthyRV.adapter = discoverItemAdapter3
    }

}