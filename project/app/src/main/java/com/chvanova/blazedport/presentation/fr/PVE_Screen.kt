package com.chvanova.blazedport.presentation.fr

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.chvanova.blazedport.R
import androidx.compose.ui.unit.dp

@Composable
fun PVE_Screen(
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.back_game),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        _PVE_Mode(navController = navController)
    }

}

@Composable
private fun _PVE_Mode(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (close_btn_ref, gameZone_ref, containerShow_ref) = createRefs()
        
        Image(
            painter = painterResource(id = R.drawable.btn_back_mini),
            contentDescription = null,
            modifier = Modifier.size(60.dp).constrainAs(close_btn_ref) {
                top.linkTo(parent.top, margin = 20.dp)
                end.linkTo(parent.end, margin = 20.dp)
            }.clickable { navController.popBackStack() }
        )

        Image(
            painter = painterResource(id = R.drawable.grid),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(.9f)
                .constrainAs(gameZone_ref) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
    }
}
