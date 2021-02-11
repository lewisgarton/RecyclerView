package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class BarcodeItem(val barcode: String, val quantity: String)

val testData = listOf(
        BarcodeItem("347259327498743423", "1"),
        BarcodeItem("875439879379847579", "1"),
        BarcodeItem("745987395793745989", "3"),
        BarcodeItem("057293457573497979", "4"),
        BarcodeItem("745987395793745989", "2"),
        BarcodeItem("345356352644536434", "6"),
        BarcodeItem("234523423425234242", "1"),
        BarcodeItem("347259327498743423", "1"),
        BarcodeItem("875439879379847579", "1"),
        BarcodeItem("745987395793745989", "3"),
        BarcodeItem("057293457573497979", "4"),
        BarcodeItem("745987395793745989", "2"),
        BarcodeItem("345356352644536434", "6"),
        BarcodeItem("234523423425234242", "1"),
        BarcodeItem("347259327498743423", "1"),
        BarcodeItem("875439879379847579", "1"),
        BarcodeItem("745987395793745989", "3"),
        BarcodeItem("057293457573497979", "4"),
        BarcodeItem("745987395793745989", "2"),
        BarcodeItem("345356352644536434", "6"),
        BarcodeItem("234523423425234242", "1"),
        BarcodeItem("347259327498743423", "1"),
        BarcodeItem("875439879379847579", "1"),
        BarcodeItem("745987395793745989", "3"),
        BarcodeItem("057293457573497979", "4"),
        BarcodeItem("745987395793745989", "2"),
        BarcodeItem("345356352644536434", "6"),
        BarcodeItem("234523423425234242", "1")
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                BarcodeRecycler(barcodes = testData)
            }
        }
    }

    @Composable
    fun BarcodeRecycler(barcodes: List<BarcodeItem>, modifier: Modifier = Modifier) {
        Column(modifier = Modifier.fillMaxHeight()) {

            Column(modifier = Modifier.weight(0.5F)) {
                BarcodeRecyclerHeading()
                Divider(color = Color.DarkGray, thickness = 1.dp)
            }

            LazyColumn(modifier = Modifier.weight(9.5F)) {
                items(barcodes) {
                    BarcodeCard(it.barcode, it.quantity)
                    Divider()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BarcodeRecyclerPreview(modifier: Modifier = Modifier) = MaterialTheme {
        BarcodeRecycler(testData)
    }

    @Composable
    fun BarcodeRecyclerHeading() {
        Row(modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp)) {
            Text(text = "Barcode",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(8F),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface
            )

            Text(text = "Quantity",
                    modifier = Modifier.weight(2F),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSurface
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BarcodeRecyclerHeadingPreview() = MaterialTheme {
        BarcodeRecyclerHeading()
    }

    @Composable
    fun BarcodeCard(barcode: String, quantity: String, modifier: Modifier = Modifier) {
        Row(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), verticalAlignment = Alignment.CenterVertically) {

            Text(text = barcode,
                    modifier = Modifier
                            .weight(8F),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary
            )


            Text(text = quantity,
                    modifier = Modifier
                            .weight(2F),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun BarcodeCardPreview() {
        MaterialTheme() {
            BarcodeCard("092850986953842245", "3")
        }
    }
}
























