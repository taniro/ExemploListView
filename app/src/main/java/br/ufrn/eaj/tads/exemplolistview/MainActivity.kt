package br.ufrn.eaj.tads.exemplolistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import br.ufrn.eaj.tads.exemplolistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val db:AppDatabase by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "frutas.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    var listaFrutas:List<Fruta>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val f1 = Fruta ("Maça", R.drawable.fruit)
        val f2 = Fruta ("Pera", R.drawable.fruit)
        val f3 = Fruta ("Uva", R.drawable.fruit)

        with(db.frutaDao()){
            add(f1)
            add(f2)
            add(f3)
        }

        listaFrutas = db.frutaDao().listAll()

        //listview.adapter = FrutasAdapter(this, listaFrutas as List<Fruta>)

        val adapterView = FrutasAdapter(applicationContext, listaFrutas as List<Fruta>)
        //adapterView.listaFrutas = listaFrutas as List<Fruta>

        binding.listview.adapter = adapterView

        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val frutaSelecionada = listaFrutas?.get(position)
            Toast.makeText(this, "${frutaSelecionada?.nome} id=${frutaSelecionada?.id}", Toast.LENGTH_SHORT).show()
        }



        /*
        binding.listview.setOnItemClickListener{adapterView, view, i, l ->
            val frutaSelecionada = listaFrutas?.get(i)
            Toast.makeText(this, "${frutaSelecionada?.nome} id=${frutaSelecionada?.id}", Toast.LENGTH_SHORT).show()
        }

         */


        /*
        binding.gridview.adapter = FrutasAdapter(this, listaFrutas as List<Fruta>)
        binding.gridview.setOnItemClickListener{adapterView, view, i, l ->
            var frutaSelecionada = listaFrutas?.get(i)
            Toast.makeText(this, "${frutaSelecionada?.nome} id=${frutaSelecionada?.id}", Toast.LENGTH_SHORT).show()
        }

         */

    }
}
