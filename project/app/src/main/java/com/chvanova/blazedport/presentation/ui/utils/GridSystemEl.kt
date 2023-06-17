package com.chvanova.blazedport.presentation.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chvanova.blazedport.R
import com.chvanova.blazedport.presentation.domain.GridModel
import com.chvanova.blazedport.presentation.domain.selectContainerId

@Composable
fun GridSystemEl(
    elements: MutableList<MutableList<MutableState<GridModel?>>>,
    modifier: Modifier,
    onClickVertical: (colum: Int) -> Unit
) {
    val currentWidthScreen = LocalConfiguration.current.screenWidthDp
    Box(
        modifier = Modifier.size((currentWidthScreen * 0.9f).dp).then(modifier),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.grid),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Grid(elements = elements, onClickVertical = onClickVertical)

    }
}


@Composable
private fun Grid(
    elements: MutableList<MutableList<MutableState<GridModel?>>>,
    onClickVertical: (colum: Int) -> Unit
) {
    val gridCount = 6
    val widthScreen = LocalConfiguration.current.screenWidthDp
    val currentSizeGrid = (widthScreen * 0.9f).dp
    val boxSize = (currentSizeGrid.value / 6).dp


    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        repeat(gridCount) { row ->
            Row{
                repeat(gridCount) { column ->
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(boxSize).clickable { onClickVertical(column) }) {
                        if (elements[row][column].value != null) {
                            Image(
                                painter = painterResource(id = selectContainerId(elements[row][column].value?.colorId!!)),
                                contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }
                }
            }
        }
    }
}