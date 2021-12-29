package com.oompa.loompa.domain.usecase

import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository
import retrofit2.Response

class GetDetailsOompaUseCase(private val oompaRepository: OompaRepository) {
    suspend fun execute(id : Int): Resource<OompaDetail> {
        return oompaRepository.getOompaDetail(id)
    }
}