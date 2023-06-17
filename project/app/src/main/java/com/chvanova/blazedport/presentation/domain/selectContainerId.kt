package com.chvanova.blazedport.presentation.domain

import com.chvanova.blazedport.R

fun selectContainerId(id: GridColorId) : Int = when(id) {
    GridColorId.RED -> R.drawable.box_red
    GridColorId.YELLOW -> R.drawable.box_yellow
    else -> R.drawable.box_blue
}