package com.oompa.loompa.domain.usecase

import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.domain.repository.OompaRepository

class GetListOompaUseCase(private val oompaRepository: OompaRepository) {
    suspend fun execute(page : Int): Resource<ApiResponse> {
        return oompaRepository.getOompaList(page)
    }
}