package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class BarraAguasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra_aguas)

        val btnVoltar = findViewById<ImageView>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // fecha a tela atual para não empilhar
        }
        val btnLocation = findViewById<Button>(R.id.LocalizacaoAguas)

        btnLocation.setOnClickListener {
            // Origem e destino definidos por coordenadas
            val origem = "-15.879977409487626,-52.21213097363188"
            val destino = "-15.890000,-52.270000" // Ajuste conforme necessário

            // Cria a URI com a rota
            val uri = Uri.parse("https://www.google.com/maps/dir/$origem/$destino")

            // Cria o intent para abrir o Maps
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps") // Tenta abrir no Google Maps

            // Verifica se há app que suporta esse intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Fallback para abrir no navegador
                val fallbackIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(fallbackIntent)
            }
        }

    }
}