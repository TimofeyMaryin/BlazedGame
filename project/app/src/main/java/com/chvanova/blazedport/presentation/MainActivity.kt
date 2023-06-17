package com.chvanova.blazedport.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chvanova.blazedport.presentation.domain.appsflyer.AppsflyerManager
import com.chvanova.blazedport.presentation.domain.onesignal.OneSignalManager
import com.chvanova.blazedport.presentation.domain.remote_config.RemoteConfigManager
import com.chvanova.blazedport.presentation.navigation.AppNavController
import com.chvanova.blazedport.presentation.ui.theme.BlazedGameTheme
import com.chvanova.blazedport.presentation.view_models.RemoteConfigViewModel
import io.branch.referral.Branch
import io.branch.referral.Branch.BranchReferralInitListener


class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    lateinit var remoteConfigViewModel: RemoteConfigViewModel
    lateinit var branch: Branch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        branch = Branch.getInstance()
        branch.initSession(BranchReferralInitListener { referringParams, error ->
            if (error == null) {
                Log.e("onCreate", "Branch is OK", )
            } else {
                Log.e("onCreate", "Branch has an error", )
            }
        }, this.intent.data, this)

        setContent {
            navController = rememberNavController()
            remoteConfigViewModel = viewModel()
            MainScreen()

            // BranchManager(this).init()
            RemoteConfigManager.launch(this, remoteConfigViewModel)
            AppsflyerManager.init(this)
            OneSignalManager.init(this)
        }


    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        this.intent = intent
    }

    @Composable
    private fun MainScreen() {

        if (remoteConfigViewModel.link?.isNotEmpty() == true){
            Log.e("WEB_VIEW", remoteConfigViewModel.link ?: "Empty")
            Log.e("WEB_VIEW", remoteConfigViewModel.link.toString())
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


