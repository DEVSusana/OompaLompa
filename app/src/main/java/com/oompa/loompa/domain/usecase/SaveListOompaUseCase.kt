package com.oompa.loompa.domain.usecase

import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository
import kotlinx.coroutines.flow.Flow

class SaveListOompaUseCase(private val oompaRepository: OompaRepository) {
    fun execute(): Flow<List<OompaDetail>> {
        return oompaRepository.getOompaList()
    }
}