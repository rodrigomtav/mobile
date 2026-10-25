package com.example.guia_de_turismo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class DestinoAdapter(context: Context, lista: List<Destino>) : ArrayAdapter<Destino>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_destino, parent, false)
        }

        val destino = getItem(position)!!

        view!!.findViewById<ImageView>(R.id.imgBandeira).setImageResource(destino.imagem)
        view.findViewById<TextView>(R.id.txtNome).text = destino.nome
        view.findViewById<TextView>(R.id.txtDescricao).text = destino.descricao

        return view
    }
}
