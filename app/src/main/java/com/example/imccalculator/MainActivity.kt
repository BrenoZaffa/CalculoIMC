package com.example.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var peso1: EditText
    lateinit var altura1: EditText
    lateinit var calcular: Button
    lateinit var titulo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        peso1 = findViewById(R.id.peso)
        altura1 = findViewById(R.id.altura)
        calcular = findViewById(R.id.calcular)
        titulo = findViewById(R.id.titulo)
        calcula()
    }
    private fun calcula(){
        calcular.setOnClickListener {
            calcularIMC(peso1.text.toString(),altura1.text.toString())
        }
    }
    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(peso != null && altura != null){
            val imc = peso/(altura*altura)
            titulo.setTextColor(resources.getColor(R.color.white))
            if(imc < 18.5){
                titulo.setBackgroundColor(resources.getColor(R.color.abaixo))
                titulo.text = "Seu IMC é: \n%.2f. Abaixo".format(imc)}
            else if(imc >=18.5 && imc <25){
                titulo.setBackgroundColor(resources.getColor(R.color.normal))
                titulo.text = "Seu IMC é: \n%.2f. Normal".format(imc)}
            else if(imc >=25 && imc <30){
                titulo.setBackgroundColor(resources.getColor(R.color.acima))
                titulo.text = "Seu IMC é: \n%.2f. Acima".format(imc)}
            else{
                titulo.setBackgroundColor(resources.getColor(R.color.obesa))
                titulo.text = "Seu IMC é: \n%.2f. Obeso".format(imc)}
        }
    }

}