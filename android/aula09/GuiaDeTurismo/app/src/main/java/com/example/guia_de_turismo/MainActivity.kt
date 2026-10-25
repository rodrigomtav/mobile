package com.example.guia_de_turismo

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nomes = resources.getStringArray(R.array.nomes)
        val descricoes = resources.getStringArray(R.array.descricoes)
        val pacotes = resources.getStringArray(R.array.pacotes)
        val hoteis = resources.getStringArray(R.array.hoteis)
        val telefones = resources.getStringArray(R.array.telefones)
        val comoChegar = resources.getStringArray(R.array.como_chegar)
        val enderecos = resources.getStringArray(R.array.enderecos)

        val imagens = listOf(
            R.drawable.bandeira_acre,
            R.drawable.bandeira_alagoas,
            R.drawable.bandeira_amapa,
            R.drawable.bandeira_amazonas,
            R.drawable.bandeira_bahia,
            R.drawable.bandeira_ceara,
            R.drawable.bandeira_espirito_santo,
            R.drawable.bandeira_minas_gerais,
            R.drawable.bandeira_paraiba,
            R.drawable.bandeira_pernambuco
        )

        val destinos = mutableListOf<Destino>()
        for (i in nomes.indices) {
            destinos.add(Destino(nomes[i], descricoes[i], imagens[i], pacotes[i],
                hoteis[i], telefones[i], comoChegar[i], enderecos[i]))
        }

        val listView = findViewById<ListView>(R.id.listaDestinos)
        listView.adapter = DestinoAdapter(this, destinos)

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("destino", destinos[position])
            startActivity(intent)
        }
    }
}
