package com.oompa.loompa.domain.usecase

import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository

class SaveDetailsOompaUseCase(private val oompaRepository: OompaRepository) {
    suspend fun execute(oompaDetail: OompaDetail)=oompaRepository.saveOompa(oompaDetail)

}