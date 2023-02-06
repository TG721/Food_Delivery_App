package com.tengizmkcorp.food_delivery.ui.element

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView
import com.tengizmkcorp.food_delivery.databinding.FragmentContactsBinding
import com.tengizmkcorp.food_delivery.databinding.FragmentDiscoverBinding
import com.tengizmkcorp.food_delivery.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsFragment : BaseFragment<FragmentContactsBinding>(FragmentContactsBinding::inflate) {
    override fun setup() {

    }
    override fun listeners() {
        setupSwitchBtn()
    }
    private fun setupSwitchBtn() {
        var isSwitchOn = false
        val lottieContactsSyncBtn: LottieAnimationView = binding.syncContactsSwitch
        lottieContactsSyncBtn.speed = 3f;
        lottieContactsSyncBtn.setOnClickListener {
            isSwitchOn = if(isSwitchOn){
                lottieContactsSyncBtn.setMinAndMaxProgress(0.5f,1.0f)
                lottieContactsSyncBtn.playAnimation()
                false
            } else {
                lottieContactsSyncBtn.setMinAndMaxProgress(0.0F,0.5f)
                lottieContactsSyncBtn.playAnimation()
                true
            }
        }
    }
}