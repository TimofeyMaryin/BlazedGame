package com.chvanova.blazedport.presentation

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chvanova.blazedport.presentation.navigation.AppNavController
import com.chvanova.blazedport.presentation.ui.theme.BlazedGameTheme
import com.chvanova.blazedport.presentation.view_models.RemoteConfigViewModel

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    lateinit var remoteConfigViewModel: RemoteConfigViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            remoteConfigViewModel = viewModel()


            MainScreen()
        }
    }

    @Composable
    private fun MainScreen() {
        if (remoteConfigViewModel.link != null){
            MainWebView()
        } else {
            MainContent()
        }
    }

    @Composable
    private fun MainWebView() {
        BlazedGameTheme {
            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(remoteConfigViewModel.link!!)
                }
            }, update = {
                it.loadUrl(remoteConfigViewModel.link!!)
            })
        }
    }

    @Composable
    private fun MainContent() {
        BlazedGameTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                AppNavController(navController = navController)
            }
        }
    }
}


