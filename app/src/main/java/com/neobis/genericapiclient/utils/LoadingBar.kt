package com.neobis.genericapiclient.utils

import android.app.Activity
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.FadingCircle
import com.neobis.genericapiclient.R

class LoadingBar(val mActivity: Activity) {
    private lateinit var isDialog: AlertDialog

    fun startLoading() {

        val inflater = mActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.progressbar, null)
        val builder = AlertDialog.Builder(mActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isDialog = builder.create()
        isDialog.show()

    }
    fun isDismiss() {
        isDialog.dismiss()
    }
}

