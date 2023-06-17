package com.chvanova.blazedport

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.chvanova.blazedport.presentation.domain.GridColorId
import com.chvanova.blazedport.presentation.domain.GridModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `user is win, Should show true`() {
        val value = mutableListOf<MutableList<MutableState<GridModel?>>>()
        for (i in 0 until 6) {
            val childEl = mutableListOf<MutableState<GridModel?>>()
            for (j in 0 until 6){
                if (j == 1) {
                    childEl.add(mutableStateOf(GridModel(colorId = GridColorId.BLUE)))
                    continue
                } else {
                    childEl.add(mutableStateOf(GridModel(colorId = GridColorId.YELLOW)))
                    continue
                }
            }
            value.add(childEl)
        }

        assertEquals(true, checkColumnsEquality(value))
    }

    @Test
    fun `user is lost, Should show false`() {
        val value = mutableListOf<MutableList<MutableState<GridModel?>>>()
    }
}

private fun checkColumnsEquality(data: MutableList<MutableList<MutableState<GridModel?>>>): Boolean {
    for (col in data[0].indices) {
        val colValues = HashSet<GridModel?>()
        for (row in data.indices) {
            if (!colValues.add(data[row][col].value)) {
                return true
            }
        }
    }
    return false
}