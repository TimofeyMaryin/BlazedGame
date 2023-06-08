package com.chvanova.blazedport.presentation.view_models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RemoteConfigViewModel: ViewModel() {

    var link by mutableStateOf<String?>(null)

}