package com.oompa.loompa.presentation.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oompa.loompa.domain.usecase.*
import javax.inject.Inject

class OompaViewModelFactory @Inject constructor(
    private val app: Application,
    private val deleteListOompaUseCase: DeleteListOompaUseCase,
    private val getDetailsOompaUseCase: GetDetailsOompaUseCase,
    private val getListOompaUseCase: GetListOompaUseCase,
    private val saveDetailsOompaUseCase: SaveDetailsOompaUseCase,
    private val saveListOompaUseCase: SaveListOompaUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(
            Application::class.java,
            DeleteListOompaUseCase::class.java,
            GetDetailsOompaUseCase::class.java,
            GetListOompaUseCase::class.java,
            SaveDetailsOompaUseCase::class.java,
            SaveListOompaUseCase::class.java
        )
            .newInstance(
                app,
                deleteListOompaUseCase,
                getDetailsOompaUseCase,
                getListOompaUseCase,
                saveDetailsOompaUseCase,
                saveListOompaUseCase
            )
    }
}