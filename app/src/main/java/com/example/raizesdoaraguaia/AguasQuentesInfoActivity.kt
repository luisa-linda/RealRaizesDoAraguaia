package com.example.raizesdoaraguaia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AguasQuentesInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aguas_quentes_info)

        // Referência do botão
        val btnLocalizacao = findViewById<Button>(R.id.LocalizacaoAguas)

        // Ação ao clicar no botão para abrir o local exato pelo geo URI
        btnLocalizacao.setOnClickListener {
            // Coordenadas exatas do Parque das Águas Quentes, Barra do Garças
            val latitude = -15.8693
            val longitude = -52.2562

            // Uri com coordenadas, o "q" é o label que aparece no mapa
            val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude(Parque das Águas Quentes)")

            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }
        }
    }
}
