package com.chvanova.blazedport.presentation.domain.onesignal

import android.content.Context
import com.onesignal.OneSignal
import com.onesignal.OneSignalDb

object OneSignalManager {
    private const val ONESIGNAL_APP_ID= "1623fed4-5b91-4130-a812-f7a5255f4051"

    fun init(context: Context) {
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(context)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        OneSignal.promptForPushNotifications()
    }

}