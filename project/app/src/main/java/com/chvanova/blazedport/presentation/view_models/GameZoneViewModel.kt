package com.chvanova.blazedport.presentation.view_models

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.chvanova.blazedport.presentation.domain.GridColorId
import com.chvanova.blazedport.presentation.domain.GridModel
import kotlin.random.Random

class GameZoneViewModel : ViewModel() {

    var gameContainerPVE = mutableListOf<MutableList<MutableState<GridModel?>>>()
    var gameContainerPVP = mutableListOf<MutableList<MutableState<GridModel?>>>()

    var currentColorContainer by mutableStateOf<GridColorId?>(null)
    var currentColorContainerPVP by mutableStateOf<GridColorId?>(null)

    var randomColorContainer by mutableStateOf<GridColorId?>(null)
    var countSteps by mutableStateOf(0)

    fun addContainer(index: Int, colorId: GridColorId) {
        mainLoop@for (i in gameContainerPVE.lastIndex downTo 0) {
            for (j in gameContainerPVE[i].indices) {
                if (j == index && gameContainerPVE[i][j].value == null) {
                    Log.e("addContainer", "condition is worked", )
                    gameContainerPVE[i][j].value = GridModel(colorId)
                    countSteps++
                    break@mainLoop
                }
            }
        }
    }

    fun addContainerPvp(index: Int, colorId: GridColorId) {
        mainLoop@for (i in gameContainerPVP.lastIndex downTo 0) {
            for (j in gameContainerPVP[i].indices) {
                if (j == index && gameContainerPVP[i][j].value == null) {
                    Log.e("addContainer", "condition is worked", )
                    gameContainerPVP[i][j].value = GridModel(colorId)
                    countSteps++
                    break@mainLoop
                }
            }
        }
    }

    fun generateNeutralBox() {
        if(countSteps == 0 || countSteps % 3 != 0) { return }
        val randomColum = Random.nextInt(0, 7)

        mainLoop@for (i in gameContainerPVE.lastIndex downTo 0) {
            for (j in gameContainerPVE[i].indices) {
                if (j == randomColum && gameContainerPVE[i][j].value == null) {
                    Log.e("addContainer", "condition is worked", )
                    randomColorContainer = generateRandomContainer()
                    gameContainerPVE[i][j].value = GridModel(randomColorContainer)
                    break@mainLoop
                }
            }
        }
    }

    fun generateNeutralBoxPVP() {
        if(countSteps == 0 || countSteps % 3 != 0) { return }
        val randomColum = Random.nextInt(0, 7)

        mainLoop@for (i in gameContainerPVP.lastIndex downTo 0) {
            for (j in gameContainerPVP[i].indices) {
                if (j == randomColum && gameContainerPVP[i][j].value == null) {
                    Log.e("addContainer", "condition is worked", )
                    randomColorContainer = generateRandomContainer()
                    gameContainerPVP[i][j].value = GridModel(randomColorContainer)
                    break@mainLoop
                }
            }
        }
    }

    fun clearPve() {
        gameContainerPVE = mutableListOf<MutableList<MutableState<GridModel?>>>()
        gameContainerPVE = createGameZone()
        countSteps = 0
        Log.e("clear", gameContainerPVE.size.toString(), )
    }

    fun clearPvp() {
        gameContainerPVP = mutableListOf<MutableList<MutableState<GridModel?>>>()
        gameContainerPVP = createGameZone()
        countSteps = 0
        Log.e("clear", gameContainerPVP.size.toString(), )
    }

    private fun createGameZone() :  MutableList<MutableList<MutableState<GridModel?>>> {
        val res = mutableListOf<MutableList<MutableState<GridModel?>>>()
        for (i in 0 until 6) {
            val row = mutableListOf<MutableState<GridModel?>>()
            for (j in 0 until 6) {
                row.add(mutableStateOf(null))
            }
            res.add(row)
        }

        return res
    }

    fun generateRandomContainer() : GridColorId{
        return when {
            countSteps % 3 == 0 -> GridColorId.RED
            countSteps % 3 == 1 -> GridColorId.YELLOW
            else -> GridColorId.BLUE
        }
    }



    fun isFinishGamePVE(): Boolean {
        for (i in gameContainerPVE[0]) {
            if (i.value != null) {
                return true
            }
        }

        return false
    }

    fun isFinishGamePVP(): Boolean {
        for (i in gameContainerPVP[0]) {
            if (i.value != null) {
                return true
            }
        }

        return false
    }

    fun userIsWin(isPvp: Boolean): Boolean {
        return if (isPvp) checkColumnsEquality(gameContainerPVP) else checkColumnsEquality(gameContainerPVE)
    }


    private fun checkColumnsEquality(data: MutableList<MutableList<MutableState<GridModel?>>>): Boolean {
        for (col in data[0].indices) {
            val colValues = HashSet<GridColorId?>()
            for (row in data.indices) {

                if (colValues.add(data[row][col].value?.colorId)) {
                    Log.e("checkColumnsEquality", "value: ${colValues.joinToString("; ")}", )
                    if (colValues.any { it == null }) {
                        return true
                    }
                    return false
                }
            }
        }
        return false
    }







    init {
        // fillGameContainer()
        gameContainerPVP = createGameZone()
        gameContainerPVE = createGameZone()

        currentColorContainer = generateRandomContainer()
        currentColorContainerPVP = generateRandomContainer()
        randomColorContainer = generateRandomContainer()
    }


}