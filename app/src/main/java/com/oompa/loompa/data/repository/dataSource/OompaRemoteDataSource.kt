package com.oompa.loompa.data.repository.dataSource

import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import retrofit2.Response

interface OompaRemoteDataSource {
    suspend fun getOompaLoompaList(page: Int):Response<ApiResponse>
    suspend fun getOompaLoompaDetails(id:Int):Response<OompaDetail>
}