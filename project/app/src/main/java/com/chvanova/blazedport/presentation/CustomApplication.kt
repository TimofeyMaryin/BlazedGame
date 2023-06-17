package com.chvanova.blazedport.presentation

import android.app.Application
import io.branch.referral.Branch

class CustomApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Branch.getAutoInstance(this);
    }
}