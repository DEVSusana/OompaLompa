package com.oompa.loompa.data.repository.dataSource

import com.oompa.loompa.data.model.OompaDetail
import kotlinx.coroutines.flow.Flow

interface OompaLocalDataSource {
    suspend fun saveOompaToDB(oompaDetail: OompaDetail)
    fun getSavedOompas(): Flow<List<OompaDetail>>
    suspend fun deleteOompaFromDB(oompaDetail: OompaDetail)
}