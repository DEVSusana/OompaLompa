package com.oompa.loompa.view.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.oompa.loompa.data.model.OompaDetail

@Composable
fun displayOompaList(oompaList: List<OompaDetail>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        itemsIndexed(
            items = oompaList
        ){ index, item ->  
            OompaListItem(oompaDetail = item, index, selectedIndex){
                i -> selectedIndex = i
            }
        }
    }
}