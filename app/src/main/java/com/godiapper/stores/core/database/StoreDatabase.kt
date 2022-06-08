package com.godiapper.stores.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.godiapper.stores.core.database.StoreDao
import com.godiapper.stores.core.entities.StoreEntity

@Database(entities = arrayOf(StoreEntity::class), version = 2)
abstract class StoreDatabase: RoomDatabase() {
    abstract fun storeDao(): StoreDao
}