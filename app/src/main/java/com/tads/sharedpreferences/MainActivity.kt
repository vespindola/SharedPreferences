package com.tads.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Vinicius Espindola - 01/05/2020

    private lateinit var textoNome: EditText
    private lateinit var botaoSalvar: Button
    private lateinit var textoExibicao: TextView
    private val ARQUIVO_PREFERENCIA: String = "ArquivoPreferencia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoNome = nome
        textoExibicao = resultado
        botaoSalvar = salvar

        botaoSalvar.setOnClickListener {
            val SharedPrefereces = getSharedPreferences(ARQUIVO_PREFERENCIA, 0)
            var editor = SharedPrefereces.edit()

            if (textoNome.text.toString().equals("")){
                Toast.makeText(applicationContext, "Por favor preencha o nome!", Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("nome", textoNome.text.toString())
                editor.apply()
                textoExibicao.setText("Olá, "+ textoNome.text.toString())
            }

        }

        val sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0)
        if(sharedPreferences.contains("nome")){
            var nomeUsuario = sharedPreferences.getString("nome", "Usuario não encontrado!")
            textoExibicao.setText("Olá, "+ nomeUsuario)
        }else{
            textoExibicao.setText("Olá, usuario não definido")
        }

    }
}
