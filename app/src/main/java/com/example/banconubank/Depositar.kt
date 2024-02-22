package com.example.banconubank

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class Depositar: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depositar)
        setSupportActionBar(findViewById(R.id.toolbar6))
        val mensagem = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.txtMensagem4).apply {
            text = mensagem
        }
        var saldo = mensagem
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.btnconfir)
        btConf.setOnClickListener {
            val data = Intent()
            var valorpag = findViewById<EditText>(R.id.valordeposito)
            var senha = 1234
            var senhacolocada = findViewById<EditText>(R.id.senha)
            var senhacolocadan = senhacolocada?.text.toString().toInt()
            var valorpagn = valorpag?.text.toString().toDouble()
            if (senha == senhacolocadan) {
                if (nsaldo < valorpagn) {
                    Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
                } else {
                    nsaldo += valorpagn
                    var txtSaldo = nsaldo.toString()
                    textView.setText(txtSaldo)
                    data.putExtra("sSaldo", txtSaldo)
                    setResult(Activity.RESULT_OK, data)
                    Toast.makeText(this, "$txtSaldo", Toast.LENGTH_SHORT).show()
                    valorpag.setText("".toString())
                    finish()
                }
            } else{
                Toast.makeText(this, "SENHA INCORRETA", Toast.LENGTH_SHORT).show()

            }
        }
    }
}