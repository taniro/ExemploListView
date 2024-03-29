package br.ufrn.eaj.tads.exemplolistview

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FrutaDao{

    @Insert
    fun add(f:Fruta) : Long

    @Query("SELECT * FROM Fruta")
    fun listAll() : List<Fruta>
}