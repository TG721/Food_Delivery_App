package com.tengizmkcorp.food_delivery.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tengizmkcorp.food_delivery.data.remote.model.Discover
import com.tengizmkcorp.food_delivery.domain.usercase.GetDiscoverListUseCase
import com.tengizmkcorp.food_delivery.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(private val getDiscoverListUseCase: GetDiscoverListUseCase) :
    ViewModel() {
    private val _myState =
        MutableStateFlow<ResponseState<Discover>>(ResponseState.Empty()) //mutable state flow
    val myState: StateFlow<ResponseState<Discover>> = _myState //immutable state flow

    fun getDiscoverInfo() {
        viewModelScope.launch {
            _myState.emit(ResponseState.Loading())
            val data = getDiscoverListUseCase.getDiscoverList()
            data.collect {
                _myState.value = it
            }
        }

    }

}