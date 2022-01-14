package br.ufrn.eaj.tads.exemplolistview

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fruta(var nome:String, var imagem:Int, var validade:String){
    @PrimaryKey (autoGenerate = true) var id:Long = 0
}