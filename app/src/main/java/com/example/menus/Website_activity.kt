package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Website_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var MyWEB:WebView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        MyWEB = findViewById(R.id.MWEB)
        val webSettings = MyWEB.settings
        webSettings.javaScriptEnabled = true
        MyWEB.loadUrl("https://google.com")
    }
}