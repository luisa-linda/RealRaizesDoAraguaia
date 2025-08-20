package com.example.raizesdoaraguaia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnBarraAguas = findViewById<TextView>(R.id.btnBarraAguas)
        btnBarraAguas.setOnClickListener {
            val intent = Intent(this, BarraAguasActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        val intent = Intent(this, BarraSerraActivity::class.java)
        val btnBarraSerra = findViewById<Button>(R.id.btnBarraSerra)
        btnBarraSerra.setOnClickListener {
            val intent = Intent(this, BarraSerraActivity::class.java)
            startActivity(intent)
        }

        val btnPontalPraiaAraraActivity = findViewById<TextView>(R.id.btnPontalArara)
        btnPontalPraiaAraraActivity.setOnClickListener {
            val intent = Intent(this, PontalPraiaAraraActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }


        val btnPontalLago= findViewById<TextView>(R.id.btnPontalLago)
        btnPontalLago.setOnClickListener {
            val intent = Intent(this, PontalLago::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        val btnAragarcasPraia = findViewById<Button>(R.id.btnAragarcasPraia)

        btnAragarcasPraia.setOnClickListener {
            val intent = Intent(this, PraiaQuartoCrescenteActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        }
        val imgHome = findViewById<ImageView>(R.id.imgHome)

        imgHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // troca para a tela que você quer
            startActivity(intent)
        }
    }
}
