package com.chvanova.blazedport.presentation.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.chvanova.blazedport.R
import com.chvanova.blazedport.presentation.domain.GridColorId
import com.chvanova.blazedport.presentation.domain.selectContainerId

@Composable
fun RopeElement(
    modifier: Modifier,
    idContainer: GridColorId,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.rope),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = selectContainerId(idContainer)),
            contentDescription = null,
        )

    }
}


@Preview(widthDp = 520, heightDp = 1420)
@Composable
fun RopeElementPreview() {
    RopeElement(modifier = Modifier, idContainer = GridColorId.RED)
}