package com.chvanova.blazedport.presentation.domain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class GridModel(
    val colorId: GridColorId? = null,
)


enum class GridColorId {
    RED, YELLOW, BLUE
}
