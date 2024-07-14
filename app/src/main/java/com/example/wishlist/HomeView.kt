package com.example.wishlist

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlist.data.DummyWish
import com.example.wishlist.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(title = stringResource(id = R.string.app_name)) {
                Toast.makeText(context, "Wishlist", Toast.LENGTH_LONG).show()
            }
        },
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 20.dp),
                containerColor = colorResource(id = R.color.app_bar_color),
                contentColor = Color.White,
                onClick = {
                    navController.navigate(Screen.Add.route)
                    Toast.makeText(context, "Add", Toast.LENGTH_LONG).show()
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Your LazyColumn content here
            items(DummyWish.wishlist) { wish ->
                WishItem(wish = wish, onClick = {
                    navController.navigate(Screen.Add.route)
                })
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    val contentColor = MaterialTheme.colorScheme.onSurface
    Card(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(4.dp)), // Elevation
        shape = RoundedCornerShape(4.dp)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = wish.title,
                fontWeight = FontWeight.Companion.ExtraBold,
                color = contentColor
            )
            Text(text = wish.description, color = contentColor)
        }
    }
}