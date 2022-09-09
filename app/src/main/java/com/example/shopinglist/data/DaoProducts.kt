package com.example.shopinglist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shopinglist.model.ProductRoomEntity

/**
 * Дао для работы с сохранным списком покупок
 */
@Dao
interface DaoProducts {

    @Query("SELECT * FROM ${ProductRoomEntity.TABLE_NAME}")
    suspend fun getAll(): List<ProductRoomEntity>

    @Query("DELETE FROM ${ProductRoomEntity.TABLE_NAME}")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(products: List<ProductRoomEntity>)
}
