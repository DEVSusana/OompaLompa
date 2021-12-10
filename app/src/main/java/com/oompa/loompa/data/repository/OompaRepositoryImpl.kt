package com.oompa.loompa.data.repository

import com.oompa.loompa.data.Utils.Resource
import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.data.repository.dataSource.OompaLocalDataSource
import com.oompa.loompa.data.repository.dataSource.OompaRemoteDataSource
import com.oompa.loompa.domain.repository.OompaRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class OompaRepositoryImpl(
    private val oompaRemoteDataSource: OompaRemoteDataSource,
    private val oompaLocalDataSource: OompaLocalDataSource
): OompaRepository {


    override suspend fun getOompaList(
        page: Int
    ): Resource<ApiResponse> {
        return responseToResource(
            oompaRemoteDataSource.getOompaLoompaList(page)
        )
    }

    private fun responseToResource(response: Response<ApiResponse>):Resource<ApiResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getOompaDetail(id: Int): Response<OompaDetail> {
       return oompaRemoteDataSource.getOompaLoompaDetails(id)
    }

    override fun getOompaList(): Flow<List<OompaDetail>> {
        return oompaLocalDataSource.getSavedOompas()
    }



    override suspend fun saveOompa(oompaDetail: OompaDetail) {
        return oompaLocalDataSource.saveOompaToDB(oompaDetail)
    }

    override suspend fun deleteOompa(oompaDetail: OompaDetail) {
        return oompaLocalDataSource.deleteOompaFromDB(oompaDetail)
    }
}