package com.oompa.loompa.view.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oompa.loompa.presentation.viewModel.OompaViewModel

@Composable
fun OompaDetailView(oompaViewModel: OompaViewModel, id: Int){
   oompaViewModel.getOompaLoompaDetail(id)
    val oompaDetail = oompaViewModel.getDetail.value?.data
    Row(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (oompaDetail != null) {
            oompaImage(oompaDetail = oompaDetail)
        }
        Column{
            if (oompaDetail != null) {
                Text(text = oompaDetail.firstName, style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = oompaDetail.lastName, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = oompaDetail.country, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = oompaDetail.profession,  style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}