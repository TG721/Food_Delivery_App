package com.tengizmkcorp.food_delivery.ui.element

import androidx.recyclerview.widget.LinearLayoutManager
import com.tengizmkcorp.food_delivery.databinding.FragmentSettingsBinding
import com.tengizmkcorp.food_delivery.ui.adapter.SettingsItemAdapter
import com.tengizmkcorp.food_delivery.ui.common.BaseFragment
import com.tengizmkcorp.food_delivery.ui.model.settingsList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {
    private lateinit var settingsItemAdapter : SettingsItemAdapter
    override fun setup() {
        setupRecycler()
    }

    private fun setupRecycler() {
        settingsItemAdapter = SettingsItemAdapter()
        val settingsRecycler = binding.recyclerView
        settingsRecycler.adapter = settingsItemAdapter
        settingsRecycler.layoutManager =
            LinearLayoutManager(requireContext())
        settingsItemAdapter.submitList(settingsList)
    }


}
