package com.jptechnology.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_nr_arfcn.*
import kotlinx.android.synthetic.main.activity_recepcao.*

class RecepcaoActivity : AppCompatActivity() {

    lateinit var myPreference: MyPreference

    override fun attachBaseContext(newBase: Context?) {
        myPreference = MyPreference(newBase!!)
        val lang = myPreference.getLoginCount()
        super.attachBaseContext(lang?.let { MyContextWrapper.wrap(newBase, it) })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recepcao)
       // Listening sign up button
        btnRecepcaoNrArfcn.setOnClickListener {
            val mIntent = Intent(this, NrArfcnActivity::class.java)
            startActivity(mIntent)
            finish()
        }
        btnRecepcaoFrequencia.setOnClickListener {
            val mIntent = Intent(this, FrequenciaActivity::class.java)
            startActivity(mIntent)
            finish()
        }
        btnRecepcaoInfo.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
        btnRecepcaoLanguage.setOnClickListener{
            val mIntent = Intent(this, LanguageActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}