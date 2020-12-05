package com.jptechnology.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        // Set JavaScript execution
        wbvWeb.settings.javaScriptEnabled = true
        val url = "https://www.etsi.org/deliver/etsi_ts/138100_138199/138104/16.04.00_60/ts_138104v160400p.pdf"
        // Load website link
//        wbvWeb.loadUrl("https://www.etsi.org/deliver/etsi_ts/138100_138199/138104/16.04.00_60/ts_138104v160400p.pdf")
        wbvWeb.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
        // Define WebView as standard web client
        wbvWeb.webViewClient = WebViewClient()
    }
}