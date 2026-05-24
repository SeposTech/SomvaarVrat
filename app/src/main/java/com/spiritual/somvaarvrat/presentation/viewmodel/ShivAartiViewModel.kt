package com.spiritual.somvaarvrat.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spiritual.somvaarvrat.data.repository.model.ShivAartiModel
import com.spiritual.somvaarvrat.domain.repository.usecase.ShivAartiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShivAartiViewModel @Inject constructor(
    val shivAartiUseCase: ShivAartiUseCase
) : ViewModel() {

    var _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    sealed interface UiState {
        object Loading : UiState
        data class Success(val menuList: List<ShivAartiModel>) : UiState
        data class Error(val message: String) : UiState
    }

    init {
        getShivAartiList()
    }


    fun getShivAartiList() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val result = shivAartiUseCase.invoke()
                if (result.isNotEmpty()) {
                    _uiState.value = UiState.Success(result)
                } else {
                    _uiState.value = UiState.Error("No data found")
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "An error occurred")
            }
        }
    }

}