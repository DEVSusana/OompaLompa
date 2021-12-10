package com.oompa.loompa.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oompa.loompa.domain.usecase.*

class OompaViewModelFactory (
    private val app: Application,
    private val deleteListOompaUseCase: DeleteListOompaUseCase,
    private val getDetailsOompaUseCase: GetDetailsOompaUseCase,
    private val getListOompaUseCase: GetListOompaUseCase,
    private val saveDetailsOompaUseCase: SaveDetailsOompaUseCase,
    private val saveListOompaUseCase: SaveListOompaUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OompaViewModel(
            app,
            deleteListOompaUseCase,
            getDetailsOompaUseCase,
            getListOompaUseCase,
            saveDetailsOompaUseCase,
            saveListOompaUseCase
        ) as T
    }
}