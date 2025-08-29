package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BarraSerraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra_serra)

        val btnLocation = findViewById<Button>(R.id.Localizacaoserra)

        btnLocation.setOnClickListener {
            val destino = "-15.66667,-55.00000" // Coordenadas da Serra do Roncador

            // Link para abrir rota do local atual até o destino
            val uri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination=$destino")

            val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                setPackage("com.google.android.apps.maps")
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Abre no navegador caso não tenha app Google Maps
                val fallbackIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(fallbackIntent)
            }

        }
    }
}
