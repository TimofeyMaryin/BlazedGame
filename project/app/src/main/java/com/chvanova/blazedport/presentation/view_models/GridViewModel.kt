package com.chvanova.blazedport.presentation.view_models

import androidx.lifecycle.ViewModel
import com.chvanova.blazedport.presentation.domain.GridModel

class GridViewModel : ViewModel() {
    private val gridSize = 6
    private val gameZone = mutableListOf<MutableList<GridModel?>>()
    private fun createGameZone() {
        for (i in 0 until gridSize) {
            val row = mutableListOf<GridModel?>()
            for (j in 0 until gridSize) {
                row.add(null)
            }
            gameZone.add(row)
        }
    }


    init {
        createGameZone()
    }
}