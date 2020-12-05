package com.jptechnology.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_language.*

class LanguageActivity : AppCompatActivity() {
    lateinit var myPreference: MyPreference
    lateinit var context: Context
    val languageList = arrayOf("pt", "es", "en", "fr", "it")
    val languageListComplete = arrayOf("Português", "Español", "English", "Français", "Italiano")

    override fun attachBaseContext(newBase: Context?) {
        myPreference = MyPreference(newBase!!)
        val lang: String = myPreference.getLoginCount().toString()
        super.attachBaseContext(MyContextWrapper.wrap(newBase, lang))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        context = this
        myPreference = MyPreference(this)
        spnLanguage.adapter =  ArrayAdapter(this, android.R.layout.simple_list_item_1, languageListComplete)

        val lang = myPreference.getLoginCount()
        val index = languageList.indexOf(lang)

        if (index >= 0){
            spnLanguage.setSelection(index)
        }

        btnChooseLanguage.setOnClickListener {
            myPreference.setLoginCount(languageList[spnLanguage.selectedItemPosition])
            val mIntent = Intent(this, RecepcaoActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}