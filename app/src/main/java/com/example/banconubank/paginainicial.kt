package com.example.banconubank

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView

class paginainicial : AppCompatActivity() {
    val COD_TELA = 2
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.paginainicial)

         var saldo =findViewById<TextView>(R.id.edtText)
         var faturacredito =findViewById<TextView>(R.id.faturacredito)
         saldo.setText("10000.00")
         faturacredito.setText("3020.00")

    }
    fun enviar(view: View){
        val editText=findViewById<TextView>(R.id.edtText)
        val mensagem = editText.text.toString()
        val intent = Intent(this, Tranferencia::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensagem)
        }
        startActivityForResult(intent,COD_TELA)
    }
    fun pix(view: View){
        val editText=findViewById<TextView>(R.id.edtText)
        val mensagem = editText.text.toString()
        val intent = Intent(this, pix::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensagem)

        }
       startActivityForResult(intent,COD_TELA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_TELA && resultCode == Activity.RESULT_OK){
            val txtSaldo = findViewById<TextView>(R.id.edtText)
            val sSaldo = data!!.getStringExtra("sSaldo")
            txtSaldo.setText(sSaldo)
        }
    }
    fun pagar(view: View){
        val editText=findViewById<TextView>(R.id.edtText)
        val mensagem = editText.text.toString()
        val intent = Intent(this, pagar::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensagem)
        }
        startActivityForResult(intent,COD_TELA)

    }


    fun depositar(view: View){
        val editText=findViewById<TextView>(R.id.edtText)
        val mensagem = editText.text.toString()
        val intent = Intent(this, Depositar::class.java).apply {
            putExtra(EXTRA_MESSAGE, mensagem)
        }
        startActivityForResult(intent,COD_TELA)

    }

}