package com.example.wishlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppBarView(
                title =
                if (id == 0L) stringResource(id = R.string.add_wish)
                else stringResource(id = R.string.update_wish)
            ) {
                navController.navigateUp()
            }
        },
        backgroundColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = stringResource(id = R.string.title),
                value = viewModel.wishTitleState,
                onValueChange = { viewModel.onWishTitleChange(it) }
            )
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = stringResource(id = R.string.description),
                value = viewModel.wishDescriptionState,
                onValueChange = { viewModel.onWishDescriptionChange(it) }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if ((viewModel.wishTitleState.isNotEmpty()) && (viewModel.wishDescriptionState.isNotEmpty())) {
                        //TODO: Update Wish
                    } else {
                        //TODO: Add Wish
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.app_bar_color),
                )
            ) {
                Text(
                    text = if (id == 0L) stringResource(id = R.string.add_wish)
                    else stringResource(id = R.string.update_wish),
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    val contentColor = MaterialTheme.colorScheme.onSurface
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = contentColor) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = contentColor,
            cursorColor = colorResource(id = R.color.app_bar_color),
            focusedBorderColor = colorResource(id = R.color.app_bar_color),
            unfocusedBorderColor = Color.Gray
        ),
    )
}