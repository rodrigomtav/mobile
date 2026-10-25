package com.example.guia_de_turismo

import java.io.Serializable

data class Destino(
    val nome: String,
    val descricao: String,
    val imagem: Int,
    val pacote: String,
    val hotel: String,
    val telefone: String,
    val comoChegar: String,
    val endereco: String
) : Serializable
