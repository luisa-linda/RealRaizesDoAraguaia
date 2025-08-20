package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PontalPraiaAraraActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pontal_praia_arara)

        val btnVoltar = findViewById<ImageView>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // fecha a tela atual para não empilhar
        }
        val btnLocation = findViewById<Button>(R.id.LocalizacaoPraiadaArara)

        btnLocation.setOnClickListener {
            val origem = "-15.908459191433277,-52.31534555415329"
            val destino = "-15.890000,-52.270000"

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