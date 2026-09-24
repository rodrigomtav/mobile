package com.example.conversormoedaactivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ConversorMoedaActivity : AppCompatActivity() {

    companion object {
        const val COTACAO_DOLAR = 5.40
        const val COTACAO_EURO = 5.93
    }

    private lateinit var ibReal: ImageButton
    private lateinit var ibDolar: ImageButton
    private lateinit var ibEuro: ImageButton
    private lateinit var btnInverter: Button
    private lateinit var etValor: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpar: Button
    private lateinit var tvResultado: TextView
    private lateinit var ivMoedaOrigem: ImageView
    private lateinit var ivMoedaDestino: ImageView
    private var moedaOrigem = Moeda.REAL
    private var moedaDestino = Moeda.DOLAR
    private var selecionandoOrigem = true

    enum class Moeda {
        REAL,
        DOLAR,
        EURO
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor_moeda)

        setupViews()
        setupListeners()
        atualizarBandeiraOrigem()
        atualizarBandeiraDestino()
    }

    private fun setupViews() {
        ibReal = findViewById(R.id.ibReal)
        ibDolar = findViewById(R.id.ibDolar)
        ibEuro = findViewById(R.id.ibEuro)
        btnInverter = findViewById(R.id.btnInverter)
        etValor = findViewById(R.id.etValor)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpar = findViewById(R.id.btnLimpar)
        tvResultado = findViewById(R.id.tvResultado)
        ivMoedaOrigem = findViewById(R.id.ivMoedaOrigem)
        ivMoedaDestino = findViewById(R.id.ivMoedaDestino)

    }

    private fun setupListeners() {

        ibReal.setOnClickListener {
            selecionarMoeda(Moeda.REAL)
        }

        ibDolar.setOnClickListener {
            selecionarMoeda(Moeda.DOLAR)
        }

        ibEuro.setOnClickListener {
            selecionarMoeda(Moeda.EURO)
        }

        btnCalcular.setOnClickListener {
            converterMoeda()
        }

        btnLimpar.setOnClickListener {
            etValor.text.clear()
            tvResultado.text = ""
        }

        btnInverter.setOnClickListener {
            inverterMoedas()
        }
    }

    private fun converterMoeda() {

        val valor = etValor.text.toString().toDoubleOrNull()

        if (valor == null) {
            Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            return
        }

        val resultado = when (moedaOrigem) {

            Moeda.REAL -> when (moedaDestino) {

                Moeda.DOLAR -> valor / COTACAO_DOLAR
                Moeda.EURO -> valor / COTACAO_EURO
                Moeda.REAL -> valor
            }

            Moeda.DOLAR -> when (moedaDestino) {

                Moeda.REAL -> valor * COTACAO_DOLAR
                Moeda.EURO -> (valor * COTACAO_DOLAR) / COTACAO_EURO
                Moeda.DOLAR -> valor
            }

            Moeda.EURO -> when (moedaDestino) {

                Moeda.REAL -> valor * COTACAO_EURO
                Moeda.DOLAR -> (valor * COTACAO_EURO) / COTACAO_DOLAR
                Moeda.EURO -> valor
            }
        }

        tvResultado.text = String.format("%.2f", resultado)
    }

    private fun inverterMoedas() {
        val temp = moedaOrigem
        moedaOrigem = moedaDestino
        moedaDestino = temp

        atualizarBandeiraOrigem()
        atualizarBandeiraDestino()
    }

    private fun atualizarBandeiraOrigem() {

        when (moedaOrigem) {

            Moeda.REAL ->
                ivMoedaOrigem.setImageResource(R.drawable.bandeira_brasil)

            Moeda.DOLAR ->
                ivMoedaOrigem.setImageResource(R.drawable.bandeira_eua)

            Moeda.EURO ->
                ivMoedaOrigem.setImageResource(R.drawable.bandeira_uniao_europeia)
        }
    }

    private fun atualizarBandeiraDestino() {

        when (moedaDestino) {

            Moeda.REAL ->
                ivMoedaDestino.setImageResource(R.drawable.bandeira_brasil)

            Moeda.DOLAR ->
                ivMoedaDestino.setImageResource(R.drawable.bandeira_eua)

            Moeda.EURO ->
                ivMoedaDestino.setImageResource(R.drawable.bandeira_uniao_europeia)
        }
    }

    private fun selecionarMoeda(moeda: Moeda) {

        if (selecionandoOrigem) {

            moedaOrigem = moeda
            atualizarBandeiraOrigem()

        } else {

            moedaDestino = moeda
            atualizarBandeiraDestino()
        }

        selecionandoOrigem = !selecionandoOrigem
    }


}