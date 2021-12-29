package com.oompa.loompa.view.compose

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.presentation.viewModel.OompaViewModel
import com.oompa.loompa.view.MainActivity

@Composable
fun OompaDetailView(oompaViewModel: OompaViewModel, id: Int) {
    oompaViewModel.getOompaLoompaDetail(id)
    val oompaDetail = oompaViewModel.getDetail.value?.data

    when (oompaViewModel.getDetail.value) {
        is Resource.Success -> {
            oompaViewModel.getDetail.value?.data.let {
                Row(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (oompaDetail != null) {
                        oompaImage(oompaDetail = oompaDetail)
                    }
                    Column {
                        if (oompaDetail != null) {
                            Text(text = oompaDetail.firstName, style = MaterialTheme.typography.h3)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = oompaDetail.lastName, style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = oompaDetail.country, style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = oompaDetail.profession, style = MaterialTheme.typography.h5)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
        is Resource.Error -> {
            (oompaViewModel.getDetail.value as Resource.Error<OompaDetail>).message?.let {
                Toast.makeText(LocalContext.current, "An error occurred : $it", Toast.LENGTH_LONG).show()
                Log.i("ERROR", it)
            }
        }

        is Resource.Loading -> {
            ShowProgressBar()
        }

    }

}