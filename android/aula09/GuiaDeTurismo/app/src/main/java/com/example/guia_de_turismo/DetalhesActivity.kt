package com.example.guia_de_turismo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val destino = intent.getSerializableExtra("destino") as Destino

        findViewById<ImageView>(R.id.imgDestino).setImageResource(destino.imagem)
        findViewById<TextView>(R.id.txtNome).text = destino.nome
        findViewById<TextView>(R.id.txtPacote).text = destino.pacote
        findViewById<TextView>(R.id.txtHotel).text = destino.hotel
        findViewById<TextView>(R.id.txtTelefone).text = destino.telefone
        findViewById<TextView>(R.id.txtComoChegar).text = destino.comoChegar

        // abre o discador
        findViewById<TextView>(R.id.txtTelefone).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + destino.telefone))
            startActivity(intent)
        }

        // abre o google maps
        findViewById<Button>(R.id.btnComoChegar).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + destino.endereco))
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        }

        // abre o app de email
        findViewById<Button>(R.id.btnEnviarMensagem).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + getString(R.string.email)))
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.assunto_email) + " " + destino.nome)
            startActivity(intent)
        }
    }
}
