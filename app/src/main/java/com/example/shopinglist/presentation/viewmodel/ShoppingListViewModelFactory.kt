package com.example.shopinglist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopinglist.data.DaoProducts

class ShoppingListViewModelFactory(
    private val daoProducts: DaoProducts
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingListViewModel(daoProducts) as T
    }
}
