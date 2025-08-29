package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PontalLago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontal_lago)

        val btnLocation = findViewById<Button>(R.id.Localizacaolago)

        btnLocation.setOnClickListener {
            val origem = "-15.916157839287973,-52.25957804760638"
            val destino = "-15.890000,-52.270000"
            val uri = Uri.parse("https://www.google.com/maps/dir/$origem/$destino")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")

            // Verifica se o Google Maps está instalado
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Se não estiver, abre no navegador padrão
                val fallbackIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(fallbackIntent)
            }
        }
    }
}
