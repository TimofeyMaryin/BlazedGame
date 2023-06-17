package com.chvanova.blazedport.presentation.domain.branch

import android.content.Context
import android.util.Log
import io.branch.referral.Branch
import io.branch.referral.Branch.BranchReferralInitListener
import io.branch.referral.BranchError
import io.branch.referral.BranchReferralUrlBuilder
import org.json.JSONObject

class BranchManager(context: Context) {

    private val keyLive = "key_live_jqfoKdzVjg8Ig4yyMwsxRpflFsd30F8K"
    private val keyTest = "key_test_ntfcIbCTcjZLi5CCTtttUbepsEf1YtWW"
    private val branch = Branch.getInstance(context)

    fun init() {
        branch.initSession { referringParams, error -> Log.e("onInitFinished", "On finished",) }
    }

}