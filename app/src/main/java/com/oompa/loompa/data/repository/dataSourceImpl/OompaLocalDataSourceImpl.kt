package com.oompa.loompa.data.repository.dataSourceImpl

import com.oompa.loompa.data.db.OompaLoompaDAO
import com.oompa.loompa.data.model.OompaDetail
import com.oompa.loompa.data.repository.dataSource.OompaLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OompaLocalDataSourceImpl @Inject constructor(private  val oompaLoompaDAO: OompaLoompaDAO): OompaLocalDataSource {
    override suspend fun saveOompaToDB(oompaDetail: OompaDetail) {
        oompaLoompaDAO.insert(oompaDetail)
    }

    override fun getSavedOompas(): Flow<List<OompaDetail>> {
        return oompaLoompaDAO.getAllOompa()
    }

    override suspend fun deleteOompaFromDB(oompaDetail: OompaDetail) {
        oompaLoompaDAO.deleteOompa(oompaDetail)
    }
}