package com.example.imc_calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var titleDensidadeCorporal: TextView
    private lateinit var textViewHeaderDensidadeCorporal: TextView
    private lateinit var textViewResultadoDensidadeCorporal: TextView
    private lateinit var textViewPeso: TextView
    private lateinit var textViewAltura: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        // Inicializando os componentes da interface
        titleDensidadeCorporal = findViewById(R.id.titleDensidadeCorporal)
        textViewHeaderDensidadeCorporal = findViewById(R.id.textViewHeaderDensidadeCorporal)
        textViewResultadoDensidadeCorporal = findViewById(R.id.textViewResultadoDensidadeCorporal)
        textViewPeso = findViewById(R.id.textViewPeso)
        textViewAltura = findViewById(R.id.textViewAltura)
        btnVoltar = findViewById(R.id.btnFecharResultados)

        // Obtendo os dados do IMC passados pela Intent
        val imc = intent.getParcelableExtra<IMC>("value")

        // Atualizando os textos da tela
        imc?.let {
            titleDensidadeCorporal.text = it.nome.toString()
            textViewHeaderDensidadeCorporal.text = it.calcular()
            textViewResultadoDensidadeCorporal.text = "Seu IMC: %.2f".format(it.imc)
            textViewPeso.text = "Seu Peso: %.1f".format(it.peso)
            textViewAltura.text = "Sua Altura: %.1f".format(it.altura)
        }

        // Ação do botão Voltar
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("value", imc)
            startActivity(intent)
            finish()
        }
    }
}
