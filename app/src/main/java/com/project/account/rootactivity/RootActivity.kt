package com.project.account.rootactivity

import com.project.account.R
import com.project.account.databinding.RootActivityBinding
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding

class RootActivity : AppCompatActivity(R.layout.root_activity) {

    private val viewBinding: RootActivityBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(viewBinding.root)
    }

    private fun setScreenOrientation(orientation: Int) {
        requestedOrientation = orientation
    }
}