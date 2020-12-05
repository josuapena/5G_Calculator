package com.jptechnology.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_frequencia.*
import kotlinx.android.synthetic.main.activity_nr_arfcn.*

class FrequenciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frequencia)

        btnFrequenciaVoltar.setOnClickListener {
            val mIntent = Intent(this, RecepcaoActivity::class.java)
            startActivity(mIntent)
            finish()
        }

        data class ParametrosNR(var deltaFG: Int, var freqRefOffs: Double, var NrefOffs: Int)

        fun parametrosFormulaNR(rangeNF: Int): ParametrosNR {
            val rangeInicio = 0
            val rangeMeioZero = 3000
            val rangeMeioMax = 24250
            val rangeMax = 100000
            var deltaFG = 0
            var freqRefOffs = 0.0
            var NrefOffs = 0

            if(rangeNF in (rangeInicio + 1) until rangeMeioZero - 1){
                deltaFG = 5
                freqRefOffs = 0.0
                NrefOffs = 0
            }else if(rangeNF in (rangeMeioZero) until rangeMeioMax){
                deltaFG = 15
                freqRefOffs = 3000.0
                NrefOffs = 600000
            }else if(rangeNF < rangeMax){
                deltaFG = 60
                freqRefOffs = 24250.08
                NrefOffs = 2016667
            }else{
                Toast.makeText(this, "Introduza uma banda entre 0 e 3279165", Toast.LENGTH_LONG).show()
            }
            return ParametrosNR(deltaFG, freqRefOffs, NrefOffs)
        }

        // Listening to calcule button
        btnFrequenciaCalc.setOnClickListener {
            // Getting data from form
            val freqRef = edtFrequencia.text.toString().trim().toInt()
            val limiteInferior = 0
            val limiteSuperior = 100000
            var Nref = 0.0

            // Field validation
            if(freqRef < limiteInferior || freqRef > limiteSuperior){
                Toast.makeText(this, "Introduza uma frequência entre 0 e 100000 MHz", Toast.LENGTH_LONG).show()
            }else{
                val (deltaFG, freqRefOffs, NrefOffs) = parametrosFormulaNR(freqRef)
                Nref = NrefOffs + (freqRef - freqRefOffs) / deltaFG
                txtNrArfnc.text = String.format("%.2f", Nref)
            }
        }

        btnFrequenciaInfo.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}