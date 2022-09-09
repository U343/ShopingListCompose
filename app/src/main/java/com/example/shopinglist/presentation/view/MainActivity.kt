package com.example.shopinglist.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.shopinglist.data.ShoppingListDatabase
import com.example.shopinglist.presentation.viewmodel.ShoppingListViewModel
import com.example.shopinglist.presentation.viewmodel.ShoppingListViewModelFactory
import com.example.shopinglist.ui.theme.ShopingListTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ShoppingListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resolveDependencies()
        viewModel.loadListFromCache()
        setContent {
            ShopingListTheme {
                EditTextWithButton(viewModel)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.updateCache()
    }

    private fun resolveDependencies() {
        val database = Room.databaseBuilder(
            baseContext,
            ShoppingListDatabase::class.java,
            ShoppingListDatabase.DATABASE_NAME
        ).build()
        viewModel = ViewModelProvider(this, ShoppingListViewModelFactory(database.productsDao()))
            .get(ShoppingListViewModel::class.java)
    }
}
