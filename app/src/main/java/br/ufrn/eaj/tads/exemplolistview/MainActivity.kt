package br.ufrn.eaj.tads.exemplolistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val db:AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "frutas.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    var listaFrutas:List<Fruta>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var f1 = Fruta ("Maça", R.drawable.fruit)
        var f2 = Fruta ("Maça", R.drawable.fruit)
        var f3 = Fruta ("Maça", R.drawable.fruit)

        with(db.frutaDao()){
            add(f1)
            add(f2)
            add(f3)
        }

        listaFrutas = db.frutaDao().listAll()

        /*
        listview.adapter = FrutasAdapter(this, listaFrutas as List<Fruta>)
        listview.setOnItemClickListener{adapterView, view, i, l ->
            var frutaSelecionada = listaFrutas?.get(i)
            Toast.makeText(this, "${frutaSelecionada?.nome} id=${frutaSelecionada?.id}", Toast.LENGTH_SHORT).show()
        }
         */

        gridview.adapter = FrutasAdapter(this, listaFrutas as List<Fruta>)
        gridview.setOnItemClickListener{adapterView, view, i, l ->
            var frutaSelecionada = listaFrutas?.get(i)
            Toast.makeText(this, "${frutaSelecionada?.nome} id=${frutaSelecionada?.id}", Toast.LENGTH_SHORT).show()
        }

    }
}
