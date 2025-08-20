package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PontalLago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontal_lago)

        val btnVoltar = findViewById<ImageView>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // fecha a tela atual para não empilhar
        }

        val btnLocation = findViewById<Button>(R.id.Localizacaolago)

        btnLocation.setOnClickListener {
            // Origem e destino definidos por coordenadas
            val origem = "-15.916157839287973,-52.25957804760638"
            val destino = "-15.890000,-52.270000"

            // Cria a URI com a rota
            val uri = Uri.parse("https://www.google.com/maps/dir/$origem/$destino")

            // Cria o intent para abrir o Maps
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps") // Abre no Google Maps, se instalado

            // Abre o Maps com a rota
            startActivity(intent)
        }

    }

}