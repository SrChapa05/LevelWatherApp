package com.cristopher.levelwather

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class watherLevels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wather_levels)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencias a los elementos del layout
        val tvEstadoLed = findViewById<TextView>(R.id.tvEstadoLed)
        val btLed = findViewById<Button>(R.id.btLed)

        val tvEstadoAlarma = findViewById<TextView>(R.id.tvEstadoAlarma)
        val btAlarma = findViewById<Button>(R.id.btAlarma)

        val estadoNivel = findViewById<TextView>(R.id.Estado)
        val btRecalcular = findViewById<Button>(R.id.btRecalcular)

        // Estados simulados
        var ledEncendido = true
        var alarmaEncendida = true
        var nivelElevado = true

        // Botón LED
        btLed.setOnClickListener {
            ledEncendido = !ledEncendido
            tvEstadoLed.text = if (ledEncendido) "Encendido" else "Apagado"
        }

        // Botón Alarma
        btAlarma.setOnClickListener {
            alarmaEncendida = !alarmaEncendida
            tvEstadoAlarma.text = if (alarmaEncendida) "Encendido" else "Apagado"
        }

        // Botón Recalcular (simula cambio de nivel de agua)
        btRecalcular.setOnClickListener {
            nivelElevado = !nivelElevado
            estadoNivel.text = if (nivelElevado) "Elevado" else "Normal"
        }
    }
}

