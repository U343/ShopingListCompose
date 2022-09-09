package com.example.shopinglist.presentation.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopinglist.R
import com.example.shopinglist.data.DaoProducts
import com.example.shopinglist.presentation.viewmodel.ShoppingListViewModel
import com.example.shopinglist.ui.theme.ShopingListTheme

@Composable
fun EditTextWithButton(
    viewModel: ShoppingListViewModel
) {
    val text = rememberSaveable { mutableStateOf("") }

    Surface(
        color = MaterialTheme.colors.primary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = text.value,
                onValueChange = { text.value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    textColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
                ),
                placeholder = { Text(stringResource(id = R.string.edit_text_label)) },
                modifier = Modifier.weight(1f),
            )
            OutlinedButton(
                onClick = { viewModel.addNewProduct(text.value) },
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(stringResource(id = R.string.add_button))
            }
        }
    }
}
