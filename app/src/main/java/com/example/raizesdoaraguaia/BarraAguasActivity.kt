package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class BarraAguasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra_aguas)

        // Botão Localização
        val btnLocalizacao = findViewById<Button>(R.id.LocalizacaoAguas)
        btnLocalizacao.setOnClickListener {
            val origem = "-15.879977409487626,-52.21213097363188"
            val destino = "-15.890000,-52.270000"

            val uri = Uri.parse("https://www.google.com/maps/dir/$origem/$destino")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps") // Garante abrir no app Google Maps

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Se não tiver app Google Maps, abre no navegador
                val fallbackIntent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(fallbackIntent)
            }
        }

        // Botão Saiba Mais
        val btnSaibaMais = findViewById<Button>(R.id.btnSaibaMais)
        btnSaibaMais.setOnClickListener {
            val intent = Intent(this, AguasQuentesInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
