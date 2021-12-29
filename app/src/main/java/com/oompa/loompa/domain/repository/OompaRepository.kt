package com.oompa.loompa.domain.repository

import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.data.Utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface OompaRepository {
    suspend fun getOompaList(page: Int): Resource<ApiResponse>
    suspend fun getOompaDetail(id: Int): Resource<OompaDetail>

    suspend fun saveOompa(oompaDetail: OompaDetail)
    suspend fun deleteOompa(oompaDetail: OompaDetail)
    fun getOompaList(): Flow<List<OompaDetail>>
}