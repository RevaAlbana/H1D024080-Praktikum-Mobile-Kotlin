package com.pemmob.revaalbana.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import com.pemmob.revaalbana.R
import com.pemmob.revaalbana.data.dummy.DummyData
import com.pemmob.revaalbana.data.model.Category
import com.pemmob.revaalbana.data.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaftarProdukScreen(
    categories: List<Category>,
    products: List<Product>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Daftar Produk UMKM") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Keranjang"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Kategori Produk",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(
                        category = category,
                        isSelected = category.id == 1,
                        onClick = { }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Daftar Produk",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(products) { product ->
                    ProductItemCard(
                        product = product,
                        onClick = { }
                    )
                }
            }
        }
    }
}

@Composable
fun ProductItemCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable{ onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        val imageRes = when (product.name) {
            "Kripik Singkong" -> R.drawable.kripik_singkong
            "Mendoan" -> R.drawable.mendoan
            "Sale Pisang" -> R.drawable.sale_pisang
            "Getuk Goreng" -> R.drawable.getuk_goreng
            "Nopia" -> R.drawable.nopia
            "Es Dawet" -> R.drawable.es_dawet
            "Kopi Robusta" -> R.drawable.kopi_robusta
            "Wedang Jahe" -> R.drawable.wedang_jahe
            "Teh Poci" -> R.drawable.teh_poci
            "Sirup Stroberi" -> R.drawable.sirup_strawberry
            "Batik Purbalingga" -> R.drawable.batik_purbalingga
            "Sandal Bandol" -> R.drawable.sandal_bandol
            "Sapu Glagah" -> R.drawable.sapu_glagah
            "Gantungan Kunci" -> R.drawable.gantungan_kunci
            "Tas Rajut" -> R.drawable.tas_rajut

            else -> R.mipmap.ic_launcher_foreground
        }

        Column(
            modifier = Modifier.padding(all = 12.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = product.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(shape = RoundedCornerShape(size = 8.dp))
                        .background(color = androidx.compose.ui.graphics.Color.White),
                    contentScale = ContentScale.Fit
                )

                if (product.category != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(all = 8.dp)
                            .clip(shape = RoundedCornerShape(size = 4.dp))
                            .background(color = MaterialTheme.colorScheme.secondary)
                    ) {
                        Text(
                            text = product.category.name,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Rp ${product.price}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun CategoryItem(category: Category, isSelected: Boolean = false, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(50))
            .background(color = backgroundColor)
            .clickable {}
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = category.name,
            color = textColor,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    MaterialTheme {
        Row(modifier = Modifier.padding(16.dp)) {
            CategoryItem(
                category = Category(
                    id = 1,
                    name = "Makanan",
                    description = "Kategori makanan ringan UMKM",
                    products_count = 10
                ),
                isSelected = true,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemCardPreview() {
    MaterialTheme {
        Box(modifier = Modifier.width(180.dp).padding(16.dp)) {
            ProductItemCard(
                product = Product(
                    id = 1,
                    category_id = 1,
                    category = Category(
                        id = 1,
                        name = "Makanan",
                        description = null,
                        products_count = null
                    ),
                    name = "Kripik Singkong",
                    description = "Kripik singkong gurih dan renyah",
                    price = 15000.0,
                    stock = 15,
                    img = "dummy_product"
                ),
                onClick = {}
            )
        }
    }
}