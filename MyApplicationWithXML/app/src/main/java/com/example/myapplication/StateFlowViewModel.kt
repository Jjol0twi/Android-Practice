package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StateFlowViewModel : ViewModel() {
    private val _testUIState : MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val testUIState :StateFlow<UiState> = _testUIState.asStateFlow()

    fun StateFlow<UiState>.updateState(uiState: UiState){
        _testUIState.value = uiState
    }

}

data class UiState(
    val loading : Boolean = true,
    val counting : Boolean = false,
    val error : Boolean = false,
)

sealed class Uistate2{
    data object Counting : Uistate2()
    data object Loading : Uistate2()
    data object Error : Uistate2()
}