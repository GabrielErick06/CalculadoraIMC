package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val altura: Float = 1.72f * 1.72f
        val peso: Int = 72

        val imc: Float = peso / altura

        println(imc)


        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso: EditText = findViewById<EditText>(R.id.edtPeso)
        val edtAltura: EditText = findViewById<EditText>(R.id.edtAltura)
        val editNome: EditText = findViewById(R.id.edtName)
        //val tvResultado: TextView = findViewById(R.id.txtMessage)

        btnCalcular.setOnClickListener {
            //val message : String = edtPeso.text.toString()
            //tvResultado.text = message

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()
            val nomeStr = editNome.text.toString()

            if (alturaStr.isNotEmpty() && alturaStr.isNotEmpty() && nomeStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val alturaFinal: Float = altura * altura
                val peso: Float = pesoStr.toFloat()
                val Name: String = editNome.text.toString()

                val imc: Float = peso / alturaFinal

                //tvResultado.text = imc.toString()

                println(imc)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", imc)
                        putExtra("EXTRA_NAME", Name)
                    }

                startActivity(intent)
            }
            else{
                Toast.makeText(this, "preencher todos os campos", Toast.LENGTH_LONG).show()
            }

        }
    }
}





