package com.example.shopinglist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shopinglist.model.ProductRoomEntity

@Database(entities = [ProductRoomEntity::class], version = 1)
abstract class ShoppingListDatabase : RoomDatabase() {
    abstract fun productsDao(): DaoProducts

    companion object {
        const val DATABASE_NAME = "shopping_list_database"
    }
}
