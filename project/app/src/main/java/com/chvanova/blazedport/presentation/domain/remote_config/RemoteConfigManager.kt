package com.chvanova.blazedport.presentation.domain.remote_config

import android.app.Activity
import android.util.Log
import com.chvanova.blazedport.presentation.view_models.RemoteConfigViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

object RemoteConfigManager {
    private const val REMOTE_CONFIG_ID = "is_can_open"

    private val remoteConfig : FirebaseRemoteConfig by lazy {
        Firebase.remoteConfig
    }

    fun launch(activity: Activity, viewModel: RemoteConfigViewModel){
        Log.e("REMOTE CONFIG", "Launch is started", )

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate().addOnCompleteListener(activity) { task ->
            if (task.isSuccessful){
                Log.e("REMOTE CONFIG", remoteConfig.getString(REMOTE_CONFIG_ID), )
                viewModel.link = remoteConfig.getString(REMOTE_CONFIG_ID)

            } else {
                Log.e("REMOTE CONFIG", "Failed to update Remote Config parameters", )
            }

        }

    }

}