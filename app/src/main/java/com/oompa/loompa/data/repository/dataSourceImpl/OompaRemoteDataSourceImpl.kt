package com.oompa.loompa.data.repository.dataSourceImpl

import com.oompa.loompa.data.api.OompaApiService
import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.data.repository.dataSource.OompaRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OompaRemoteDataSourceImpl @Inject constructor(private val oompaApiService: OompaApiService):
    OompaRemoteDataSource {
    override suspend fun getOompaLoompaList(page: Int): Response<ApiResponse> {
        return oompaApiService.getOompaLoompaList(page)
    }

    override suspend fun getOompaLoompaDetails(id: Int): Response<OompaDetail> {
        return oompaApiService.getOompaLoompaDetails(id)
    }
}