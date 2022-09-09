package com.example.shopinglist.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.data.DaoProducts
import com.example.shopinglist.model.ProductData
import com.example.shopinglist.model.ProductRoomEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * [ViewModel] экрана списка покупок
 */
class ShoppingListViewModel(
    private val daoProducts: DaoProducts
) : ViewModel() {

    var shoppingList: List<ProductData> by mutableStateOf(emptyList())
        private set

    fun loadListFromCache() {
        viewModelScope.launch(Dispatchers.IO) {
            shoppingList = daoProducts.getAll().map { product ->
                ProductData(
                    product.name,
                    product.isChecked
                )
            }
        }
    }

    fun addNewProduct(name: String) {
        val newProducts = shoppingList.toMutableList()
        newProducts.add(
            0,
            ProductData(
                name = name,
                isChecked = false
            )
        )
        shoppingList = newProducts
    }

    fun updateCache() {
        viewModelScope.launch(Dispatchers.IO) {
            daoProducts.deleteAll()
            daoProducts.insertAll(
                shoppingList.map { product ->
                    ProductRoomEntity(
                        name = product.name,
                        isChecked = product.isChecked
                    )
                }
            )
        }
    }
}
