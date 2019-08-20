package com.hasankucuk.darkthemesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun View.setSelectedIfDarkTheme() {
            isSelected = DarkTheme.isEnabled(context)
        }

        dayNightToggleButton.setSelectedIfDarkTheme()
        dayNightToggleButton.setOnClickListener {
            DarkTheme.apply(enabled = it.isSelected.not())
            it.setSelectedIfDarkTheme()
        }

        btnWebView.setOnClickListener { startActivity(Intent(this, WebViewActivity::class.java)) }

        btnForceDark.setOnClickListener { startActivity(Intent(this, ForceDarkActivity::class.java)) }

        btnElevation.setOnClickListener { startActivity(Intent(this, ElevationActivity::class.java)) }
    }
}
