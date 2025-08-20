package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PraiaQuartoCrescenteActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_praiaquartocrescente)

        val btnVoltar = findViewById<ImageView>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // fecha a tela atual para não empilhar
        }
        val btnLocation = findViewById<Button>(R.id.LocalizacaoPraiaQuartoCrescente)

        btnLocation.setOnClickListener {
            val origem = "-15.892227932328467,-52.25228989776489"
            val destino = "-15.890000,-52.270000" // Altere aqui se quiser outro destino

            val uri = Uri.parse("https://www.google.com/maps/dir/$origem/$destino")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            // Verifica se há app que suporta esse intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Se não tiver, abre via navegador
                val fallbackIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(fallbackIntent)
            }
        }

        // Aqui você pode adicionar botões ou textos se quiser
    }
}