package br.ufrn.eaj.tads.exemplolistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FrutasAdapter(c: Context, f: List<Fruta>) : BaseAdapter() {

    var context:Context = c
    var frutas:List<Fruta> = f

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var v = LayoutInflater.from(context).inflate(R.layout.fruta_layout, parent, false)
        var nomeFruta = v.findViewById<TextView>(R.id.nomeFruta)
        var imageFruta = v.findViewById<ImageView>(R.id.imgFruta)

        var frutaAtual = frutas.get(position)

        nomeFruta.text = frutaAtual.nome
        imageFruta.setImageResource(frutaAtual.imagem)

        return v
    }

    override fun getItem(position: Int): Any {
        return frutas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return frutas.size
    }
}