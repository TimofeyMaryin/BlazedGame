package com.chvanova.blazedport.presentation.ui.utils

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chvanova.blazedport.R

@Composable
fun AlertWin(
    onCloseWin: () -> Unit
) {
    Log.e("AlertWin", "alert is called", )
    AlertDialog(
        onDismissRequest = { onCloseWin() },
        buttons = { AlertContent() },
    )

}

@Composable
private fun AlertContent() {
    Box(
        modifier = Modifier.background(Color.Blue.copy(alpha = 0.01f)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.field_win),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = "WIN",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
    }
}