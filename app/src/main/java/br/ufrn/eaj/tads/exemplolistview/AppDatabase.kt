package br.ufrn.eaj.tads.exemplolistview

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Fruta::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun frutaDao():FrutaDao
}