package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textViewResult)
        val textViewClassificacao = findViewById<TextView>(R.id.textViewClassificacao)
        val nomeResult = findViewById<TextView>(R.id.NomeResult)
        val imc = intent.getFloatExtra("EXTRA_RESULT", 0.1F)
        val editNome = intent.getStringExtra("EXTRA_NAME")


        nomeResult.text = editNome.toString()
        tvResult.text = imc.toString()


        val classificacao =  if (imc < 18.5f){
             "Abaixo do peso normal"
        }
        else if (imc >= 18.5f && imc < 24.9f){
             "Peso normal"
        }
        else if (imc >= 24.9f && imc <29.9f ){
            "Sobrepeso"
        }
        else if (imc >= 29.9f && imc <34.9f){
            "Obesidade classe 1"
        }
        else if (imc >= 34.9f && imc <39.9f){
            "Obesidade classe 2"
        }
        else {
             "Obesidade classe 3"
        }

        textViewClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}