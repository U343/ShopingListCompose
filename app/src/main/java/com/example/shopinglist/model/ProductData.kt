package com.example.shopinglist.model

/**
 * Дата класс для элемента списка покупок
 *
 * @property name Название покупки
 * @property isChecked Статус покупки, куплена или нет
 */
data class ProductData(
    val name: String,
    val isChecked: Boolean
)
