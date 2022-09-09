package com.example.shopinglist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Дата класс для хранения элемента списка покупок в кэше
 *
 * @property id Идентификатор элемента
 * @property name Название покупки
 * @property isChecked Статус покупки, куплена или нет
 */
@Entity
data class ProductRoomEntity(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "is_checked") val isChecked: Boolean = false
) {
    companion object {
        const val TABLE_NAME = "productRoomEntity"
    }
}
