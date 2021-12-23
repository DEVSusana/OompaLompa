package com.oompa.loompa.view

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.db.OompaLoompaDAO
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository
import com.oompa.loompa.domain.usecase.*
import com.oompa.loompa.presentation.viewModel.OompaViewModel
import com.oompa.loompa.presentation.viewModel.OompaViewModelFactory
import com.oompa.loompa.view.compose.OompaListItem
import com.oompa.loompa.view.compose.displayOompaList
import com.oompa.loompa.view.ui.theme.OompaLompaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var viewModel: OompaViewModel

    @Inject
    lateinit var viewModelFactory: OompaViewModelFactory

    @Inject
    lateinit var repository: OompaRepository


    private lateinit var oompaList: List<OompaDetail>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[OompaViewModel::class.java]
        viewModel.getOompaLoompaList(1)
        viewModel.getListOompa.observe(this, { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        oompaList = response.data.results
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading -> {
                    //CircularProgressIndicator()
                }

            }
        })
        setContent {
            displayOompaList(oompaList = oompaList) {

            }
        }
    }

}

