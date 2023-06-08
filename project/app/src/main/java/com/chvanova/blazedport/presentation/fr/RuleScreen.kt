package com.chvanova.blazedport.presentation.fr

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.chvanova.blazedport.R
import androidx.compose.ui.unit.dp

@Composable
fun RuleScreen(
    navController: NavController,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.back_game),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.field_rules),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(.85f),
                contentScale = ContentScale.FillWidth
            )
            
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.btn_back),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(.85f).clickable { navController.popBackStack() },
                contentScale = ContentScale.FillWidth
            )
        }
    }
}