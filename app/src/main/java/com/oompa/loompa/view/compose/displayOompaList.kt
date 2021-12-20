package com.oompa.loompa.view.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.oompa.loompa.data.model.OompaDetail

@Composable
fun displayOompaList(oompaList: List<OompaDetail>, selectedItem: (OompaDetail) -> Unit) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = oompaList,
            itemContent = {
                OompaListItem(oompaDetail = it, selectedItem)
            }
        )
    }
}