package com.oompa.loompa.data.api

import com.oompa.loompa.data.model.ApiResponse
import com.oompa.loompa.data.model.OompaDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OompaApiService {
    @GET("")
    suspend fun getOompaLoompaList(
        @Query("page")
        page:Int
    ): Response<ApiResponse>

    @GET("/{id}")
    suspend fun getOompaLoompaDetails(
        @Path("id")
        id:Int
    ): Response<OompaDetail>
}