package br.ufrn.eaj.tads.exemplolistview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class NovoFrutasAdapter(/*var listaFrutas: List<Fruta>*/) : BaseAdapter() {

    var listaFrutas : List<Fruta> = ArrayList()

    override fun getCount(): Int {
        return listaFrutas.size
    }

    override fun getItem(position: Int): Fruta {
        return listaFrutas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.fruta_layout, parent, false)


        val nomeFruta = view.findViewById<TextView>(R.id.nomeFruta)
        val imgFruta = view.findViewById<ImageView>(R.id.imgFruta)
        val validadeFruta = view.findViewById<TextView>(R.id.valdadeFruta)

        val frutaAtual = listaFrutas.get(position)

        Log.i("AULA", "Inflou a View na posicao ${position}")


        nomeFruta.text = frutaAtual.nome
        imgFruta.setImageResource(frutaAtual.imagem)
        validadeFruta.text = frutaAtual.validade

        return view
    }
}