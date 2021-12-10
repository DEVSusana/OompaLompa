package com.oompa.loompa.data.db

import androidx.room.*
import com.oompa.loompa.data.model.OompaDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface OompaLoompaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(oompaLoompa: OompaDetail)

    @Query("SELECT * FROM oompaLoompas")
    fun getAllOompa(): Flow<List<OompaDetail>>

    @Delete
    suspend fun deleteOompa(oompaLoompa: OompaDetail)
}