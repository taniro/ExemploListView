package br.ufrn.eaj.tads.exemplolistview

import android.content.Context
import android.util.Log
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

        /*
        Log.i("AULA", "Inflou ${position}")
        val v = LayoutInflater.from(context).inflate(R.layout.fruta_layout, parent, false)
        val nomeFruta = v.findViewById<TextView>(R.id.nomeFruta)
        val imageFruta = v.findViewById<ImageView>(R.id.imgFruta)
        val validadeFruta = v.findViewById<TextView>(R.id.valdadeFruta)
        val frutaAtual = frutas.get(position)
        nomeFruta.text = frutaAtual.nome
        imageFruta.setImageResource(frutaAtual.imagem)
        validadeFruta.text = frutaAtual.validade
        return v

         */
        val view:View
        val holder:FrutaViewHolder

        if (convertView == null){
            Log.i("AULA", "Inflou ${position}")
            view = LayoutInflater.from(parent.context).inflate(R.layout.fruta_layout, parent, false)
            holder = FrutaViewHolder(view)
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as FrutaViewHolder
        }

        val frutaEscolhida = frutas.get(position)

        holder.nomeFruta.text = frutaEscolhida.nome
        holder.imgFruta.setImageResource(frutaEscolhida.imagem)
        holder.validadeFruta.text = frutaEscolhida.validade
        return view
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



class FrutaViewHolder(v:View){
    var nomeFruta:TextView = v.findViewById(R.id.nomeFruta)
    var imgFruta:ImageView = v.findViewById(R.id.imgFruta)
    var validadeFruta:TextView = v.findViewById(R.id.valdadeFruta)

    /*
    init {
        nomeFruta = v.findViewById(R.id.nomeFruta)
        imgFruta = v.findViewById(R.id.imgFruta)
    }*/
}