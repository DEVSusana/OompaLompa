package com.oompa.loompa.view


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository
import com.oompa.loompa.presentation.viewModel.OompaViewModel
import com.oompa.loompa.presentation.viewModel.OompaViewModelFactory
import com.oompa.loompa.view.compose.DisplayOompaList
import com.oompa.loompa.view.compose.NavigationComponent
import com.oompa.loompa.view.compose.ShowProgressBar
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
                        setContent {
                            val navController = rememberNavController()
                            NavigationComponent(navController = navController, oompaList = oompaList, viewModel)
                        }
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Toast.makeText(this, "An error occurred : $it", Toast.LENGTH_LONG).show()
                        Log.i("ERROR", it)
                    }
                }

                is Resource.Loading -> {
                    setContent {  
                        ShowProgressBar()
                    }
                    
                    
                }

            }
        })

    }

}

