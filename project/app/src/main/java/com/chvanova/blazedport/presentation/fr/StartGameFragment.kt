package com.chvanova.blazedport.presentation.fr

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.chvanova.blazedport.R
import androidx.compose.ui.unit.dp
import com.chvanova.blazedport.presentation.navigation.Screen
import com.chvanova.blazedport.presentation.ui.utils.DefaultSize

@Composable
fun StartGameScreen(navController: NavController) {
    MenuContent(img = R.drawable.back_start) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (logo_ref, btn_ref) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(DefaultSize.sizeIcon)
                    .constrainAs(logo_ref) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )


            Column(
                modifier = Modifier.fillMaxWidth().constrainAs(btn_ref) {
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btn_play),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(.8f).clickable { navController.navigate(Screen.ChooseGameModel.route) },
                    contentScale = ContentScale.FillWidth
                )

                Spacer(modifier = Modifier.height(DefaultSize.defaultMargin))

                Image(
                    painter = painterResource(id = R.drawable.btn_privacy),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(.3f).clickable { navController.navigate(Screen.RuleScreen.route) },
                    contentScale = ContentScale.FillWidth
                )

            }
        }
    }
}