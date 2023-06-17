package com.chvanova.blazedport.presentation.fr

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.chvanova.blazedport.R
import com.chvanova.blazedport.presentation.ui.utils.AlertWin
import com.chvanova.blazedport.presentation.ui.utils.GridSystemEl
import com.chvanova.blazedport.presentation.ui.utils.RopeElement
import com.chvanova.blazedport.presentation.view_models.GameZoneViewModel

@Composable
fun PVP_Screen(
    navController: NavController,
    gameZoneViewModel: GameZoneViewModel
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.back_game),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        _PVP_Mode(navController = navController, gameZoneViewModel)
    }
}

@Composable
private fun _PVP_Mode(
    navController: NavController,
    gameZoneViewModel: GameZoneViewModel
) {
    val context = LocalContext.current
    var isOpen by remember { mutableStateOf(false) }
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (close_btn_ref, gameZone_ref, containerShow_ref) = createRefs()

        RopeElement(
            modifier = Modifier.constrainAs(containerShow_ref) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            idContainer = gameZoneViewModel.currentColorContainerPVP!!
        )

        Image(
            painter = painterResource(id = R.drawable.btn_back_mini),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .constrainAs(close_btn_ref) {
                    top.linkTo(parent.top, margin = 20.dp)
                    end.linkTo(parent.end, margin = 20.dp)
                }
                .clickable { navController.popBackStack() }
        )
        GridSystemEl(
            elements = gameZoneViewModel.gameContainerPVP,
            modifier = Modifier.constrainAs(gameZone_ref) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 40.dp)
            },
            onClickVertical = { colume ->
                if (!gameZoneViewModel.isFinishGamePVP()) {
                    gameZoneViewModel.addContainerPvp(colume, gameZoneViewModel.currentColorContainerPVP!!)
                    gameZoneViewModel.currentColorContainerPVP = gameZoneViewModel.generateRandomContainer()
                    gameZoneViewModel.generateNeutralBoxPVP()
                } else {
                    if (gameZoneViewModel.userIsWin(true)) {
                        Log.e("_PVP_Mode", "user is win: ", )
                        isOpen = true
                    } else {
                        Log.e("_PVP_Mode", "user is lost: ", )
                        navController.popBackStack()
                        gameZoneViewModel.clearPvp()
                    }

                }
            }
        )
    }

    if (isOpen) {
        AlertWin() {
            navController.popBackStack()
            gameZoneViewModel.clearPvp()
        }
    }
}

